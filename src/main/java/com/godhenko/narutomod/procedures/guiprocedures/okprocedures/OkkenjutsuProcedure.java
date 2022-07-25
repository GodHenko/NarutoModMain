package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkkenjutsuProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).kenjutsu = NarutoRevivalModVariables.MapVariables.get(world).kenjutsu
				+ NarutoRevivalModVariables.MapVariables.get(world).addkenjutsu;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addkenjutsu = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
