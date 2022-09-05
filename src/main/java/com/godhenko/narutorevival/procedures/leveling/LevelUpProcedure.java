package com.godhenko.narutorevival.procedures.leveling;

import com.godhenko.narutorevival.network.NarutoModVariables;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LevelUpProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player.level, event.player);
        }
    }

    public static void execute(LevelAccessor world, Entity entity) {
        execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double oldlvl = 0;
        if ((entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).XP) >= (entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoModVariables.PlayerVariables()).maxLvlXp)){
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.XP  = entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables()).XP - entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables()).maxLvlXp;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.maxLvlXp = entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables()).maxLvlXp + 2 * entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables()).Lvl;
                capability.syncPlayerVariables(entity);
            });
            oldlvl = entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables()).Lvl;
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Lvl = entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables()).Lvl + 1;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.skillPoints = entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables()).skillPoints + 5;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.jutsuPoints = entity.getCapability(NarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoModVariables.PlayerVariables()).jutsuPoints + 5;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof Player _player && !_player.level.isClientSide())
            _player.displayClientMessage(new TextComponent(
                            ("LevelUp! " + "[ lvl " + oldlvl + " ]" + " ---> " + "[ lvl " + " ]")), (false));
        LevelProgressingProcedure.execute(world, entity);
    }
}