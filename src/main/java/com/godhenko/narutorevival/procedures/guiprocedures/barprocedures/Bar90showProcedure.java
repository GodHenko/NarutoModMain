package com.godhenko.narutorevival.procedures.guiprocedures.barprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class Bar90showProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).progress == 9) {
			return true;
		}
		if (NarutoRevivalModVariables.MapVariables.get(world).progress == 0) {
			return false;
		}
		return false;
	}
}