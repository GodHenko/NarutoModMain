package com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.godhenko.narutorevival.jutsus.network.EarthArmorNetworkChannel;
import com.godhenko.narutorevival.jutsus.network.UpdateEarthArmorPacket;
import com.godhenko.narutorevival.network.extra.Stats;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class EarthArmorJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 3;
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

        if (JutsuTicker.isTicking(this, player)) {
            EarthArmorNetworkChannel.sendS2C(new UpdateEarthArmorPacket(false, player.getStringUUID()));
            player.removeEffect(MobEffects.DAMAGE_RESISTANCE);

            JutsuTicker.stopTicking(this, player);
        } else {
            EarthArmorNetworkChannel.sendS2C(new UpdateEarthArmorPacket(true, player.getStringUUID()));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000000, level - 1));
            JutsuHelper.spawnParticles(world, ParticleTypes.CAMPFIRE_COSY_SMOKE, player.getX(), player.getY() + 0.5, player.getZ(), 0.5, 0, 0.5, 0.5, 10);

            JutsuTicker.startTicking(this, player);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public int chakraCost(@Nullable Player player, Level world) {
        if (JutsuTicker.isTicking(this, player)) {
            return 0;
        }

        return jutsuLevel() * 5;
    }

    @Override
    public void tick(Player player, Level world) {
        if (!Stats.CHAKRA.get().getManager().decreaseOverTimeIfEnough(player, 1)) {
            // just pass some random level, it won't be needed anyway
            cast(player, world, 0);
        }
    }

    @Override
    public Jutsu init() {
        JutsuTicker.registerPlayerTicker(this);
        return this;
    }
}
