package com.godhenko.narutomod.procedures.guiprocedures.barprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class Bar10showProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).progress == 1) {
			return true;
		}
		if (NarutoRevivalModVariables.MapVariables.get(world).progress == 0) {
			return false;
		}
		return false;
	}
}