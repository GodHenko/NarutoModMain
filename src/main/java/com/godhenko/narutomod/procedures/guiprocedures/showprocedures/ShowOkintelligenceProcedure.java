package com.godhenko.narutomod.procedures.guiprocedures.showprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class ShowOkintelligenceProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addintelligence > 0) {
			return true;
		}
		return false;
	}
}
