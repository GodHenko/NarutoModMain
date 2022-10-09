package com.godhenko.narutorevival.chakra.network;

import com.godhenko.narutorevival.NarutoRevival;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ChakraNetworkChannel {
    private static SimpleChannel INSTANCE;
    private static final String VERSION = "1";
    private static int packetId = 0;

    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel channel = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(NarutoRevival.NAMESPACE, "chakra_channel"))
                .networkProtocolVersion(() -> VERSION)
                .clientAcceptedVersions((version) -> VERSION.equals(version))
                .serverAcceptedVersions((version) -> VERSION.equals(version))
                .simpleChannel();

        channel.messageBuilder(UpdateChakraPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(UpdateChakraPacket::new)
                .encoder(UpdateChakraPacket::toBytes)
                .consumer(UpdateChakraPacket::handle)
                .add();

        channel.messageBuilder(GatherChakraPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(GatherChakraPacket::new)
                .encoder(GatherChakraPacket::toBytes)
                .consumer(GatherChakraPacket::handle)
                .add();

        INSTANCE = channel;
    }

    public static <PACKET> void sendS2C(PACKET packet, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }

    public static <PACKET> void sendC2S(PACKET packet) {
        INSTANCE.sendToServer(packet);
    }
}
