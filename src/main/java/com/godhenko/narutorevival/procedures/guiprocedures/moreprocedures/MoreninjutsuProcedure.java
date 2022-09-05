package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.inits.KeyMappingsInit;
import com.godhenko.narutorevival.network.NarutoModVariables;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;


public class MoreninjutsuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoModVariables.PlayerVariables()).skillPoints > 0) {
				double _setval = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoModVariables.PlayerVariables())).ninjutsu + 1;
				double _setval1 = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoModVariables.PlayerVariables())).skillPoints - 1;
				double _setval2 = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoModVariables.PlayerVariables())).maxChakra + 5;
				double _setval3 = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoModVariables.PlayerVariables())).battlepower + 5;
				entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ninjutsu = _setval;
					capability.skillPoints = _setval1;
					capability.maxChakra = _setval2;
					capability.battlepower = _setval3;
					capability.syncPlayerVariables(entity);
				});

			} else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoModVariables.PlayerVariables()).skillPoints < 0) {
				double _setval = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoModVariables.PlayerVariables())).ninjutsu + 0;
				double _setval1 = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoModVariables.PlayerVariables())).skillPoints - 0;
				double _setval2 = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoModVariables.PlayerVariables())).maxChakra + 0;
				double _setval3 = (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoModVariables.PlayerVariables())).battlepower + 0;
				entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ninjutsu = _setval;
					capability.skillPoints = _setval1;
					capability.maxChakra = _setval2;
					capability.battlepower = _setval3;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

