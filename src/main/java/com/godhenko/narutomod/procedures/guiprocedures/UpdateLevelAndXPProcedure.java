package com.godhenko.narutomod.procedures.guiprocedures;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.network.ModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UpdateLevelAndXPProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = entity instanceof Player _plr ? _plr.experienceLevel : 0;
			entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.level = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0;
			entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.xpMax = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity instanceof Player _plr ? (((float)_plr.getXpNeededForNextLevel() * _plr.experienceProgress)) : 0;
			entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.xp = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
