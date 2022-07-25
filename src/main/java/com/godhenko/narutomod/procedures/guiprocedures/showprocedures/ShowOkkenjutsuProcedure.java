package com.godhenko.narutomod.procedures.guiprocedures.showprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class ShowOkkenjutsuProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addkenjutsu > 0) {
			return true;
		}
		return false;
	}
}
