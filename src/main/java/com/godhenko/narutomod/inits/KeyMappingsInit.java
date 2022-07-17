package com.godhenko.narutomod.inits;


import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.network.OpenStatsMenuMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KeyMappingsInit {

    public static final String CATEGORY = "keys.narutomod.category";
    public static final KeyMapping OPEN_STATS_MENU = new KeyMapping("key.narutomod.open_stats_menu", GLFW.GLFW_KEY_C,
            "key.narutomod.category");

    @SubscribeEvent
    public static void registerKeyBindings(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(OPEN_STATS_MENU);
    }

    @Mod.EventBusSubscriber({Dist.CLIENT})
    public static class KeyEventListener {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.KeyInputEvent event) {
            if (Minecraft.getInstance().screen == null) {
                if (event.getKey() == OPEN_STATS_MENU.getKey().getValue()) {
                    if (event.getAction() == GLFW.GLFW_PRESS) {
                        NarutoMod.PACKET_HANDLER.sendToServer(new OpenStatsMenuMessage(0, 0));
                        OpenStatsMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
                    }
                }
            }
        }
    }
}