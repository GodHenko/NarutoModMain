package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkgenjutsuProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).genjutsu = NarutoRevivalModVariables.MapVariables.get(world).genjutsu
				+ NarutoRevivalModVariables.MapVariables.get(world).addgenjutsu;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addgenjutsu = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
