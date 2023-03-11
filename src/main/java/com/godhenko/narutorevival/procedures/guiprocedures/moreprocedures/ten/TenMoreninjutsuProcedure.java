package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.ten;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.entity.Entity;


public class TenMoreninjutsuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		 if((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints >= 10){
				{
					double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).ninjutsu + 10;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints - 10;
					entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillPoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			 {
				 double _setval = (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						 .orElse(new NarutoRevivalModVariables.PlayerVariables())).maxChakra + 50;
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

