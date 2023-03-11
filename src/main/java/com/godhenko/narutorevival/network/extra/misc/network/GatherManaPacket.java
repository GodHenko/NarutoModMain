package com.godhenko.narutorevival.network.extra.misc.network;


import com.godhenko.narutorevival.network.extra.Stats;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GatherManaPacket {
    public GatherManaPacket() {}

    public GatherManaPacket(FriendlyByteBuf buf) {}

    public void toBytes(FriendlyByteBuf buf) {}

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            ServerPlayer player = ctx.getSender();
            if (player == null) return;

            Stats.CHAKRA.get().getManager().addOverTime(player, 3);
        });
        return true;
    }
}
