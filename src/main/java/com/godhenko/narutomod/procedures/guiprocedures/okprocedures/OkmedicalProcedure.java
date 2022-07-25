package com.godhenko.narutomod.procedures.guiprocedures.okprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class OkmedicalProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).medical = NarutoRevivalModVariables.MapVariables.get(world).medical
				+ NarutoRevivalModVariables.MapVariables.get(world).addmedical;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		NarutoRevivalModVariables.MapVariables.get(world).addmedical = 0;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
