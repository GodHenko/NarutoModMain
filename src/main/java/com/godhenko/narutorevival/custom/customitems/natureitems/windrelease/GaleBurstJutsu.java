package com.godhenko.narutorevival.custom.customitems.natureitems.windrelease;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.projectile.AirBurstProjectile;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class GaleBurstJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 2;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.WIND;
    }

    @Override
    public InteractionResult cast(Player player, Level world, int level) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!Stats.CHAKRA.get().getManager().decreaseIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        world.addFreshEntity(new AirBurstProjectile(player, level*1.5f, world));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
