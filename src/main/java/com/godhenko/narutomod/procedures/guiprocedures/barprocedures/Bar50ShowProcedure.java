package com.godhenko.narutomod.procedures.guiprocedures.barprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;



public class Bar50ShowProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).progress == 5) {
			return true;
		}
		return false;
	}
}
