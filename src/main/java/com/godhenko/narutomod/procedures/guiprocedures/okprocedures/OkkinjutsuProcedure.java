package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkkinjutsuProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).kinjutsu = NarutoRevivalModVariables.MapVariables.get(world).kinjutsu
				+ NarutoRevivalModVariables.MapVariables.get(world).addkinjutsu;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addkinjutsu = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
