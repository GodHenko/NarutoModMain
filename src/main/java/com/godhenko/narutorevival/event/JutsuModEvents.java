package com.godhenko.narutorevival.event;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.chakra.PlayerChakra;
import com.godhenko.narutorevival.chakra.PlayerChakraProvider;
import com.godhenko.narutorevival.chakra.SetChakraCommand;
import com.godhenko.narutorevival.chakra.client.KeyBindings;
import com.godhenko.narutorevival.chakra.client.ManaOverlay;
import com.godhenko.narutorevival.chakra.network.ChakraNetworkChannel;
import com.godhenko.narutorevival.chakra.network.GatherChakraPacket;
import com.godhenko.narutorevival.inits.KeyMappingsInit;
import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.godhenko.narutorevival.projectile.model.*;
import com.godhenko.narutorevival.projectile.render.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class JutsuModEvents {
    @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class Events {
        @SubscribeEvent
        public static void tick(TickEvent.ServerTickEvent event) {
            if (event.phase == TickEvent.Phase.START) return;
            JutsuTicker.tick();
            ChakraManager.tick();
        }


        @SubscribeEvent
        public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player) {
                if (!event.getObject().getCapability(PlayerChakraProvider.CAPABILITY).isPresent()) {
                    event.addCapability(new ResourceLocation(NarutoRevival.NAMESPACE, "playerchakra"), new PlayerChakraProvider());
                }
            }
        }

        @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class EventsMod {
            @SubscribeEvent
            public static void registerCapabilities(RegisterCapabilitiesEvent event) {
                event.register(PlayerChakra.class);
            }

            @SubscribeEvent
            public static void setup(FMLCommonSetupEvent event) {
                ChakraNetworkChannel.register();
            }
        }



        @SubscribeEvent
        public static void registerCommands(RegisterCommandsEvent event) {
            SetChakraCommand.register(event.getDispatcher());
        }

        @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
        public static class EventsClient {
            @SubscribeEvent
            public static void tickClient(TickEvent.ClientTickEvent event) {
                Level level = Minecraft.getInstance().level;
                if (event.phase != TickEvent.Phase.START || level == null || Minecraft.getInstance().screen != null) {
                    return;
                }

                if (KeyBindings.GATHER_CHAKRA_KEYBINDING.isDown()) {
                    ChakraNetworkChannel.sendC2S(new GatherChakraPacket());
                }
            }
        }
            @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
            public static class EventsModClient {
                @SubscribeEvent
                public static void setupClient(FMLClientSetupEvent event) {
                    OverlayRegistry.registerOverlayTop("ChakraBar", ManaOverlay.MANA_BAR_OVERLAY);
                    KeyBindings.register();
                }

                @SubscribeEvent
                public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
                    event.registerEntityRenderer(ModRegistry.AIR_BURST_PROJECTILE.get(), NoopRenderer::new);
                    event.registerEntityRenderer(ModRegistry.EARTH_TRAP_PROJECTILE.get(), NoopRenderer::new);
                    event.registerEntityRenderer(ModRegistry.FIREBALL_PROJECTILE.get(), FireballRenderer::new);
                    event.registerEntityRenderer(ModRegistry.GREAT_FIREBALL_PROJECTILE.get(), GreatFireballRenderer::new);
                    event.registerEntityRenderer(ModRegistry.FIRE_BULLET_PROJECTILE.get(), NoopRenderer::new);
                    event.registerEntityRenderer(ModRegistry.LIGHTNING_BALL_PROJECTILE.get(), LightningBallRenderer::new);
                    event.registerEntityRenderer(ModRegistry.SHARK_PROJECTILE.get(), SharkRenderer::new);
                    event.registerEntityRenderer(ModRegistry.FIRE_DRAGON_PROJECTILE.get(), FireDragonRenderer::new);

                }

                @SubscribeEvent
                public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
                    event.registerLayerDefinition(FireballModel.LAYER_LOCATION, FireballModel::createBodyLayer);
                    event.registerLayerDefinition(GreatFireBallModel.LAYER_LOCATION, GreatFireBallModel::createBodyLayer);
                    event.registerLayerDefinition(LightningBallModel.LAYER_LOCATION, LightningBallModel::createBodyLayer);
                    event.registerLayerDefinition(SharkModel.LAYER_LOCATION, SharkModel::createBodyLayer);
                    event.registerLayerDefinition(DragonHeadModel.LAYER_LOCATION, DragonHeadModel::createBodyLayer);

                }
            }
        }
    }

