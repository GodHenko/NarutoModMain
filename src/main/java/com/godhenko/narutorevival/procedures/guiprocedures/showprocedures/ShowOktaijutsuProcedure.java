package com.godhenko.narutorevival.procedures.guiprocedures.showprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class ShowOktaijutsuProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addtaijutsu > 0) {
			return true;
		}
		return false;
	}
}
