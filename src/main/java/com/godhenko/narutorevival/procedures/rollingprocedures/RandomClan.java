package com.godhenko.narutorevival.procedures.rollingprocedures;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.entity.Entity;

public class RandomClan {

    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan == (entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan){

        }
    }
}
