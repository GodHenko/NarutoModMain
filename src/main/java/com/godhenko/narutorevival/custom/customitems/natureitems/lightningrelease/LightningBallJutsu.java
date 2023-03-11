package com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease;


import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.projectile.LightningBallProjectile;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class LightningBallJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 2;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.LIGHTNING;
    }

    @Override
    public InteractionResult cast(Player player, Level world, int level) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!Stats.CHAKRA.get().getManager().decreaseIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        world.addFreshEntity(new LightningBallProjectile(player, 3.5, world));

        return InteractionResult.SUCCESS;
    }

    @Override
    public int attackDamage(int level) {
        return 2;
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
