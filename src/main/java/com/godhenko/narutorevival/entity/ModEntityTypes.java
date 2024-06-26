package com.godhenko.narutorevival.entity;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.ninjaentities.chunin.ChuninEntity;
import com.godhenko.narutorevival.entity.ninjaentities.genin.GeninEntity;
import com.godhenko.narutorevival.entity.ninjaentities.jonin.JoninEntity;
import com.godhenko.narutorevival.entity.ramenman.RamenTraderEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, NarutoRevival.MOD_ID);
    private static <T extends Entity> RegistryObject<EntityType<T>> register(String key, EntityType.Builder<T> builder) {
        return ENTITY_TYPE.register(key, () -> builder.build(key));
    }


    public static final RegistryObject<EntityType<RamenTraderEntity>> RAMEN_TRADER = ENTITY_TYPE.register("ramen_trader",
            () -> EntityType.Builder.of(RamenTraderEntity::new, MobCategory.CREATURE)
            .sized(0.6f, 1.95f)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("ramen_trader"));

    public static final RegistryObject<EntityType<GeninEntity>> GENIN = ENTITY_TYPE.register("genin",() -> EntityType.Builder
            .of(GeninEntity::new, MobCategory.CREATURE).sized(0.6f,1.95f).clientTrackingRange(8)
            .build("genin"));

    public static final RegistryObject<EntityType<ChuninEntity>> CHUNIN = ENTITY_TYPE.register("chunin",() -> EntityType.Builder
            .of(ChuninEntity::new, MobCategory.CREATURE).sized(0.6f,1.95f).clientTrackingRange(8)
            .build("chunin"));

    public static final RegistryObject<EntityType<JoninEntity>> JONIN = ENTITY_TYPE.register("jonin",() -> EntityType.Builder
            .of(JoninEntity::new, MobCategory.CREATURE).sized(0.6f,1.95f).clientTrackingRange(8)
            .build("jonin"));


    public static void register(IEventBus eventBus){
        ENTITY_TYPE.register(eventBus);
    }

}
