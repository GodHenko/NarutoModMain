package com.godhenko.narutomod.procedures.guiprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkstrengthProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).strength = NarutoRevivalModVariables.MapVariables.get(world).strength
				+ NarutoRevivalModVariables.MapVariables.get(world).addstrength;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addstrength = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
