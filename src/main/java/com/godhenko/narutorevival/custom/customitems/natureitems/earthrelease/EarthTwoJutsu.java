package com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease;

import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.EarthTrapProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EarthTwoJutsu implements Jutsu {

    @Override
    public void cast(Player player, Level world) {
        if (world.isClientSide()) return;

        world.addFreshEntity(new EarthTrapProjectile(player, 2, world));
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
