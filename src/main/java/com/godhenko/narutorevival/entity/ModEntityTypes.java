package com.godhenko.narutorevival.entity;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.genin.GeninEntity;
import com.godhenko.narutorevival.entity.ramenman.RamenTraderEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, NarutoRevival.MOD_ID);


    public static final RegistryObject<EntityType<RamenTraderEntity>> RAMEN_TRADER = ENTITY_TYPE.register("ramen_trader",
            () -> EntityType.Builder.of(RamenTraderEntity::new, MobCategory.CREATURE)
            .sized(0.6f, 1.95f)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("ramen_trader"));

    public static final RegistryObject<EntityType<GeninEntity>> GENIN = ENTITY_TYPE.register("genin",() -> EntityType.Builder
            .of(GeninEntity::new, MobCategory.CREATURE).sized(0.6f,1.95f).clientTrackingRange(8)
            .build("genin"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPE.register(eventBus);
    }
}
