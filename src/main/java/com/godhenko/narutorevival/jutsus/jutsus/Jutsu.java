package com.godhenko.narutorevival.jutsus.jutsus;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface Jutsu {
    void cast(Player player, Level world);
    void tick(Player player, Level world);
    Jutsu init();
}
