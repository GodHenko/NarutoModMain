package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.world.level.LevelAccessor;


public class MoreninjutsuProcedure {
	public static void execute(LevelAccessor world) {
		if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
			NarutoRevivalModVariables.MapVariables.get(world).addninjutsu = NarutoRevivalModVariables.MapVariables.get(world).addninjutsu + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).maxChakra = NarutoRevivalModVariables.MapVariables.get(world).maxChakra + 5;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 5;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);

			if (InputConstants.KEY_LSHIFT + NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0){
				NarutoRevivalModVariables.MapVariables.get(world).addninjutsu = NarutoRevivalModVariables.MapVariables.get(world).addninjutsu + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		}

	}
}
