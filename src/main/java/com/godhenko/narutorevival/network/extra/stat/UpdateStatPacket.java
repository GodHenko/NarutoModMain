package com.godhenko.narutorevival.network.extra.stat;

import com.godhenko.narutorevival.network.extra.client.ClientPlayerStats;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateStatPacket {
    private final float stat;
    private final String id;

    public UpdateStatPacket(String id, float amount) {
        this.id = id;
        this.stat = amount;
    }

    public UpdateStatPacket(FriendlyByteBuf buf) {
        this.stat = buf.readFloat();
        this.id = buf.readUtf();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeFloat(stat);
        buf.writeUtf(id);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            ClientPlayerStats.get(id).set(stat);
        });
        return true;
    }
}
