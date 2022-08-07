package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;


public class MoregenjutsuProcedure {
	public static void execute(LevelAccessor world, Player player) {
		if (player.isShiftKeyDown()) {
			if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
				NarutoRevivalModVariables.MapVariables.get(world).addgenjutsu = NarutoRevivalModVariables.MapVariables.get(world).addgenjutsu + 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 1;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 2;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
