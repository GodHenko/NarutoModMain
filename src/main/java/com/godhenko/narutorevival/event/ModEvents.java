package com.godhenko.narutorevival.event;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.tradeprofressions.ModVillagers;
import com.godhenko.narutorevival.inits.ItemInit;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = NarutoRevival.MOD_ID)

public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {

    }

    @SubscribeEvent
    public static void addVanillaToolTips(ItemTooltipEvent event){
        
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == ModVillagers.RAMENTRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.RAMEN.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.BRONZE_RYO.get(), 1),
                    stack,4,5,0.09F));

        }
    }

}


