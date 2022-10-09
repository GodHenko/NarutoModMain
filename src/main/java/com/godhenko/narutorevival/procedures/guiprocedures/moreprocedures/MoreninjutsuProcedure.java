package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.chakra.PlayerChakra;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.world.entity.Entity;
import org.lwjgl.glfw.GLFW;



public class MoreninjutsuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		 if((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints > 0){
				{
					double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).ninjutsu + 1;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints - 1;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			 {
				 double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						 .orElse(new NarutoRevivalModVariables.PlayerVariables())).maxChakra + 5;
				 new PlayerChakra().maxChakra = (float) _setval ;
			 }
			 {
				 double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						 .orElse(new NarutoRevivalModVariables.PlayerVariables())).ninjutsu * 5;
				 entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					 capability.maxChakra = _setval + 100;
					 capability.syncPlayerVariables(entity);
				 });
			 }

			}else {
			 {
				 double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						 .orElse(new NarutoRevivalModVariables.PlayerVariables())).ninjutsu + 0;
				 entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					 capability.ninjutsu = _setval;
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
	}
}

