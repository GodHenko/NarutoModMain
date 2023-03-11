package com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import com.godhenko.narutorevival.network.extra.Stats;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class LariatJutsu implements Jutsu {
    @Override
    public int jutsuLevel() {
        return 1;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.LIGHTNING;
    }

    @Override
    public InteractionResult cast(Player player, Level world, int level) {
        if (!Stats.CHAKRA.get().getManager().decreaseIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        Vec3 playerLook = player.getViewVector(1).scale(Math.max(1, level/2));
        player.setDeltaMovement(new Vec3(playerLook.x(), player.getDeltaMovement().y(), playerLook.z()));
        System.out.println(world.isClientSide());

        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        EntityHitResult result = JutsuHelper.raycastEntity(world, player, Math.max(3, level+1));
        if (result != null) {
            result.getEntity().hurt(DamageSource.MAGIC, 6);
        }

        JutsuHelper.spawnParticles(world, ParticleTypes.CRIT, player.getX(), player.getY() + 0.5, player.getZ(), 0.5, 0, 0.5, 0.5, 10);

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
