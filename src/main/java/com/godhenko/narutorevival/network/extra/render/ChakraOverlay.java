package com.godhenko.narutorevival.network.extra.render;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.network.extra.client.ClientPlayerStats;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.IIngameOverlay;

public class ChakraOverlay {
    private static final ResourceLocation GUI_LOCATION = new ResourceLocation(NarutoRevival.NAMESPACE, "textures/gui/overlays.png");

    public static final IIngameOverlay MANA_BAR_OVERLAY = (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
        gui.setupOverlayRenderState(true, false);

        Player player = (Player) Minecraft.getInstance().getCameraEntity();
        if (player == null) return;
        if (Stats.CHAKRA.get().getManager().isPlayerStatInfinite(player)) return;

        int chakra = (int) Math.floor(ClientPlayerStats.get("chakra").get());
        int maxChakra = (int) Math.floor(Stats.CHAKRA.get().getMax(player));
        gui.getFont().draw(mStack, new TranslatableComponent("other.Narutorevival.chakra").append(chakra + " / " + maxChakra), 10, screenHeight-30, 16777215);

        int manaBarLength = (int) Math.floor(((float) chakra / maxChakra) * 100f);

        RenderSystem.setShaderTexture(0, GUI_LOCATION);
        gui.blit(mStack, 10, screenHeight-20, 0, 0, 100, 10);
        gui.blit(mStack, 10, screenHeight-20, 0, 10, manaBarLength, 10);
    };
}
