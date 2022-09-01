package com.godhenko.narutorevival.entity.tradeprofressions;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.ItemInit;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = NarutoRevival.MOD_ID)
public class CustomVillagerTrades {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if (event.getType() == ModVillagers.RAMENTRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack trade1 = new ItemStack(ItemInit.RAMEN.get(), 12);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.BRONZE_RYO.get(), 1),
                    trade1, 4, 5, 0.09F));
        }
        if (event.getType() == ModVillagers.RAMENTRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack trade1 = new ItemStack(ItemInit.SPECIAL_RAMEN.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.GOLD_RYO.get(), 1),
                    trade1, 4, 5, 0.09F));
        }
        if (event.getType() == ModVillagers.WEAPONTRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack trade1 = new ItemStack(ItemInit.KATANA.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.BRONZE_RYO.get(), 1),
                    trade1, 3, 5, 0.09F));
        }


    }
}
