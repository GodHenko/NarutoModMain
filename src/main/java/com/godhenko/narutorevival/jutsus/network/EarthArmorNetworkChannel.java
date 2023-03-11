package com.godhenko.narutorevival.jutsus.network;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.extra.StatNetworkChannel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class EarthArmorNetworkChannel {
    private static SimpleChannel INSTANCE;
    private static final String VERSION = "1";
    private static int packetId = 0;

    public static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel channel = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(NarutoRevival.NAMESPACE, "earth_armor_channel"))
                .networkProtocolVersion(() -> VERSION)
                .clientAcceptedVersions((version) -> VERSION.equals(version))
                .serverAcceptedVersions((version) -> VERSION.equals(version))
                .simpleChannel();

        channel.messageBuilder(UpdateEarthArmorPacket.class, StatNetworkChannel.id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(UpdateEarthArmorPacket::new)
                .encoder(UpdateEarthArmorPacket::toBytes)
                .consumer(UpdateEarthArmorPacket::handle)
                .add();

        INSTANCE = channel;
    }

    public static SimpleChannel getInstance() {
        return INSTANCE;
    }

    public static <PACKET> void sendS2C(PACKET packet, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }

    public static <PACKET> void sendS2C(PACKET packet) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), packet);
    }

    public static <PACKET> void sendC2S(PACKET packet) {
        INSTANCE.sendToServer(packet);
    }
}