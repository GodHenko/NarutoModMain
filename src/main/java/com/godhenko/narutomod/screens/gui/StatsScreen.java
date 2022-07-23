
package com.godhenko.narutomod.screens.gui;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.network.NarutoRevivalModVariables;
import com.godhenko.narutomod.network.StatsButtonMessage;
import com.godhenko.narutomod.procedures.guiprocedures.*;
import com.godhenko.narutomod.procedures.guiprocedures.barprocedures.*;
import com.godhenko.narutomod.world.inventory.StatsMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

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
		this.imageWidth = 300;
		this.imageHeight = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/stats.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/emptybar.png"));
		this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);

		if (Bar10showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/1_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (Bar20showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/2_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (Bar30showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/3_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (Bar40showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/4_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (Bar50ShowProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/5_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (Bar60ShowProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/6_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (Bar70showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/7_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (Bar80showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/8_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (Bar90showProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/9_10bar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
		}
		if (FullbarshowProcedure.execute(world)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(NarutoMod.MOD_ID, "textures/gui/fullbar.png"));
			this.blit(ms, this.leftPos + 68, this.topPos + 50, 0, 0, 102, 6, 102, 6);
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
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).XP) + "", 68, 32, -12829636);
		this.font.draw(poseStack, "/", 104, 32, -12829636);
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).maxLvlXp) + "", 113, 32, -12829636);
		this.font.draw(poseStack, "Lvl: " + (int) (NarutoRevivalModVariables.MapVariables.get(world).Lvl) + "", 68, 14, -12829636);
		this.font.draw(poseStack, "strength", 64, 82, -12829636);
		this.font.draw(poseStack, "SKILLS", 68, 64, -12829636);
		this.font.draw(poseStack, "skill points: " + (int) (NarutoRevivalModVariables.MapVariables.get(world).skillPoints) + "", 127, 64, -12829636);
		this.font.draw(poseStack, "--------------------------------", 64, 71, -12829636);
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).strength) + "", 64, 95, -12829636);
		this.font.draw(poseStack, "--------------------------------", 64, 104, -12829636);
		this.font.draw(poseStack, "agility", 64, 113, -12829636);
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).agility) + "", 64, 127, -12829636);
		this.font.draw(poseStack, "--------------------------------", 64, 136, -12829636);
		this.font.draw(poseStack, "--------------------------------", 64, 55, -12829636);
		this.font.draw(poseStack, "speed", 64, 145, -12829636);
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).speed) + "", 64, 158, -12829636);
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addstrength) + "", 151, 88, -12829636);
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addagility) + "", 151, 122, -12829636);
		this.font.draw(poseStack, "+ " + (int) (NarutoRevivalModVariables.MapVariables.get(world).addspeed) + "", 151, 154, -12829636);
		this.font.draw(poseStack, "" + (int) (NarutoRevivalModVariables.MapVariables.get(world).progresspercent) + " %", 173, 47, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 116, this.topPos + 83, 30, 20, new TextComponent("-"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(0, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 199, this.topPos + 83, 30, 20, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(1, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 254, this.topPos + 83, 35, 20, new TextComponent("OK"), e -> {
			if (ShowOkstrengthProcedure.execute(world)) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(2, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkstrengthProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 116, this.topPos + 116, 30, 20, new TextComponent("-"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(3, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 199, this.topPos + 116, 30, 20, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(4, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 254, this.topPos + 116, 35, 20, new TextComponent("OK"), e -> {
			if (ShowOkagilityProcedure.execute(world)) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(5, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ShowOkagilityProcedure.execute(world))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 116, this.topPos + 148, 30, 20, new TextComponent("-"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(6, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 199, this.topPos + 148, 30, 20, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(7, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 254, this.topPos + 148, 35, 20, new TextComponent("OK"), e -> {
			if (ShowOkspeedProcedure.execute(world)) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(8, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 8, x, y, z);
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
