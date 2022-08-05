package com.godhenko.narutorevival.inits;


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.OpenStatsMessage;
import com.godhenko.narutorevival.network.PressedChargeChakraMessage;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KeyMappingsInit {

    public static final KeyMapping OPEN_STATS = new KeyMapping("key.narutorevival.open_stats_menu", GLFW.GLFW_KEY_C, "key.narutorevival.category");

    public static final KeyMapping CHARGE_CHAKRA = new KeyMapping("key.narutorevival.charge_chakra", InputConstants.KEY_N,"key.narutorevival.category");


    @SubscribeEvent
    public static void registerKeyBindings(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(OPEN_STATS);
        ClientRegistry.registerKeyBinding(CHARGE_CHAKRA);
    }

    @Mod.EventBusSubscriber({Dist.CLIENT})
    public static class KeyEventListener {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.KeyInputEvent event) {
            if (Minecraft.getInstance().screen == null) {
                if (event.getKey() == OPEN_STATS.getKey().getValue()) {
                    if (event.getAction() == GLFW.GLFW_PRESS) {
                        NarutoRevival.PACKET_HANDLER.sendToServer(new OpenStatsMessage(0, 0));
                        OpenStatsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
                    }
                }
            }
            if (event.getKey() == CHARGE_CHAKRA.getKey().getValue()){
                if (KeyMappingsInit.CHARGE_CHAKRA.consumeClick()){
                    NarutoRevival.PACKET_HANDLER.sendToServer(new PressedChargeChakraMessage(0,0));
                    PressedChargeChakraMessage.pressAction(Minecraft.getInstance().player,0,0);
                }
            }

        }
    }
}