package com.godhenko.narutorevival.event;


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.godhenko.narutorevival.entity.ninjaentities.chunin.ChuninModel;
import com.godhenko.narutorevival.entity.ninjaentities.chunin.ChuninRenderer;
import com.godhenko.narutorevival.entity.ninjaentities.genin.GeninEntity;
import com.godhenko.narutorevival.entity.ninjaentities.genin.GeninModel;
import com.godhenko.narutorevival.entity.ninjaentities.genin.GeninRenderer;
import com.godhenko.narutorevival.entity.ninjaentities.jonin.JoninEntity;
import com.godhenko.narutorevival.entity.ninjaentities.jonin.JoninModel;
import com.godhenko.narutorevival.entity.ninjaentities.jonin.JoninRenderer;
import com.godhenko.narutorevival.entity.ramenman.RamenTraderEntity;
import com.godhenko.narutorevival.entity.ramenman.RamenTraderModel;
import com.godhenko.narutorevival.entity.ramenman.RamenTraderRenderer;
import com.mojang.datafixers.util.Either;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NarutoRevival.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {



    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.GENIN.get(), GeninEntity.setAttributes());
        event.put(ModEntityTypes.CHUNIN.get(), GeninEntity.setAttributes());
        event.put(ModEntityTypes.JONIN.get(), JoninEntity.setAttributes());


        event.put(ModEntityTypes.RAMEN_TRADER.get(), RamenTraderEntity.setAttributes());

    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(GeninModel.GENIN_LAYER,GeninModel::createBodyLayer);
        event.registerLayerDefinition(ChuninModel.CHUNIN_LAYER,ChuninModel::createBodyLayer);
        event.registerLayerDefinition(JoninModel.JONIN_LAYER,JoninModel::createBodyLayer);


        event.registerLayerDefinition(RamenTraderModel.RAMEN_TRADER_LAYER,RamenTraderModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.GENIN.get(), GeninRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.CHUNIN.get(), ChuninRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.JONIN.get(), JoninRenderer::new);


        event.registerEntityRenderer(ModEntityTypes.RAMEN_TRADER.get(), RamenTraderRenderer::new);

    }
}
