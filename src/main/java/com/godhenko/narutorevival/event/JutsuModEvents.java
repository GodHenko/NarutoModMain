package com.godhenko.narutorevival.event;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.godhenko.narutorevival.projectile.model.*;
import com.godhenko.narutorevival.projectile.render.*;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class JutsuModEvents {
    @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class Events {
        @SubscribeEvent
        public static void tick(TickEvent.ServerTickEvent event) {
            JutsuTicker.tick();
        }
    }

    @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class EventsClient {
        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModRegistry.AIR_BURST_PROJECTILE.get(), NoopRenderer::new);
            event.registerEntityRenderer(ModRegistry.EARTH_TRAP_PROJECTILE.get(), NoopRenderer::new);
            event.registerEntityRenderer(ModRegistry.FIREBALL_PROJECTILE.get(), FireballRenderer::new);
            event.registerEntityRenderer(ModRegistry.GREAT_FIREBALL_PROJECTILE.get(), GreatFireballRenderer::new);
            event.registerEntityRenderer(ModRegistry.LIGHTNING_BALL_PROJECTILE.get(), LightningBallRenderer::new);
            event.registerEntityRenderer(ModRegistry.SHARK_PROJECTILE.get(), SharkRenderer::new);

        }

        @SubscribeEvent
        public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(FireballModel.LAYER_LOCATION, FireballModel::createBodyLayer);
            event.registerLayerDefinition(GreatFireBallModel.LAYER_LOCATION, GreatFireBallModel::createBodyLayer);
            event.registerLayerDefinition(LightningBallModel.LAYER_LOCATION, LightningBallModel::createBodyLayer);
            event.registerLayerDefinition(SharkModel.LAYER_LOCATION, SharkModel::createBodyLayer);

        }
    }
}
