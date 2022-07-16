package com.godhenko.narutomod.client;

import com.godhenko.narutomod.util.IProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

import java.util.Optional;

public class ClientProxy implements IProxy {

    @Override
    public Optional<Player> player() {
        return Optional.ofNullable(Minecraft.getInstance().player);
    }
}