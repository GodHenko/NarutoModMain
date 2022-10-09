package com.godhenko.narutorevival.chakra.network;

import com.godhenko.narutorevival.chakra.client.ClientPlayerChakra;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateChakraPacket {
    private final float chakra;

    public UpdateChakraPacket(float chakra) {
        this.chakra = chakra;
    }

    public UpdateChakraPacket(FriendlyByteBuf buf) {
        this.chakra = buf.readFloat();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeFloat(chakra);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            ClientPlayerChakra.setChakra(chakra);
        });
        return true;
    }
}
