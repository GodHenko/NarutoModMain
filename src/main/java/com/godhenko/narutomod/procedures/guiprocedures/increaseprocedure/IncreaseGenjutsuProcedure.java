package com.godhenko.narutomod.procedures.guiprocedures.increaseprocedure;

import com.godhenko.narutomod.network.ModVariables;
import net.minecraft.world.entity.Entity;

public class IncreaseGenjutsuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ModVariables.PlayerVariables())).genjutsu + 1;
			entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.genjutsu = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
