package com.godhenko.narutomod.entity;

import com.godhenko.narutomod.NarutoMod;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, NarutoMod.MOD_ID);


    public static void register(IEventBus eventBus){
        ENTITY_TYPE.register(eventBus);
    }
}
