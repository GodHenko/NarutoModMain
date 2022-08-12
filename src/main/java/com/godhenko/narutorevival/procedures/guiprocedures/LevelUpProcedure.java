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
import java.util.Random;


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
		Random rand = new Random();
		double oldlvl = 0;
		int skillAndJutsuPoints = rand.nextInt(1, 8);
		if (NarutoRevivalModVariables.MapVariables.get(world).XP >= NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp) {
			NarutoRevivalModVariables.MapVariables.get(world).XP = NarutoRevivalModVariables.MapVariables.get(world).XP
					- NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp = NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp
					+ 0.2f * NarutoRevivalModVariables.MapVariables.get(world).Lvl / 7;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			oldlvl = NarutoRevivalModVariables.MapVariables.get(world).Lvl;
			NarutoRevivalModVariables.MapVariables.get(world).Lvl = NarutoRevivalModVariables.MapVariables.get(world).Lvl + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			if (skillAndJutsuPoints < 5) {
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints + 5;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints = NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints + 5;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			} else if (skillAndJutsuPoints < 7) {
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints + 2;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints = NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints + 2;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			} else if (skillAndJutsuPoints < 8) {
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints = NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(
								("LevelUp! " + "[ lvl " + oldlvl + " ]" + " ---> " + "[ lvl " + NarutoRevivalModVariables.MapVariables.get(world).Lvl + " ]")),
						(false));
			LevelProgressionProcedure.execute(world);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				if (skillAndJutsuPoints < 5) {
					_player.displayClientMessage(new TextComponent(
									("Rewards: +5 SP and +5 JP")),
							(false));
					LevelProgressionProcedure.execute(world);
				} else if (skillAndJutsuPoints < 7) {
					_player.displayClientMessage(new TextComponent(
									("Rewards: +2 SP and +2 JP")),
							(false));
					LevelProgressionProcedure.execute(world);
				} else if (skillAndJutsuPoints < 8) {
					_player.displayClientMessage(new TextComponent(
									("Rewards: +10 SP and +10 JP")),
							(false));
					LevelProgressionProcedure.execute(world);
				}
		}
	}
}
