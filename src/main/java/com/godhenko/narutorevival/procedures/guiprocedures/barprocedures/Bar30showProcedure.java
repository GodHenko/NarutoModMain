package com.godhenko.narutorevival.procedures.guiprocedures.barprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;



public class Bar30showProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).progress == 3) {
			return true;
		}
		return false;
	}
}
