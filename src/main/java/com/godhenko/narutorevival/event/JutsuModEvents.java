package com.godhenko.narutorevival.event;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.commands.statguicommands.StatCommands;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuItem;
import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.godhenko.narutorevival.jutsus.network.EarthArmorNetworkChannel;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.extra.StatNetworkChannel;
import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.network.extra.misc.KeyBindings;
import com.godhenko.narutorevival.network.extra.misc.network.GatherManaPacket;
import com.godhenko.narutorevival.network.extra.render.LvlOverlay;
import com.godhenko.narutorevival.network.extra.render.ChakraOverlay;
import com.godhenko.narutorevival.network.extra.render.SpOverlay;
import com.godhenko.narutorevival.network.extra.stat.StatCapability;
import com.godhenko.narutorevival.network.extra.stat.StatCapabilityProvider;
import com.godhenko.narutorevival.network.extra.util.LevelingHelper;
import com.godhenko.narutorevival.projectile.model.*;
import com.godhenko.narutorevival.projectile.render.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class JutsuModEvents {
    @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class Events {
        @SubscribeEvent
        public static void tick(TickEvent.ServerTickEvent event) {
            if (event.phase == TickEvent.Phase.START) return;

            JutsuTicker.tick();

            for (Stats stats : Stats.values()) {
                stats.get().getManager().tick();
            }
        }
        @SubscribeEvent
        public static void onPlayerClone(PlayerEvent.Clone event) {
            Player oldPlayer = event.getOriginal();
            Player newPlayer = event.getPlayer();

            oldPlayer.reviveCaps();

            float lvl = Stats.CHAKRA.get().getManager().get(oldPlayer);
            float sp = Stats.JP.get().getManager().get(oldPlayer);

            oldPlayer.invalidateCaps();

            Stats.CHAKRA.get().getManager().set(newPlayer, lvl);
            Stats.JP.get().getManager().set(newPlayer, sp);
        }

        @SubscribeEvent
        public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player player) {
                for (Stats stats : Stats.values()) {
                    event.addCapability(
                            new ResourceLocation(NarutoRevival.NAMESPACE, "player" + stats.get().getId()),
                            new StatCapabilityProvider(player)
                    );
                }
            }
        }

        @SubscribeEvent
        public static void registerCommands(RegisterCommandsEvent event) {
            StatCommands.register(event.getDispatcher());

        }

        @SubscribeEvent
        public static void updateLootTables(LootTableLoadEvent event) {
            ResourceLocation tableId = event.getName();
            if (tableId.getPath().startsWith("chests/village/") && tableId.getNamespace().equals(ResourceLocation.DEFAULT_NAMESPACE)) {
                LootTable table = event.getTable();

                LootPool pool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))



                        .build();

                table.addPool(pool);
            }
        }

        @SubscribeEvent
        public static void playerLevelUp(LivingDeathEvent event) {
            Entity entity = event.getSource().getEntity();
            if (entity instanceof Player player) {

            }
        }
    }

    @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class EventsMod {
        @SubscribeEvent
        public static void registerCapabilities(RegisterCapabilitiesEvent event) {
            event.register(StatCapability.class);
        }

        @SubscribeEvent
        public static void setup(FMLCommonSetupEvent event) {
            StatNetworkChannel.register();
            EarthArmorNetworkChannel.register();
        }
    }

    @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class EventsClient {
        @SubscribeEvent
        public static void tickClient(TickEvent.ClientTickEvent event) {
            Level level = Minecraft.getInstance().level;
            if (event.phase != TickEvent.Phase.START || level == null || Minecraft.getInstance().screen != null) {
                return;
            }

            if (KeyBindings.GATHER_MANA_KEYBINDING.isDown()) {
                StatNetworkChannel.sendC2S(new GatherManaPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = NarutoRevival.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class EventsModClient {
        @SubscribeEvent
        public static void setupClient(FMLClientSetupEvent event) {
            OverlayRegistry.registerOverlayTop("ManaBar", ChakraOverlay.MANA_BAR_OVERLAY);
            OverlayRegistry.registerOverlayTop("LvlBar", LvlOverlay.LVL_BAR_OVERLAY);
            OverlayRegistry.registerOverlayTop("SpBar", SpOverlay.SP_BAR_OVERLAY);

            KeyBindings.register();

            event.enqueueWork(() -> {
                for (RegistryObject<Item> registryObject : ModRegistry.ITEMS.getEntries()) {
                    Item item = registryObject.get();
                    if (item instanceof JutsuItem) {
                        ItemProperties.register(item, new ResourceLocation(NarutoRevival.NAMESPACE, "spell_level"), (stack, level, living, id) -> {
                            float spellLevel = JutsuItem.getSpellLevel(stack);
                            return spellLevel * 0.1f;
                        });
                    }
                }
            });
        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModRegistry.AIR_BURST_PROJECTILE.get(), NoopRenderer::new);
            event.registerEntityRenderer(ModRegistry.EARTH_TRAP_PROJECTILE.get(), NoopRenderer::new);
            event.registerEntityRenderer(ModRegistry.FIREBALL_PROJECTILE.get(), FireballRenderer::new);
            event.registerEntityRenderer(ModRegistry.LIGHTNING_BALL_PROJECTILE.get(), LightningBallRenderer::new);
            event.registerEntityRenderer(ModRegistry.SHARK_PROJECTILE.get(), SharkRenderer::new);
            event.registerEntityRenderer(ModRegistry.ICE_NEEDLES_PROJECTILE.get(), IceNeedlesRenderer::new);

        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.AddLayers event) {
            event.getSkins().forEach(skin -> {
                addLayerToPlayerSkin(event, skin, EarthArmorLayer::new);
            });
        }

        // method from gigaherz: https://github.com/gigaherz/ToolBelt
        @SuppressWarnings({"rawtypes", "unchecked"})
        private static <E extends Player, M extends HumanoidModel<E>>
        void addLayerToPlayerSkin(EntityRenderersEvent.AddLayers event, String skinName, Function<LivingEntityRenderer<E, M>, ? extends RenderLayer<E, M>> factory) {
            LivingEntityRenderer renderer = event.getSkin(skinName);
            if (renderer != null) renderer.addLayer(factory.apply(renderer));
        }

        @SubscribeEvent
        public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(FireballModel.LAYER_LOCATION, FireballModel::createBodyLayer);
            event.registerLayerDefinition(LightningBallModel.LAYER_LOCATION, LightningBallModel::createBodyLayer);
            event.registerLayerDefinition(SharkModel.LAYER_LOCATION, SharkModel::createBodyLayer);
            event.registerLayerDefinition(IceNeedlesModel.LAYER_LOCATION, IceNeedlesModel::createBodyLayer);
            event.registerLayerDefinition(OverloadModel.LAYER_LOCATION, OverloadModel::createBodyLayer);
            event.registerLayerDefinition(EarthArmorModel.LAYER_LOCATION, EarthArmorModel::createBodyLayer);
        }
    }
}

