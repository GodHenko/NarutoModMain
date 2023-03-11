package com.godhenko.narutorevival.jutsus.network;

import com.godhenko.narutorevival.jutsus.client.ClientEarthArmorPlayers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateEarthArmorPacket {
    private final boolean isOn;
    private final String username;

    public UpdateEarthArmorPacket(boolean isOn, String username) {
        this.isOn = isOn;
        this.username = username;
    }

    public UpdateEarthArmorPacket(FriendlyByteBuf buf) {
        this.isOn = buf.readBoolean();
        this.username = buf.readUtf();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(isOn);
        buf.writeUtf(username);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            ClientEarthArmorPlayers.set(username, isOn);
        });
        return true;
    }
}
