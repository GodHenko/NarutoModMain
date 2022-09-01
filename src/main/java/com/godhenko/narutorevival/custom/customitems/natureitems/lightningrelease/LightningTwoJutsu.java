package com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease;

import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.LightningBallProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class LightningTwoJutsu implements Jutsu {

    @Override
    public void cast(Player player, Level world) {
        if (world.isClientSide()) return;

        world.addFreshEntity(new LightningBallProjectile(player, 3.5, world));
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
