package com.godhenko.narutorevival.procedures.leveling;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.extra.Stats;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

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
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double oldlvl = 0;
		if ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
				new NarutoRevivalModVariables.PlayerVariables())).XP >= (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).maxLvlXp) {
			{
				double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).XP
						- (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).maxLvlXp;
				entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.XP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).maxLvlXp
						+ 2 * (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl;
				entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.maxLvlXp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			oldlvl = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl;
			{
				double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl + 1;
				entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Lvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			Random rand = new Random();
			int points = rand.nextInt(0, 100);
			{
				if (points < 10) {
					double skillpoints2 = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints + 2;
					double jutsupoints2 = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).jutsuPoints + 2;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillPoints = skillpoints2;
						capability.jutsuPoints = jutsupoints2;
						capability.syncPlayerVariables(entity);
					});
					Stats.JP.get().getManager().add((Player) entity,2);
				} else if (points < 60) {
					double skillpoints5 = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints + 5;
					double jutsupoints5 = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).jutsuPoints + 5;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillPoints = skillpoints5;
						capability.jutsuPoints = jutsupoints5;
						capability.syncPlayerVariables(entity);
					});
					Stats.JP.get().getManager().add((Player) entity,5);
				} else if (points < 90) {
					double skillpoints5 = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints + 7;
					double jutsupoints5 = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).jutsuPoints + 7;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillPoints = skillpoints5;
						capability.jutsuPoints = jutsupoints5;
						capability.syncPlayerVariables(entity);
					});
					Stats.JP.get().getManager().add((Player) entity,7);
				} else if (points < 100) {
					double skillpoints5 = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints + 10;
					double jutsupoints5 = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).jutsuPoints + 10;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillPoints = skillpoints5;
						capability.jutsuPoints = jutsupoints5;
						capability.syncPlayerVariables(entity);
					});
					Stats.JP.get().getManager().add((Player) entity,10);
				}
			}
			if (points < 10) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("LevelUp! " + "[ lvl " + oldlvl + " ]" + " ---> " + "[ lvl " + (entity
							.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl +1
							+ " ]" + " Rewards:2SP & 2JP")), (false));
				LevelProgressionProcedure.execute(entity);



			} else if (points < 60) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("LevelUp! " + "[ lvl " + oldlvl + " ]" + " ---> " + "[ lvl " + (entity
							.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl
							+ " ]" + " Rewards:5SP & 5JP")), (false));
				LevelProgressionProcedure.execute(entity);


			}
			else if (points < 90) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("LevelUp! " + "[ lvl " + oldlvl + " ]" + " ---> " + "[ lvl " + (entity
							.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl
							+ " ]" + " Rewards:7SP & 7JP")), (false));
				LevelProgressionProcedure.execute(entity);


			}
			else if (points < 100) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("LevelUp! " + "[ lvl " + oldlvl + " ]" + " ---> " + "[ lvl " + (entity
							.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl
							+ " ]" + " Rewards:10SP & 10JP")), (false));
				LevelProgressionProcedure.execute(entity);
			}
		}

	}
}


