package com.godhenko.narutorevival.inits;


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.OpenStatsMessage;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.TextComponent;
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
    public static final KeyMapping TEST_KEYBIND = new KeyMapping("test",GLFW.GLFW_KEY_X,"key.narutorevival.category");

    public static final KeyMapping CHARGE_CHAKRA = new KeyMapping("key.narutorevival.charge_chakra", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, InputConstants.KEY_N,"key.narutorevival.category");
    public static boolean isChakraControlActive = false;
    public static final KeyMapping CHAKRA_CONTROL_KEY = new KeyMapping("key.narutorevival.chakra_control_key", GLFW.GLFW_KEY_G, "key.narutorevival.category");
    public static final KeyMapping SUBSITUTION_JUTSU = new KeyMapping("key.narutorevival.subsitution_jutsu_key",GLFW.GLFW_KEY_X,"key.narutorevival.category");

    @SubscribeEvent
    public static void registerKeyBindings(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(OPEN_STATS);
        ClientRegistry.registerKeyBinding(CHARGE_CHAKRA);
        ClientRegistry.registerKeyBinding(CHAKRA_CONTROL_KEY);
        ClientRegistry.registerKeyBinding(SUBSITUTION_JUTSU);
        ClientRegistry.registerKeyBinding(TEST_KEYBIND);
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
            if(CHAKRA_CONTROL_KEY.isDown())
            {
                if(isChakraControlActive){
                    isChakraControlActive=false;
                    LocalPlayer player = Minecraft.getInstance().player;
                    player.sendMessage(new TextComponent("Chakra Control Off"), player.getUUID());
                }
                else{

                    isChakraControlActive=true;
                    LocalPlayer player = Minecraft.getInstance().player;
                    player.sendMessage(new TextComponent("Chakra Control On"), player.getUUID());
                }
            }

        }
    }
}