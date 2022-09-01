package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.plus10;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;


public class TenMoreHPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (NarutoRevivalModVariables.MapVariables.get(world).medical >= 490) {
			NarutoRevivalModVariables.MapVariables.get(world).medical = NarutoRevivalModVariables.MapVariables.get(world).medical + 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}

		else if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 10) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
									_level.getServer(), null).withSuppressedOutput(),
							("attribute @p minecraft:generic.max_health base set "
									+ new java.text.DecimalFormat("##").format(NarutoRevivalModVariables.MapVariables.get(world).medical + 30)));

			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints -10;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
