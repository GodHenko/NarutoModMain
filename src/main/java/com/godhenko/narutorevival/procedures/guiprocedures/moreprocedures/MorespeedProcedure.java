package com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;



public class MorespeedProcedure {
	public static void execute(LevelAccessor world) {

		if (NarutoRevivalModVariables.MapVariables.get(world).speed >= 20){
			NarutoRevivalModVariables.MapVariables.get(world).addspeed = NarutoRevivalModVariables.MapVariables.get(world).addspeed + 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 0;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);


		} else if (NarutoRevivalModVariables.MapVariables.get(world).skillPoints > 0) {
			NarutoRevivalModVariables.MapVariables.get(world).addspeed = NarutoRevivalModVariables.MapVariables.get(world).addspeed + 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
			NarutoRevivalModVariables.MapVariables.get(world).skillPoints = NarutoRevivalModVariables.MapVariables.get(world).skillPoints - 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
