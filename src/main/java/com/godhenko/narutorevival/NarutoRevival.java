package com.godhenko.narutorevival;

import com.godhenko.narutorevival.config.NarutoCommonConfig;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.godhenko.narutorevival.entity.tradeprofressions.ModVillagers;
import com.godhenko.narutorevival.inits.BlockInit;
import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.inits.KeyMappingsInit;
import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.extra.util.Range;
import com.godhenko.narutorevival.sounds.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NarutoRevival.MOD_ID)
public class NarutoRevival
{
    public static final String NAMESPACE = "narutorevival";
    public static final ArrayList<Range> JUTSU_LEVEL_RANGES = new ArrayList<>();
    public static final String MOD_ID = "narutorevival";
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, MOD_ID), () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int messageID = 0;

    public static final CreativeModeTab Food_TAB = new CreativeModeTab("food") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.RAMEN.get());
        }
    };

    public static final CreativeModeTab BLOCK_TAB = new CreativeModeTab("blocks") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.UCHIHA_CLOTH.get());
        }
    };

    public static final CreativeModeTab JUTSU_TAB = new CreativeModeTab("jutsu") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ModRegistry.SKILL_LEARNER_FIRE.get());
        }
    };

    public static final CreativeModeTab ARMOR_TAB = new CreativeModeTab("armor") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.GENIN_HELMET.get());
        }
    };

    public static final CreativeModeTab CLAN_TAB = new CreativeModeTab("clans") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.UCHIHA.get());
        }
    };

    public static final CreativeModeTab MISC_TAB = new CreativeModeTab("misc") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.BRONZE_RYO.get());
        }
    };

    private static final Logger LOGGER = LogUtils.getLogger();


    public NarutoRevival()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ModEntityTypes.register(bus);
        ModSounds.register(bus);
        ModVillagers.register(bus);
        ModRegistry.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NarutoCommonConfig.SPEC, "narutorevival-common.toml");


        MinecraftForge.EVENT_BUS.register(this);
    }
    static {
        // Level ranges for books
        // They have to be added in order
        // 1st parameter is how much uses is needed to reach this level
        // 2nd parameter is the 1st of the next level
        // on the last level 2nd parameter should be Integer.MAX_VALUE
        // on the first level 1st parameter should be 0

        JUTSU_LEVEL_RANGES.add(new Range(0, 500));
        JUTSU_LEVEL_RANGES.add(new Range(500, 1000));
        JUTSU_LEVEL_RANGES.add(new Range(1000, 3000));
        JUTSU_LEVEL_RANGES.add(new Range(3000, 6000));
        JUTSU_LEVEL_RANGES.add(new Range(6000, Integer.MAX_VALUE));
    }
    private void clientSetup(final FMLClientSetupEvent event) {

    }


    private void setup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
    });

    }



    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
                                             BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }
}
