package com.godhenko.narutorevival.custom.customitems.natureitems.windrelease;

import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class WindOneJutsu implements Jutsu {
    @Override
    public void cast(Player player, Level world) {
        if (player.hasEffect(MobEffects.MOVEMENT_SPEED) && player.hasEffect(MobEffects.JUMP) && player.hasEffect(MobEffects.REGENERATION)) {
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
    }

    @Override
    public void tick(Player player, Level world) {
        JutsuHelper.spawnParticles(world, ParticleTypes.CLOUD, player.getX(), player.getY() + 0.25, player.getZ(), 0, 0.5, 0, 0.1, 1);
    }

    @Override
    public Jutsu init() {
        JutsuTicker.registerPlayerTicker(this);
        return this;
    }
}
