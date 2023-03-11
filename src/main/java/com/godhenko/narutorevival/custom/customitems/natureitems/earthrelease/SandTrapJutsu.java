package com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;

import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.projectile.EarthTrapProjectile;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SandTrapJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 2;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.EARTH;
    }

    @Override
    public InteractionResult cast(Player player, Level world, int level) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!Stats.CHAKRA.get().getManager().decreaseIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        world.addFreshEntity(new EarthTrapProjectile(player, level*0.8, world));

        return InteractionResult.SUCCESS;
    }

    @Override
    public int attackDamage(int level) {
        return 6;
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
