package com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.projectile.SharkProjectile;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class WaterSharkJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 2;
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

        float power = world.isRainingAt(player.blockPosition()) ? level*2 : level*1.5f;
        world.addFreshEntity(new SharkProjectile(player, power, world));

        return InteractionResult.SUCCESS;
    }

    @Override
    public int attackDamage(int level) {
        return 10;
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
