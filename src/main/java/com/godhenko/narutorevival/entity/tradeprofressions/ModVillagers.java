package com.godhenko.narutorevival.entity.tradeprofressions;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.BlockInit;
import com.godhenko.narutorevival.inits.ItemInit;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, NarutoRevival.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
            = DeferredRegister.create(ForgeRegistries.PROFESSIONS, NarutoRevival.MOD_ID);

    public static final RegistryObject<PoiType> RAMEN_POI = POI_TYPES.register("ramen_poi",() -> new PoiType
            ("ramenpoi",PoiType.getBlockStates(BlockInit.UCHIHA_CLOTH.get()),1,1));
    public static final RegistryObject<VillagerProfession> RAMENTRADER = VILLAGER_PROFESSIONS.register("ramentrader",
            () -> new VillagerProfession("ramentrader",RAMEN_POI.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, RAMEN_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

    public interface ItemListing {
        @Nullable
        MerchantOffer getOffer(Entity pTrader, Random pRand);
    }
}
