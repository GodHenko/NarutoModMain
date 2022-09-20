package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import org.lwjgl.glfw.GLFW;

import static com.godhenko.narutorevival.util.KeyboardHelper.WINDOW;


public class MoreHPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical >= 500) {
			{
				double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical + 0;
				entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.medical = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints - 0;
				entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.skillPoints = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		else if (InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT)){
			if ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical >= 490){
				{
					double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical + 0;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.medical = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints - 0;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			else if ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints >= 10) {
				if (world instanceof ServerLevel _level)
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						_level.getServer().getCommands().performCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
										_level.getServer(), null).withSuppressedOutput(),
								("attribute @p minecraft:generic.max_health base set "
										+ new java.text.DecimalFormat("##").format(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical) + 30)));
						double _setval = ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical) + 10;
						capability.medical = _setval;
						capability.syncPlayerVariables(entity);
					});
				{
					double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints - 10;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		else if ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints > 0) {
				if (world instanceof ServerLevel _level)
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					_level.getServer().getCommands().performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
									_level.getServer(), null).withSuppressedOutput(),
							("attribute @p minecraft:generic.max_health base set "
									+ new java.text.DecimalFormat("##").format(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical) + 21)));
						double _setval = ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical) + 1;
						capability.medical = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
