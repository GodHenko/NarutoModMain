package com.godhenko.narutorevival.event;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.world.generation.ModEntityGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NarutoRevival.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){

        ModEntityGeneration.onEntitySpawn(event);
    }
}
