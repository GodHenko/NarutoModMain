package com.godhenko.narutorevival.procedures.guiprocedures.otherprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;


public class MoreHPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
			if (NarutoRevivalModVariables.MapVariables.get(world).medical <= 500) {
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints -0.5;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
									_level.getServer(), null).withSuppressedOutput(),
							("attribute @p minecraft:generic.max_health base set "
									+ new java.text.DecimalFormat("##").format(NarutoRevivalModVariables.MapVariables.get(world).medical + 1)));					NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints -1;


			}
		}
	}
}
