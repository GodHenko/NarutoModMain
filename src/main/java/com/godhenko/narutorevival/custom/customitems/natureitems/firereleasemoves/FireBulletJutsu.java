package com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves;


import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.AirBurstProjectile;
import com.godhenko.narutorevival.projectile.FireBulletProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class FireBulletJutsu implements Jutsu {
    @Override
    public void cast(Player player, Level world) {
        if (world.isClientSide()) return;

        world.addFreshEntity(new FireBulletProjectile(player, 6, world));
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
