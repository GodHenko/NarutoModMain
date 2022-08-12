package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.lwjgl.glfw.GLFW;

import static com.godhenko.narutorevival.NarutoRevival.KeyboardHelper.WINDOW;


public class MoreshurikenjutsuProcedure {
	public static void execute(LevelAccessor world, Player player) {
		if (NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu >= 500) {
			NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu = NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu + 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
		else if (InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT)){
			if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 10) {
				NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu = NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 30;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		}
			else if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
				NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu = NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu + 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 3;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}

