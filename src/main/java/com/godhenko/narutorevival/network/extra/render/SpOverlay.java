package com.godhenko.narutorevival.network.extra.render;

import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.network.extra.client.ClientPlayerStats;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.IIngameOverlay;

public class SpOverlay {
    public static final IIngameOverlay SP_BAR_OVERLAY = (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
        gui.setupOverlayRenderState(true, false);

        Player player = (Player) Minecraft.getInstance().getCameraEntity();
        if (player == null) return;
        if (Stats.JP.get().getManager().isPlayerStatInfinite(player)) return;

        int lvl = (int) Math.floor(ClientPlayerStats.get("smmjp").get());

        gui.getFont().draw(mStack, new TranslatableComponent("other.narutorevival.sp").append(String.valueOf(lvl)), screenWidth-47, screenHeight-30, 16777215);
    };
}
