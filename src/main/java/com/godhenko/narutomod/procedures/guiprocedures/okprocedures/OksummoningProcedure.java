package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OksummoningProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).summoning = NarutoRevivalModVariables.MapVariables.get(world).summoning
				+ NarutoRevivalModVariables.MapVariables.get(world).addsummoning;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addsummoning = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
