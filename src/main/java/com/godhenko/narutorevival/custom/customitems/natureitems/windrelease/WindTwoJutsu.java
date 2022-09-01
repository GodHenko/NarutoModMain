package com.godhenko.narutorevival.custom.customitems.natureitems.windrelease;


import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.AirBurstProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class WindTwoJutsu implements Jutsu {
    @Override
    public void cast(Player player, Level world) {
        if (world.isClientSide()) return;

        world.addFreshEntity(new AirBurstProjectile(player, 3, world));
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
