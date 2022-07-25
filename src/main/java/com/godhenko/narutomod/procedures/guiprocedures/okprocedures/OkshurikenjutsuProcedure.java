package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkshurikenjutsuProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu = NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu
				+ NarutoRevivalModVariables.MapVariables.get(world).addshurikenjutsu;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addshurikenjutsu = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
