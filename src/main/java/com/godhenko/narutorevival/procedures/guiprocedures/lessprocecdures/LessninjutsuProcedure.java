package com.godhenko.narutorevival.procedures.guiprocedures.lessprocecdures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class LessninjutsuProcedure {
	public static void execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addninjutsu > 0) {
			NarutoRevivalModVariables.MapVariables.get(world).addninjutsu = NarutoRevivalModVariables.MapVariables.get(world).addninjutsu - 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
