package com.godhenko.narutorevival.procedures.guiprocedures.okprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkagilityProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).agility = NarutoRevivalModVariables.MapVariables.get(world).agility
				+ NarutoRevivalModVariables.MapVariables.get(world).addagility;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addagility = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
