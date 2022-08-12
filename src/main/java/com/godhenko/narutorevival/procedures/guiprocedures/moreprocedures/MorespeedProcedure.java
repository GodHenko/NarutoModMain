package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.lwjgl.glfw.GLFW;

import static com.godhenko.narutorevival.NarutoRevival.KeyboardHelper.WINDOW;


public class MorespeedProcedure {
	public static void execute(LevelAccessor world, Player player) {
			if (NarutoRevivalModVariables.MapVariables.get(world).speed >= 20) {
				NarutoRevivalModVariables.MapVariables.get(world).speed = NarutoRevivalModVariables.MapVariables.get(world).speed + 0;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 0;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		else if (InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT)){
			if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 10) {
				NarutoRevivalModVariables.MapVariables.get(world).speed = NarutoRevivalModVariables.MapVariables.get(world).speed + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
			} else if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
				NarutoRevivalModVariables.MapVariables.get(world).speed = NarutoRevivalModVariables.MapVariables.get(world).speed + 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}

