package com.godhenko.narutorevival.procedures.guiprocedures.lessprocecdures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class LesssennjutsuProcedure {
	public static void execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addsenjutsu > 0) {
			NarutoRevivalModVariables.MapVariables.get(world).addsenjutsu = NarutoRevivalModVariables.MapVariables.get(world).addsenjutsu - 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower - 3;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
