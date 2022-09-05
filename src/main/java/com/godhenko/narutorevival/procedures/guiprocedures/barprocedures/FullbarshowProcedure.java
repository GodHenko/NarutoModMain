package com.godhenko.narutorevival.procedures.guiprocedures.barprocedures;

import com.godhenko.narutorevival.network.NarutoModVariables;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;


public class FullbarshowProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if ((entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoModVariables.PlayerVariables())).progress == 10) {
			return true;
		}
		return false;
	}
}
