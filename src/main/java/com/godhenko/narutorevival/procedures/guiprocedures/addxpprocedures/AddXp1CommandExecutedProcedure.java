package com.godhenko.narutorevival.procedures.guiprocedures.addxpprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;

public class AddXp1CommandExecutedProcedure {
	public static void execute(LevelAccessor world) {
			NarutoRevivalModVariables.MapVariables.get(world).XP = NarutoRevivalModVariables.MapVariables.get(world).XP + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
