package com.godhenko.narutorevival.procedures.guiprocedures.addxpprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.world.level.LevelAccessor;

public class XpSettingProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity, LevelAccessor world) {
		if (entity == null)
			return;
		{
			if (!world.isClientSide()) {
				if (world instanceof ServerLevel _level) {
					double _setval = DoubleArgumentType.getDouble(arguments, "value");
					NarutoRevivalModVariables.MapVariables.get(world).XP = NarutoRevivalModVariables.MapVariables.get(world).XP + _setval;
				}
			}
		}
	}
}
