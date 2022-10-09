package com.godhenko.narutorevival.chakra.client;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.IIngameOverlay;

public class ManaOverlay {
    private static final ResourceLocation GUI_MANABAR_LOCATION = new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/chakrabar.png");

    public static final IIngameOverlay MANA_BAR_OVERLAY = (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
        gui.setupOverlayRenderState(true, false);

        Player player = (Player) Minecraft.getInstance().getCameraEntity();
        if (player == null) return;
        if (ChakraManager.isPlayerChakraInfinite(player)) return;

        int chakra = (int) Math.floor(ClientPlayerChakra.getChakra());

        gui.getFont().draw(mStack, new TranslatableComponent("other.narutorevival.chakra").append(chakra + " / " + (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).maxChakra), 10, screenHeight-30, 16777215);
        int manaBarLength = (int) Math.floor(((float) chakra / (float) (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).maxChakra) * 100f);

        RenderSystem.setShaderTexture(0, GUI_MANABAR_LOCATION);
        gui.blit(mStack, 10, screenHeight-20, 0, 0, 100, 10);
        gui.blit(mStack, 10, screenHeight-20, 0, 10, manaBarLength, 10);
    };
}
