package com.godhenko.narutorevival.event;

import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.network.OneTimeModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpawnWithItem {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        execute(event, event.getPlayer());
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        if (!(entity.getCapability(OneTimeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new OneTimeModVariables.PlayerVariables())).giveonce) {
            {
                boolean _setval = true;
                entity.getCapability(OneTimeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.giveonce = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            if (entity instanceof Player _player) {
                ItemStack _setstack = new ItemStack(ItemInit.CHAKRA_PAPER.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
        }
    }
}