package com.godhenko.narutorevival.network.extra.misc;


import com.godhenko.narutorevival.network.extra.StatNetworkChannel;
import com.godhenko.narutorevival.network.extra.misc.network.GatherManaPacket;
import net.minecraftforge.network.NetworkDirection;

public class StatNetworkPackets {
    public static void register() {
        StatNetworkChannel.getInstance().messageBuilder(GatherManaPacket.class, StatNetworkChannel.id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(GatherManaPacket::new)
                .encoder(GatherManaPacket::toBytes)
                .consumer(GatherManaPacket::handle)
                .add();
    }
}
