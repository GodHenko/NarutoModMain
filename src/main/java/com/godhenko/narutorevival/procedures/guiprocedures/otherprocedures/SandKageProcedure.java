package com.godhenko.narutorevival.procedures.guiprocedures.otherprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SandKageProcedure {
    public static void execute(LevelAccessor world) {
        NarutoRevivalModVariables.MapVariables.get(world).rank = NarutoRevivalModVariables.MapVariables.get(world).rank;
        NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
        NarutoRevivalModVariables.MapVariables.get(world).rank = 6;
        NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
    }
}
