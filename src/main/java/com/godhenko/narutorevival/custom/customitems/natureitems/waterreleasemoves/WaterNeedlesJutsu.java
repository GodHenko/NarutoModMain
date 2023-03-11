package com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.projectile.IceNeedlesProjectile;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WaterNeedlesJutsu implements Jutsu {
    @Override
    public int jutsuLevel() {
        return 3;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.WATER;
    }

    @Override
    public InteractionResult cast(Player player, Level world, int level) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!Stats.CHAKRA.get().getManager().decreaseIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        if (JutsuTicker.isTicking(this, player)) {
            JutsuTicker.stopTicking(this, player);
        } else {
            JutsuTicker.startTicking(this, player);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public int attackDamage(int level) {
        return 6;
    }

    @Override
    public int chakraCost(@Nullable Player player, Level world) {
        return 1;
    }

    @Override
    public void tick(Player player, Level world) {
        if (world.isClientSide()) {
            return;
        }

        if (!Stats.CHAKRA.get().getManager().decreaseOverTimeIfEnough(player, chakraCost(player, world))) {
            JutsuTicker.stopTicking(this, player);
            return;
        }

        world.addFreshEntity(new IceNeedlesProjectile(player, 15f, world));
    }

    @Override
    public Jutsu init() {
        JutsuTicker.registerPlayerTicker(this);
        return this;
    }
}
