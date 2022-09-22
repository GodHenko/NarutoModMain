
package com.godhenko.narutorevival.screens.gui;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.procedures.guiprocedures.barprocedures.*;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;


@Mod.EventBusSubscriber({Dist.CLIENT})
public class ShowprogressbarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level;
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}
			Level world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (true) {
				RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/emptybar.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);

				if (Bar10showProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/1_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (Bar20showProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/2_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (Bar30showProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/3_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (Bar40showProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/4_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (Bar50ShowProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/5_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (Bar60ShowProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/6_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (Bar70showProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/7_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (Bar80showProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/8_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (Bar90showProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/9_10bar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				if (FullbarshowProcedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/fullbar.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 102, posY + 106, 0, 0, 102, 6, 102, 6);
				}
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"Level: " + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl) + "",
						posX + 97, posY + 80, -1);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoRevivalModVariables.PlayerVariables())).XP) + " / "
								+ (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoRevivalModVariables.PlayerVariables())).maxLvlXp)
								+ "",
						posX + 96, posY + 92, -1);
			}


			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
