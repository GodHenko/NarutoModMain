package com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves;

import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.SharkProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class WaterTwoJutsu implements Jutsu {

    @Override
    public void cast(Player player, Level world) {
        if (world.isClientSide()) return;

        float power = world.isRainingAt(player.blockPosition()) ? 4f : 3.5f;
        world.addFreshEntity(new SharkProjectile(player, 10, world));

    }


    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
