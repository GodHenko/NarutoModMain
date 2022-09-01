package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.plus10;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;

public class TenMoreninjutsuProcedure {
	public static void execute(LevelAccessor world) {
			if (NarutoRevivalModVariables.MapVariables.get(world).ninjutsu >= 490) {
				NarutoRevivalModVariables.MapVariables.get(world).ninjutsu = NarutoRevivalModVariables.MapVariables.get(world).ninjutsu + 0;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 0;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);

			} else if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 10) {
				NarutoRevivalModVariables.MapVariables.get(world).ninjutsu = NarutoRevivalModVariables.MapVariables.get(world).ninjutsu + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).maxChakra = NarutoRevivalModVariables.MapVariables.get(world).maxChakra + 50;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).battlepower = NarutoRevivalModVariables.MapVariables.get(world).battlepower + 50;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);

			}

		}
	}

