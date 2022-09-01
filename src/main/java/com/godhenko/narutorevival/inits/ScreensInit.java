package com.godhenko.narutorevival.inits;

import com.godhenko.narutorevival.screens.gui.BackpackScreen;
import com.godhenko.narutorevival.screens.gui.RyoguiScreen;
import com.godhenko.narutorevival.screens.gui.StatsScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ScreensInit {

    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MenusInit.STATS, StatsScreen::new);
        });
        event.enqueueWork(() -> {
            MenuScreens.register(MenusInit.BACKPACK, BackpackScreen::new);
        });
        event.enqueueWork(() -> {
        MenuScreens.register(MenusInit.RYOGUI, RyoguiScreen::new);
        });
    }
}


