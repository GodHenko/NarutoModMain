package com.godhenko.narutomod.procedures.guiprocedures.lessprocecdures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class LessshurikenjutsuProcedure {
	public static void execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).addshurikenjutsu > 0) {
			NarutoRevivalModVariables.MapVariables.get(world).addshurikenjutsu = NarutoRevivalModVariables.MapVariables.get(world).addshurikenjutsu - 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
}