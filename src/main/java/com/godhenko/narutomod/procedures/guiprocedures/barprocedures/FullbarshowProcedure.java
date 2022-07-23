package com.godhenko.narutomod.procedures.guiprocedures.barprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class FullbarshowProcedure {
	public static boolean execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).progress == 10) {
			return true;
		}
		return false;
	}
}
