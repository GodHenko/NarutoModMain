package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.lwjgl.glfw.GLFW;

import static com.godhenko.narutorevival.NarutoRevival.KeyboardHelper.WINDOW;


public class MoregenjutsuProcedure {
	public static void execute(LevelAccessor world, Player player) {
		if (NarutoRevivalModVariables.MapVariables.get(world).genjutsu >= 500) {
			NarutoRevivalModVariables.MapVariables.get(world).genjutsu = NarutoRevivalModVariables.MapVariables.get(world).genjutsu + 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
		else if (InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT)){
			if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 10){
				NarutoRevivalModVariables.MapVariables.get(world).genjutsu = NarutoRevivalModVariables.MapVariables.get(world).genjutsu + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 20;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		} else if
		(NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
				NarutoRevivalModVariables.MapVariables.get(world).genjutsu = NarutoRevivalModVariables.MapVariables.get(world).genjutsu + 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 2;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}

