package com.godhenko.narutomod.procedures.guiprocedures;

import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;


public class LevelProgressionProcedure {
	public static void execute(LevelAccessor world) {
		double percnt = 0;
		percnt = NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp / 10;
		if (NarutoRevivalModVariables.MapVariables.get(world).XP >= 0 && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 1;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else if (NarutoRevivalModVariables.MapVariables.get(world).XP >= percnt * 8 && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt * 9) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 9;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else if (NarutoRevivalModVariables.MapVariables.get(world).XP >= percnt * 7 && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt * 8) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 8;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else if (NarutoRevivalModVariables.MapVariables.get(world).XP >= percnt * 6 && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt * 7) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 7;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else if (NarutoRevivalModVariables.MapVariables.get(world).XP >= percnt * 5 && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt * 6) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 6;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else if (NarutoRevivalModVariables.MapVariables.get(world).XP >= percnt * 4 && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt * 5) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 5;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else if (NarutoRevivalModVariables.MapVariables.get(world).XP >= percnt * 3 && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt * 4) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 4;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else if (NarutoRevivalModVariables.MapVariables.get(world).XP >= percnt * 2 && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt * 3) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 3;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else if (NarutoRevivalModVariables.MapVariables.get(world).XP >= percnt && NarutoRevivalModVariables.MapVariables.get(world).XP < percnt * 2) {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 2;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		} else {
			NarutoRevivalModVariables.MapVariables.get(world).progress = 10;
			NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
		}
		NarutoRevivalModVariables.MapVariables.get(world).progresspercent = (NarutoRevivalModVariables.MapVariables.get(world).XP * 100)
				/ NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp;
		NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
	}
}
