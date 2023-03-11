package com.godhenko.narutorevival.network.extra;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.extra.misc.StatNetworkPackets;
import com.godhenko.narutorevival.network.extra.stat.UpdateStatPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class StatNetworkChannel {
    private static SimpleChannel INSTANCE;
    private static final String VERSION = "1";
    private static int packetId = 0;

    public static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel channel = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(NarutoRevival.MOD_ID, "stat_channel"))
                .networkProtocolVersion(() -> VERSION)
                .clientAcceptedVersions((version) -> VERSION.equals(version))
                .serverAcceptedVersions((version) -> VERSION.equals(version))
                .simpleChannel();

        channel.messageBuilder(UpdateStatPacket.class, StatNetworkChannel.id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(UpdateStatPacket::new)
                .encoder(UpdateStatPacket::toBytes)
                .consumer(UpdateStatPacket::handle)
                .add();

        INSTANCE = channel;

        StatNetworkPackets.register();
    }

    public static SimpleChannel getInstance() {
        return INSTANCE;
    }

    public static <PACKET> void sendS2C(PACKET packet, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }

    public static <PACKET> void sendC2S(PACKET packet) {
        INSTANCE.sendToServer(packet);
    }
}
