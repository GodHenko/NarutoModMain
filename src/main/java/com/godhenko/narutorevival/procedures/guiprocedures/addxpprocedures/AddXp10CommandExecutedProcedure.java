package com.godhenko.narutorevival.procedures.guiprocedures.addxpprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;



public class AddXp10CommandExecutedProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide()) {

			NarutoRevivalModVariables.MapVariables.get(world).XP = NarutoRevivalModVariables.MapVariables.get(world).XP + 10;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
