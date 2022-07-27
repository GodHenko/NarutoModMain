package com.godhenko.narutorevival.event;


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.godhenko.narutorevival.entity.genin.GeninEntity;
import com.godhenko.narutorevival.entity.genin.GeninModel;
import com.godhenko.narutorevival.entity.genin.GeninRenderer;
import com.godhenko.narutorevival.entity.ramenman.RamenTraderEntity;
import com.godhenko.narutorevival.entity.ramenman.RamenTraderModel;
import com.godhenko.narutorevival.entity.ramenman.RamenTraderRenderer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NarutoRevival.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.GENIN.get(), GeninEntity.setAttributes());
        event.put(ModEntityTypes.RAMEN_TRADER.get(), RamenTraderEntity.setAttributes());

    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(GeninModel.GENIN_LAYER,GeninModel::createBodyLayer);
        event.registerLayerDefinition(RamenTraderModel.RAMEN_TRADER_LAYER,RamenTraderModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.GENIN.get(), GeninRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.RAMEN_TRADER.get(), RamenTraderRenderer::new);

    }

}
