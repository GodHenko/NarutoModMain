package com.godhenko.narutorevival.procedures.guiprocedures.otherprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber
public class OverwiteSpeedProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * (0.99 + NarutoRevivalModVariables.MapVariables.get(world).speed / 200)),
					(entity.getDeltaMovement().y()),
					(entity.getDeltaMovement().z() * (0.99 + NarutoRevivalModVariables.MapVariables.get(world).speed / 200))));
		}
	}
}
