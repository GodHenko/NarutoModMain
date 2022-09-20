package com.godhenko.narutorevival.procedures.guiprocedures.barprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.entity.Entity;

public class FullbarshowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).progress == 10) {
			return true;
		}
		return false;
	}
}
