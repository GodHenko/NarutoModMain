package com.godhenko.narutomod.util;

import net.minecraft.world.entity.player.Player;

import java.util.Optional;

public interface IProxy {

    /**
     * @return An optional with empty conditional being a server player and a result being the client player.
     */
    Optional<Player> player();
}