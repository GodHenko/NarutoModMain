package com.godhenko.narutorevival.procedures.guiprocedures.showprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class ShowOksenjutsuProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addsenjutsu > 0) {
			return true;
		}
		return false;
	}
}
