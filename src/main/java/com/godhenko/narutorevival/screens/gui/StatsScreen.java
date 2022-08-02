
package com.godhenko.narutorevival.screens.gui;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.StatsButtonMessage;
import com.godhenko.narutorevival.procedures.guiprocedures.barprocedures.*;
import com.godhenko.narutorevival.procedures.guiprocedures.showprocedures.*;
import com.godhenko.narutorevival.world.inventory.StatsMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
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
	public static final ResourceLocation addbutton = new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/addbutton.png");



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

		RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/emptybar.png"));
		this.blit(ms, this.leftPos +16, this.topPos + 280, 0, 0, 102, 6, 102, 6);

		if (Bar10showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/1_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (Bar20showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/2_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (Bar30showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/3_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (Bar40showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/4_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (Bar50ShowProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/5_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (Bar60ShowProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/6_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (Bar70showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/7_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (Bar80showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/8_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (Bar90showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/9_10bar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (FullbarshowProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID, "textures/gui/fullbar.png"));
			this.blit(ms, this.leftPos + 16, this.topPos + 280, 0, 0, 102, 6, 102, 6);
		}
		if (NarutoRevivalModVariables.MapVariables.get(world).clan == 1){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/uchiha.png"));
			this.blit(ms, this.leftPos + 223, this.topPos + 58, 0, 0, 250, 250, 250, 250);
		}
		if (NarutoRevivalModVariables.MapVariables.get(world).clan == 2){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/hyuga.png"));
			this.blit(ms, this.leftPos + 223, this.topPos + 58, 0, 0, 250, 250, 250, 250);
		}
		if (NarutoRevivalModVariables.MapVariables.get(world).clan == 3){
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoRevival.MOD_ID,"textures/gui/clans/uzumaki.png"));
			this.blit(ms, this.leftPos + 223, this.topPos + 58, 0, 0, 250, 250, 250, 250);
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
		this.font.draw(poseStack, (int) (NarutoRevivalModVariables.MapVariables.get(world).XP) + "/" + (int) (NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp) + "", 16, 272, Color.black.getRGB());
		this.font.draw(poseStack, "Lvl: " + (int) (NarutoRevivalModVariables.MapVariables.get(world).Lvl) + "", 92, 272, Color.black.getRGB());
		this.font.draw(poseStack, "Ninjutsu", 10, 64, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 64, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).ninjutsu) + "", 92, 64, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addninjutsu) + "", 116, 64, Color.black.getRGB());

		this.font.draw(poseStack, "Taijutsu", 10, 74, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 74, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).taijutsu) + "", 92, 74, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addtaijutsu) + "", 116, 74, Color.black.getRGB());

		this.font.draw(poseStack, "Genjutsu", 10, 84, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 84, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).genjutsu) + "", 92, 84, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addgenjutsu) + "", 116, 84, Color.black.getRGB());

		this.font.draw(poseStack, "Kenjutsu", 10, 94, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 94, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).kenjutsu) + "", 92, 94, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addkenjutsu) + "", 116, 94, Color.black.getRGB());

		this.font.draw(poseStack, "Shurikenjutsu", 10, 104, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 104, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).shurikenjutsu) + "", 92, 104, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addshurikenjutsu) + "", 116, 104, Color.black.getRGB());

		this.font.draw(poseStack, "Summoning", 10, 114, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 114, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).summoning) + "", 92, 114, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addsummoning) + "", 116, 114, Color.black.getRGB());

		this.font.draw(poseStack, "Kinjutsu", 10, 124, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 124, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).kinjutsu) + "", 92, 124, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addkinjutsu) + "", 116, 124, Color.black.getRGB());

		this.font.draw(poseStack, "Senjutsu", 10, 134, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 134, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).senjutsu) + "", 92, 134, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addsenjutsu) + "", 116, 134, Color.black.getRGB());

		this.font.draw(poseStack, "Medical", 10, 144, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 144, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).medical) + "", 92, 144, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addmedical) + "", 116, 144, Color.black.getRGB());

		this.font.draw(poseStack, "Speed", 10, 154, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 154, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).speed) + "", 92, 154, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addspeed) + "", 116, 154, Color.black.getRGB());

		this.font.draw(poseStack, "Intelligence", 10, 164, Color.black.getRGB());
		this.font.draw(poseStack, ":", 90, 164, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).intelligence) + "", 92, 164, Color.black.getRGB());
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addintelligence) + "", 116, 164, Color.black.getRGB());
		this.font.draw(poseStack, (NarutoRevivalModVariables.MapVariables.get(world).chakra) + "/" + (int) (NarutoRevivalModVariables.MapVariables.get(world).maxChakra) + "", 200, 200, Color.black.getRGB());

		if (NarutoRevivalModVariables.MapVariables.get(world).clan == 0){
			this.font.draw(poseStack, "Clan:" , 200, 64, Color.black.getRGB());
		} else if (NarutoRevivalModVariables.MapVariables.get(world).clan == 1){
			this.font.draw(poseStack, "Clan:    "  + "Uchiha", 200, 64, Color.black.getRGB());
		} else if (NarutoRevivalModVariables.MapVariables.get(world).clan == 2){
			this.font.draw(poseStack, "Clan:    "  + "Hyuga", 200, 64, Color.black.getRGB());
		} else if(NarutoRevivalModVariables.MapVariables.get(world).clan == 3){
			this.font.draw(poseStack, "Clan:    "  + "Uzumaki", 200, 64, Color.black.getRGB());
		}



		this.font.draw(poseStack, "Skill Points: " + (int) (NarutoRevivalModVariables.MapVariables.get(world).skillPoints) + "", 220, 280, Color.black.getRGB());
		this.font.draw(poseStack, "Jutsu Points: " + (int) (NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints) + "", 220, 272, Color.black.getRGB());
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).progresspercent) + " %", 127, 279, Color.black.getRGB());
		this.font.draw(poseStack, "Battlepower:"+ (NarutoRevivalModVariables.MapVariables.get(world).battlepower), 16, 240, Color.black.getRGB());

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
		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 63, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(0, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 63, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(1, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 63, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOkninjutsuProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(2, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkninjutsuProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		//////////
		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 73, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(3, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 73, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(4, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 73, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOktaijutsuProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(5, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOktaijutsuProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		////////////////
		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 83, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(6, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 83, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(7, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 83, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOkgenjutsuProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(8, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkgenjutsuProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		////////////////
		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 93, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(9, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 93, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(10, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 93, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOkkenjutsuProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(11, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkkenjutsuProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		///////
		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 103, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(12, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 103, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(13, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 103, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOkshurikenjutsuProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(14, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkshurikenjutsuProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		/////////////

		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 113, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(15, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 113, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(16, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 113, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOksummoningProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(17	, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOksummoningProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		////////////////

		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 123, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(18, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 123, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(19, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 123, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOkkinjutsuProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(20	, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 20, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkkinjutsuProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		//////////
		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 133, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(21, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 21, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 133, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(22, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 22, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 133, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOksenjutsuProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(23	, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 23, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOksenjutsuProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		/////////////////
		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 143, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(24, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 24, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 143, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(25, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 25, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 143, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOkmedicalProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(26	, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 26, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkmedicalProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
		///////////////////
		this.addRenderableWidget(new Button(this.leftPos + -20, this.topPos + 153, 20, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(27, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 27, x, y, z);
			}
		}));
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -40, this.topPos + 153, 20, 10, new TextComponent("-"), e -> {
			if (true) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(28, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 28, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -60, this.topPos + 153, 20, 10, new TextComponent("OK"), e -> {
			if (ShowOkspeedProcedure.execute(world)) {
				NarutoRevival.PACKET_HANDLER.sendToServer(new StatsButtonMessage(29	, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 29, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkspeedProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}

		});
	}
}
