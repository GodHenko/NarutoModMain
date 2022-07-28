package com.godhenko.narutorevival.screens.gui;

import ca.weblite.objc.Client;
import com.godhenko.narutorevival.config.NarutoConfig;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.util.ClientChakraData;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.gui.IIngameOverlay;

public class ChakraOverlay {

    public static final IIngameOverlay HUD_CHAKRA = (gui, poseStack, partialTicks, width, height) -> {
        String toDisplay = ClientChakraData.getPlayerChakra() + " / " + ClientChakraData.getPlayerMaxChakra();
        gui.getFont().draw(poseStack, toDisplay, 10, 10, 0xffffffff);

    };

}
