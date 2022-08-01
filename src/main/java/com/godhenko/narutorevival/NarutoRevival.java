package com.godhenko.narutorevival;

import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.godhenko.narutorevival.entity.tradeprofressions.ModVillagers;
import com.godhenko.narutorevival.inits.BlockInit;
import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.inits.KeyMappingsInit;
import com.godhenko.narutorevival.screens.gui.ChakraOverlay;
import com.godhenko.narutorevival.sounds.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.minecraftforge.client.gui.ForgeIngameGui.HOTBAR_ELEMENT;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NarutoRevival.MOD_ID)
public class NarutoRevival
{
    
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

    public static final CreativeModeTab MISC_TAB = new CreativeModeTab("misc") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.BRONZE_RYO.get());
        }
    };

    public static final CreativeModeTab ARMOR_TAB = new CreativeModeTab("armor") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.GENIN_HELMET.get());
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


        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        KeyMappingsInit.registerKeyBindings(event);
        
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
