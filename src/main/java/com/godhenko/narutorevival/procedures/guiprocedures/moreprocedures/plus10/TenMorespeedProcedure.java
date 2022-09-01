package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.plus10;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class TenMorespeedProcedure {
	public static void execute(LevelAccessor world) {
			if (NarutoRevivalModVariables.MapVariables.get(world).speed >= 10) {
				NarutoRevivalModVariables.MapVariables.get(world).speed = NarutoRevivalModVariables.MapVariables.get(world).speed + 0;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 0;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		 else if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 10) {
				NarutoRevivalModVariables.MapVariables.get(world).speed = NarutoRevivalModVariables.MapVariables.get(world).speed + 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
				NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 10;
				NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}

