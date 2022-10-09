package com.godhenko.narutorevival.chakra.network;

import com.godhenko.narutorevival.chakra.ChakraManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GatherChakraPacket {
    public GatherChakraPacket() {}
    public GatherChakraPacket(FriendlyByteBuf buf) {}
    public void toBytes(FriendlyByteBuf buf) {}

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            ServerPlayer player = ctx.getSender();
            if (player == null) return;

            ChakraManager.addChakraOverTime(player, 3);
        });
        return true;
    }
}
