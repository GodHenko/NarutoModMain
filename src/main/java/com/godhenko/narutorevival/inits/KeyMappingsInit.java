package com.godhenko.narutorevival.inits;


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.OpenStatsMessage;
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

    public static final KeyMapping OPEN_STATS = new KeyMapping("key.narutomod.open_stats_menu", GLFW.GLFW_KEY_C, "key.narutomod.category");

    @SubscribeEvent
    public static void registerKeyBindings(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(OPEN_STATS);
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
        }
    }
}