package com.godhenko.narutorevival.procedures.guiprocedures.okprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;



public class OkspeedProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).speed = NarutoRevivalModVariables.MapVariables.get(world).speed
				+ NarutoRevivalModVariables.MapVariables.get(world).addspeed;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addspeed = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
