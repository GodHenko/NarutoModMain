package com.godhenko.narutorevival.procedures.guiprocedures.okprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkintelligenceProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).intelligence = NarutoRevivalModVariables.MapVariables.get(world).intelligence
				+ NarutoRevivalModVariables.MapVariables.get(world).addintelligence;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addintelligence = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
