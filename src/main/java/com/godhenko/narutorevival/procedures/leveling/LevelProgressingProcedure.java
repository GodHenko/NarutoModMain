package com.godhenko.narutorevival.procedures.leveling;

import com.godhenko.narutorevival.network.NarutoModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class LevelProgressingProcedure {

    public static void execute(LevelAccessor world,Entity entity) {
        double percnt = 0;
        percnt = entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).maxLvlXp / 10;
        if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= 0 && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 1;
                capability.syncPlayerVariables(entity);
            });
        }else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= percnt * 8 && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt * 9){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 9;
                capability.syncPlayerVariables(entity);
            });
        }else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= percnt * 7 && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt * 8){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 8;
                capability.syncPlayerVariables(entity);
            });
        }else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= percnt * 6 && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt * 7){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 7;
                capability.syncPlayerVariables(entity);
            });
        }else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= percnt * 5 && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt * 6){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 6;
                capability.syncPlayerVariables(entity);
            });
        }else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= percnt * 4 && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt * 5){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 5;
                capability.syncPlayerVariables(entity);
            });
        }else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= percnt * 3 && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt * 4){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 4;
                capability.syncPlayerVariables(entity);
            });
        }else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= percnt * 2 && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt * 3){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 3;
                capability.syncPlayerVariables(entity);
            });
        }else if (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP >= percnt && entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP < percnt * 2){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 2;
                capability.syncPlayerVariables(entity);
            });
        }else {
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.progress = 10;
                capability.syncPlayerVariables(entity);
            });
        }
        double _setval =  (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP * 100 /entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).maxLvlXp);
        entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.progresspercent = _setval;
            capability.syncPlayerVariables(entity);
        });
    }
}
