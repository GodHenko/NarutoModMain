package com.godhenko.narutorevival.procedures.guiprocedures.lessprocecdures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class LesskenjutsuProcedure {
	public static void execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addkenjutsu > 0) {
			NarutoRevivalModVariables.MapVariables.get(world).addkenjutsu = NarutoRevivalModVariables.MapVariables.get(world).addkenjutsu - 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower - 4;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
