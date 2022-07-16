package com.godhenko.narutomod.client;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.api.client.ClientReg;
import com.godhenko.narutomod.client.gui.ClientEventHandler;
import com.godhenko.narutomod.client.gui.DefaultPage;
import com.godhenko.narutomod.client.gui.PlayerAttributesScreen;
import com.godhenko.narutomod.client.gui.ResistancePage;
import com.godhenko.narutomod.statsinit.Registry;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = NarutoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistry {
    public static final KeyMapping HUD = new KeyMapping("key." + ExAPI.MODID + ".hud", KeyConflictContext.IN_GAME, key(GLFW.GLFW_KEY_LEFT_ALT), "PlayerEx");

    private static InputConstants.Key key(int par0) {
        return InputConstants.Type.KEYSYM.getOrCreate(par0);
    }

    /**
     * Mod client initialisation event.
     * @param par0
     */
    @SubscribeEvent
    public static void clientSetup(final net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent par0) {
        MenuScreens.register(Registry.ATTRIBUTES_CONTAINER, PlayerAttributesScreen::new);
        net.minecraftforge.client.ClientRegistry.registerKeyBinding(HUD);

        par0.enqueueWork(() -> {
            ClientReg.registerPage(DefaultPage.REGISTRY_NAME, new DefaultPage());
            ClientReg.registerPage(ResistancePage.REGISTRY_NAME, new ResistancePage());
        });

        updateHudState();
    }

    public static void updateHudState(){
        ClientEventHandler.UTILS_BAR.forEach((element) -> OverlayRegistry.enableOverlay(element, !ClientConfig.CLIENT.enableHUD.get()));
        ClientEventHandler.HEALTH_BAR.forEach((element) -> OverlayRegistry.enableOverlay(element, !ClientConfig.CLIENT.enableHealthBar.get()));
    }
}