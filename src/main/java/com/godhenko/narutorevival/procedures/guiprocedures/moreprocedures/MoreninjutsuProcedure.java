package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.inits.KeyMappingsInit;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import static com.godhenko.narutorevival.NarutoRevival.KeyboardHelper.WINDOW;

public class MoreninjutsuProcedure {



	public static void execute(LevelAccessor world, Player player) {
		if (NarutoRevivalModVariables.MapVariables.get(world).ninjutsu >= 500) {
			NarutoRevivalModVariables.MapVariables.get(world).ninjutsu = NarutoRevivalModVariables.MapVariables.get(world).ninjutsu + 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
		else if (InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT)) {
			if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 10) {
				NarutoRevivalModVariables.MapVariables.get(world).ninjutsu = NarutoRevivalModVariables.MapVariables.get(world).ninjutsu + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).maxChakra = NarutoRevivalModVariables.MapVariables.get(world).maxChakra + 50;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 50;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);

			}
		} else if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
				NarutoRevivalModVariables.MapVariables.get(world).ninjutsu = NarutoRevivalModVariables.MapVariables.get(world).ninjutsu + 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).maxChakra = NarutoRevivalModVariables.MapVariables.get(world).maxChakra + 5;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 5;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);

			}

		}
	}
