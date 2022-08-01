package com.godhenko.narutorevival.procedures.chakra;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.KeyMappingsInit;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.world.inventory.StatsMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = NarutoRevival.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class ChargeChakraProcdure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            if (entity instanceof ServerPlayer _ent) {
                BlockPos _bpos = new BlockPos(x, y, z);
                if (KeyMappingsInit.CHARGE_CHAKRA.isDown()){
                    NarutoRevivalModVariables.MapVariables.get(world).chakra = NarutoRevivalModVariables.MapVariables.get(world).chakra ++;
                }
            }
        }
    }
}
