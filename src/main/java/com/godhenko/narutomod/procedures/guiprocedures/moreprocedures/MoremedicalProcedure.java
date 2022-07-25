package com.godhenko.narutomod.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class MoremedicalProcedure {
	public static void execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
			NarutoRevivalModVariables.MapVariables.get(world).addmedical = NarutoRevivalModVariables.MapVariables.get(world).addmedical + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
}