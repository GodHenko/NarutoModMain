package com.godhenko.narutorevival.procedures.guiprocedures.addxpprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.level.LevelAccessor;


public class AddXp10000CommandExecutedProcedure {
	public static void execute(LevelAccessor world) {
			NarutoRevivalModVariables.MapVariables.get(world).XP = NarutoRevivalModVariables.MapVariables.get(world).XP + 10000;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}

