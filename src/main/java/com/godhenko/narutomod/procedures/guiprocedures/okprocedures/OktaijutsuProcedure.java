package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OktaijutsuProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).taijutsu = NarutoRevivalModVariables.MapVariables.get(world).taijutsu
				+ NarutoRevivalModVariables.MapVariables.get(world).addtaijutsu;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addtaijutsu = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
