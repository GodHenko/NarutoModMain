package com.godhenko.narutorevival.procedures.guiprocedures.otherprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import javax.annotation.Nullable;



@Mod.EventBusSubscriber
public class OverwriteStrengthProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
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
			entity.hurt(DamageSource.GENERIC, (float) (NarutoRevivalModVariables.MapVariables.get(world).taijutsu / 100));
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);

		}
	}
}
