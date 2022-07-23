package com.godhenko.narutomod.procedures.guiprocedures.addxpprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class AddXp1000CommandExecutedProcedure {
	public static void execute(LevelAccessor world) {
		NarutoRevivalModVariables.MapVariables.get(world).XP = NarutoRevivalModVariables.MapVariables.get(world).XP + 1000;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
