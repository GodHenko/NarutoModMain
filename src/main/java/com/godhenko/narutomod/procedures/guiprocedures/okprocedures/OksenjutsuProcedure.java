package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OksenjutsuProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).senjutsu = NarutoRevivalModVariables.MapVariables.get(world).senjutsu
				+ NarutoRevivalModVariables.MapVariables.get(world).addsenjutsu;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addsenjutsu = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}