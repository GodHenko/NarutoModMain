package com.godhenko.narutorevival.procedures.guiprocedures.otherprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber
public class OverwriteAgilityProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntityLiving().level, event.getEntityLiving());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()),
					(entity.getDeltaMovement().y() + NarutoRevivalModVariables.MapVariables.get(world).speed / 250), (entity.getDeltaMovement().z())));
		}
	}
}
