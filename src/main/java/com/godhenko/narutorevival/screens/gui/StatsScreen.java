
package com.godhenko.narutorevival.screens.gui;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.StatsButtonMessage;
import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.network.extra.client.ClientPlayerStats;
import com.godhenko.narutorevival.util.KeyboardHelper;
import com.godhenko.narutorevival.world.inventory.StatsMenu;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;



public class StatsScreen extends AbstractContainerScreen<StatsMenu> {
	private final static HashMap<String, Object> guistate = StatsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public StatsScreen(StatsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 365;
		this.imageHeight = 300;
	}

	private static final ResourceLocation texture = new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/stats.png");
	private static final ResourceLocation addbutton = new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/addbutton.png");
	private static final ResourceLocation addtenbutton = new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/addtenbutton.png");
	private static final ResourceLocation OVERLAY = new ResourceLocation(NarutoRevival.NAMESPACE, "textures/gui/overlays.png");



	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		int current = (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).XP);;
		int level = (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl);
		int xpLeft = (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).maxLvlXp);
		int progress = (int) Math.floor(((float) current / xpLeft) * 100f);

		RenderSystem.setShaderTexture(0, OVERLAY);
		this.blit(ms, this.leftPos +16, this.topPos + 280, 0, 0, 20, 250, 10,250,250);
		this.blit(ms, this.leftPos +16, this.topPos + 280, 0, 0, 30, progress, 250, 250,250);


		//CLANS
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 1){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/uchiha.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 2){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/hyuga.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 3){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/uzumaki.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 4){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/aburame.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 5){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/akimichi.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 6){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/hatake.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 7){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/hozuki.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 8){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/iburi.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 9){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/inuzuka.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 10){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/jugo.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 11){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/kaguya.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 12){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/kurama.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 13){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/tsuchigumo.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 14){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/nara.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 15){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/sarutobi.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 16){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/fuma.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 17){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/senju.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 18){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/yuki.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 19){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/yamanaka.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 20){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/lee.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 21){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/chinoike.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 22){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/shirogane.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 49, 0, 0, 250, 250, 250, 250);
		}
		//Affil
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 5){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/akatsuki.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 6){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/ame.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 7){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/getsu.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 8){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/hoshi.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 9){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/ishi.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 4){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/iwa.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 10){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/jomae.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 11){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/kiri.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 1){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/konoha.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 3){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/kumo.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 12){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/kusa.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 13){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/nadeshiko.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 14){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/oto.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 15){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/ryuchi.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 24){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/shikotsu.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 16){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/shimo.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 2){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/suna.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 17){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/taki.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 18){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/takumi.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 19){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/tani.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 20){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/toad.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 21){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/yuga.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 22){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/yuki.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 23){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/affiliations/yume.png"));
			this.blit(ms, this.leftPos + 215, this.topPos + 68, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).fire) == 1){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/natures/fire.png"));
			this.blit(ms, this.leftPos + 170, this.topPos + 110, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).water) == 1){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/natures/water.png"));
			this.blit(ms, this.leftPos + 190, this.topPos + 110, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).wind) == 1){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/natures/wind.png"));
			this.blit(ms, this.leftPos + 210, this.topPos + 110, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).earth) == 1){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/natures/earth.png"));
			this.blit(ms, this.leftPos + 230, this.topPos + 110, 0, 0, 250, 250, 250, 250);
		}
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).lightning) == 1){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/natures/lightning.png"));
			this.blit(ms, this.leftPos + 250, this.topPos + 110, 0, 0, 250, 250, 250, 250);
		}





		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,
				"" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).XP) + " / "
						+ (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoRevivalModVariables.PlayerVariables())).maxLvlXp)
						+ "", 16, 272, Color.black.getRGB());
		this.font.draw(poseStack, "Lvl: " + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl) + "", 16, 263, Color.black.getRGB());
		this.font.draw(poseStack, "Ninjutsu", 10, 55, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 55, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).ninjutsu) + "", 92, 55, Color.black.getRGB());

		this.font.draw(poseStack, "Taijutsu", 10, 70, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 70, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).taijutsu) + "", 92, 70, Color.black.getRGB());

		this.font.draw(poseStack, "Genjutsu", 10, 85, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 85, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).genjutsu) + "", 92, 85, Color.black.getRGB());

		this.font.draw(poseStack, "Kenjutsu", 10, 100, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 100, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).kenjutsu) + "", 92, 100, Color.black.getRGB());

		this.font.draw(poseStack, "Shurikenjutsu", 10, 115, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 115, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).shurikenjutsu) + "", 92, 115, Color.black.getRGB());

		this.font.draw(poseStack, "Summoning", 10, 130, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 130, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).summoning) + "", 92, 130, Color.black.getRGB());

		this.font.draw(poseStack, "Kinjutsu", 10, 145, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 145, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).kinjutsu) + "", 92, 145, Color.black.getRGB());

		this.font.draw(poseStack, "Senjutsu", 10, 160, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 160, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).senjutsu) + "", 92, 160, Color.black.getRGB());

		this.font.draw(poseStack, "Medical", 10, 175, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 175, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).medical) + "", 92, 175, Color.black.getRGB());

		this.font.draw(poseStack, "Speed", 10, 190, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 190, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).speed) + "", 92, 190, Color.black.getRGB());

		this.font.draw(poseStack, "Intelligence", 10, 205, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 205, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).intelligence) + "", 92, 205, Color.black.getRGB());

		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 0){
			this.font.draw(poseStack, "Clan:" , 167, 55, Color.black.getRGB());
		} else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 1){
			this.font.draw(poseStack, "Clan:    "  + "Uchiha", 167, 55, Color.black.getRGB());
		} else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 2){
			this.font.draw(poseStack, "Clan:    "  + "Hyuga", 167, 55, Color.black.getRGB());
		} else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 3){
			this.font.draw(poseStack, "Clan:    "  + "Uzumaki", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 4){
			this.font.draw(poseStack, "Clan:    "  + "Aburame", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 5){
			this.font.draw(poseStack, "Clan:    "  + "Akimichi", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 6){
			this.font.draw(poseStack, "Clan:    "  + "Hatake", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 7){
			this.font.draw(poseStack, "Clan:    "  + "Hozuki", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 8){
			this.font.draw(poseStack, "Clan:    "  + "Iburi", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 9){
			this.font.draw(poseStack, "Clan:    "  + "Inuzuka", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 10){
			this.font.draw(poseStack, "Clan:    "  + "Jugo", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 11){
			this.font.draw(poseStack, "Clan:    "  + "Kaguya", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 12){
			this.font.draw(poseStack, "Clan:    "  + "Kurama", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 13){
			this.font.draw(poseStack, "Clan:    "  + "Tsuchigumo", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 14){
			this.font.draw(poseStack, "Clan:    "  + "Nara", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 15){
			this.font.draw(poseStack, "Clan:    "  + "Sarutobi", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 16){
			this.font.draw(poseStack, "Clan:    "  + "Fuma", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 17){
			this.font.draw(poseStack, "Clan:    "  + "Senju", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 18){
			this.font.draw(poseStack, "Clan:    "  + "Yuki", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 19){
			this.font.draw(poseStack, "Clan:    "  + "Yamanaka", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 20){
			this.font.draw(poseStack, "Clan:    "  + "Lee", 167, 55, Color.black.getRGB());
		}else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 21){
			this.font.draw(poseStack, "Clan:    "  + "Chinoike", 167, 55, Color.black.getRGB());
		} else if(((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) == 22){
			this.font.draw(poseStack, "Clan:    "  + "Shirogane", 167, 55, Color.black.getRGB());
		}
		//affil
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 0){
			this.font.draw(poseStack, "Affiliation:    "  + "", 167, 70, Color.black.getRGB());
		} else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 1){
			this.font.draw(poseStack, "Affiliation:    "  + "Konohagakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 2){
			this.font.draw(poseStack, "Affiliation:    "  + "Sunagakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 3){
			this.font.draw(poseStack, "Affiliation:    "  + "Kumogakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 4){
			this.font.draw(poseStack, "Affiliation:    "  + "Iwagakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 5){
			this.font.draw(poseStack, "Affiliation:    "  + "Akatsuki", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 6){
			this.font.draw(poseStack, "Affiliation:    "  + "Amegakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 7){
			this.font.draw(poseStack, "Affiliation:    "  + "Getsugakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 8){
			this.font.draw(poseStack, "Affiliation:    "  + "Hoshigakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 9){
			this.font.draw(poseStack, "Affiliation:    "  + "Ishigakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 10){
			this.font.draw(poseStack, "Affiliation:    "  + "Jomae", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 11){
			this.font.draw(poseStack, "Affiliation:    "  + "Kirigakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 12){
			this.font.draw(poseStack, "Affiliation:    "  + "Kusagakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 13){
			this.font.draw(poseStack, "Affiliation:    "  + "Nadeshiko", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 14){
			this.font.draw(poseStack, "Affiliation:    "  + "Otagakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 15){
			this.font.draw(poseStack, "Affiliation:    "  + "Ryuchi Cave", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 16){
			this.font.draw(poseStack, "Affiliation:    "  + "Shimogakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 17){
			this.font.draw(poseStack, "Affiliation:    "  + "Takigaure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 18){
			this.font.draw(poseStack, "Affiliation:    "  + "Takumi", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 19){
			this.font.draw(poseStack, "Affiliation:    "  + "Tanigakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 20){
			this.font.draw(poseStack, "Affiliation:    "  + "Mount Myoboku", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 21){
			this.font.draw(poseStack, "Affiliation:    "  + "Yugagakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 22){
			this.font.draw(poseStack, "Affiliation:    "  + "Yukigakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 23){
			this.font.draw(poseStack, "Affiliation:    "  + "Yumegakure", 167, 70, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).village) == 24){
			this.font.draw(poseStack, "Affiliation:    "  + "Shikotsu", 167, 70, Color.black.getRGB());
		}
		//Rank
		if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).rank) == 0){
			this.font.draw(poseStack, "Rank:"  + "", 167, 85, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).rank) == 1){
			this.font.draw(poseStack, "Rank:"  + "Academy Student", 167, 85, Color.black.getRGB());
		} else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).rank) == 2) {
			this.font.draw(poseStack, "Rank:"  + "Genin", 167, 85, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).rank) == 3) {
			this.font.draw(poseStack, "Rank:"  + "Chunin", 167, 85, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).rank) == 4) {
			this.font.draw(poseStack, "Rank:"  + "Jonin", 167, 85, Color.black.getRGB());
		}else if (((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).rank) == 6) {
			this.font.draw(poseStack, "Rank:" + "Kazekage", 167, 85, Color.black.getRGB());
		}

		this.font.draw(poseStack, "Nature Release" , 167, 100, Color.black.getRGB());

		this.font.draw(poseStack, "Skill Points: " + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).skillPoints) + "", 200, 280, Color.black.getRGB());
		this.font.draw(poseStack, "Jutsu Points: " + (int) Math.floor(ClientPlayerStats.get("smmjp").get())+ "", 200, 272, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).progresspercent) + " %", 127, 279, Color.black.getRGB());
		this.font.draw(poseStack, "Battlepower:"+ ((entity.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoRevivalModVariables.PlayerVariables())).battlepower), 16, 240, Color.black.getRGB());

	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
			this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
			this.addRenderableWidget(new ImageButton(this.leftPos-20,this.topPos + 51, 20, 15, 256,256,addbutton, e -> {
				if (KeyboardHelper.isHoldingShift()) {
					NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(10, x, y, z));
					StatsButtonMessage.handleButtonAction(entity, 10, x, y, z);
				}else {
					NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(0, x, y, z));
					StatsButtonMessage.handleButtonAction(entity, 0, x, y, z);
				}
				((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 51);
			}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 66, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(11, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(1, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 66);

		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 81, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(12, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(2, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 81);

		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 96, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(13, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(3, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 96);

		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 111, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(14, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(4, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 111);

		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 126, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(15, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(5, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 126);

		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 141, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(16, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(6, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 141);

		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 156, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(17, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(7, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 156);

		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 171, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(18, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(8, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 171);

		}));

		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new ImageButton(this.leftPos + -20, this.topPos + 186, 20, 15, 256,256,addbutton, e -> {
			if (KeyboardHelper.isHoldingShift()) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(19, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}else {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(9, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
			((ImageButton)e).setPosition(this.leftPos + -20, this.topPos + 186);

		}));
	}
}
