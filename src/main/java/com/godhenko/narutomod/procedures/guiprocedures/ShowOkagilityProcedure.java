package com.godhenko.narutomod.procedures.guiprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;



public class ShowOkagilityProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addagility > 0) {
			return true;
		}
		return false;
	}
}
