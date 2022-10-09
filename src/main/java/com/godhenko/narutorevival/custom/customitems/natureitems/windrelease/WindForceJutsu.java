package com.godhenko.narutorevival.custom.customitems.natureitems.windrelease;

import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WindForceJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 1;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.WIND;
    }

    @Override
    public InteractionResult cast(Player player, Level world) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!ChakraManager.decreaseChakraIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        if (doesPlayerHaveEffects(player)) {
            player.removeEffect(MobEffects.MOVEMENT_SPEED);
            player.removeEffect(MobEffects.JUMP);
            player.removeEffect(MobEffects.REGENERATION);

            JutsuTicker.stopTicking(this, player);
        } else {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000000));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1000000));
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1000000));

            JutsuHelper.spawnParticles(world, ParticleTypes.CLOUD, player.getX(), player.getY() + 0.5, player.getZ(), 0.5, 0, 0.5, 0.5, 10);
            JutsuTicker.startTicking(this, player);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public int chakraCost(@Nullable Player player, Level world) {
        if (doesPlayerHaveEffects(player)) {
            return 0;
        }

        return jutsuLevel() * 5;
    }

    private boolean doesPlayerHaveEffects(@Nullable Player player) {
        return player != null && player.hasEffect(MobEffects.MOVEMENT_SPEED) && player.hasEffect(MobEffects.JUMP) && player.hasEffect(MobEffects.REGENERATION);
    }

    @Override
    public void tick(Player player, Level world) {
        if (ChakraManager.decreaseChakraOverTimeIfEnough(player, 1)) {
            JutsuHelper.spawnParticles(world, ParticleTypes.CLOUD, player.getX(), player.getY() + 0.25, player.getZ(), 0, 0.5, 0, 0.1, 1);
        } else {
            cast(player, world);
        }
    }

    @Override
    public Jutsu init() {
        JutsuTicker.registerPlayerTicker(this);
        return this;
    }
}
