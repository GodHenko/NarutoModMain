package com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves;


import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.FireBulletProjectile;
import com.godhenko.narutorevival.projectile.PhoenixFireProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class PhoenixFireJutsu implements Jutsu {

    @Override
    public void cast(Player player, Level world) {
        if (world.isClientSide()) return;

        world.addFreshEntity(new PhoenixFireProjectile(player, 6, world));

    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
