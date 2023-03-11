package com.godhenko.narutorevival.network.extra.render;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.network.extra.client.ClientPlayerStats;
import com.godhenko.narutorevival.network.extra.util.LevelingHelper;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.IIngameOverlay;

public class LvlOverlay {
    private static final ResourceLocation GUI_LOCATION = new ResourceLocation(NarutoRevival.NAMESPACE, "textures/gui/overlays.png");

    public static final IIngameOverlay LVL_BAR_OVERLAY = (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
        gui.setupOverlayRenderState(true, false);

        Player player = (Player) Minecraft.getInstance().getCameraEntity();
        if (player == null) return;
        if (Stats.LVL.get().getManager().isPlayerStatInfinite(player)) return;

        int current = (int) ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).XP);;
        int level = (int) ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl);
        int xpLeft = (int) ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).maxLvlXp);
        int progress = (int) Math.floor(((float) current / xpLeft) * 100f);

        gui.getFont().draw(mStack, new TranslatableComponent("other.narutorevival.lvl").append(String.valueOf(level)), screenWidth - 110, screenHeight-30, 16777215);
        gui.getFont().draw(mStack, new TranslatableComponent("other.narutorevival.xp").append(current + " / " + xpLeft), screenWidth - 110, screenHeight-45, 16777215);

        RenderSystem.setShaderTexture(0, GUI_LOCATION);
        gui.blit(mStack, screenWidth-110, screenHeight-20, 0, 20, 100, 10);
        gui.blit(mStack, screenWidth-110, screenHeight-20, 0, 30, progress, 10);
    };
}
