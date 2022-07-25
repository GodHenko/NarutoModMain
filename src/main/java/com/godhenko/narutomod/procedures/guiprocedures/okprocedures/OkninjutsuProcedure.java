package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkninjutsuProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).ninjutsu = NarutoRevivalModVariables.MapVariables.get(world).ninjutsu
				+ NarutoRevivalModVariables.MapVariables.get(world).addninjutsu;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addninjutsu = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
