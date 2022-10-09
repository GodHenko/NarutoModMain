package com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease;

import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StaticForceJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 1;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.LIGHTNING;
    }

    @Override
    public InteractionResult cast(Player player, Level world) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!ChakraManager.decreaseChakraIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        JutsuHelper.spawnCircleParticles(world, ParticleTypes.CRIT, Direction.Axis.Y, player.getX(), player.getY()+1, player.getZ(), 2, 0, 2, 0.5, 3, 64);

        List<Entity> entities = world.getEntities(player, new AABB(player.getX()-6, player.getY()-6, player.getZ()-6, player.getX()+6, player.getY()+6, player.getZ()+6));
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity living) {
                living.hurt(ModRegistry.stunSource(player), attackDamage());
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 255));
            }
        }

        return InteractionResult.SUCCESS;
    }
    public int attackDamage() {
        return 3 ;
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
