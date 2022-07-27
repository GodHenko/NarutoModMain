package com.godhenko.narutorevival.procedures.guiprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import javax.annotation.Nullable;



@Mod.EventBusSubscriber
public class LevelUpProcedure {
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
		double oldlvl = 0;
		if (NarutoRevivalModVariables.MapVariables.get(world).XP >= NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp) {
			NarutoRevivalModVariables.MapVariables.get(world).XP = NarutoRevivalModVariables.MapVariables.get(world).XP
					- NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp = NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp
					+ 2 * NarutoRevivalModVariables.MapVariables.get(world).Lvl;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			oldlvl = NarutoRevivalModVariables.MapVariables.get(world).Lvl;
			NarutoRevivalModVariables.MapVariables.get(world).Lvl = NarutoRevivalModVariables.MapVariables.get(world).Lvl + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints + 5;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints = NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints + 5;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(
						("LevelUp! " + "[ lvl " + oldlvl + " ]" + " ---> " + "[ lvl " + NarutoRevivalModVariables.MapVariables.get(world).Lvl + " ]")),
						(false));
			LevelProgressionProcedure.execute(world);
		}
	}
}
