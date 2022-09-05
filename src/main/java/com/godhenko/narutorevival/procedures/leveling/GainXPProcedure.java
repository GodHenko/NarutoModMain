package com.godhenko.narutorevival.procedures.leveling;

import com.godhenko.narutorevival.network.NarutoModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
@Mod.EventBusSubscriber
public class GainXPProcedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        execute(null, world, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (sourceentity instanceof Player) {
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.XP = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables())).XP
                    + Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 5);
                capability.syncPlayerVariables(entity);
                LevelProgressingProcedure.execute(world,entity);
            });
        }
    }
}

