
package com.godhenko.narutomod.screens.gui;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.network.ModVariables;
import com.godhenko.narutomod.network.StatsButtonMessage;
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
		this.imageWidth = 176;
		this.imageHeight = 166;
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
		this.font.draw(poseStack, "Ninjutsu", 6, 7, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).ninjutsu) + "", 80, 7, -12829636);

		this.font.draw(poseStack, "Taijutsu", 6, 17, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).taijutsu) + "", 80, 17, -12829636);

		this.font.draw(poseStack, "Genjutsu", 6, 27, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).genjutsu) + "", 80, 27, -12829636);

		this.font.draw(poseStack, "Kenjutsu", 6, 37, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).kenjutsu) + "", 80, 37, -12829636);

		this.font.draw(poseStack, "Shurikenjutsu", 6, 47, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).shurikenjutsu) + "", 80, 47, -12829636);

		this.font.draw(poseStack, "Summoning", 6, 57, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).summoning) + "", 80, 57, -12829636);

		this.font.draw(poseStack, "Kinjutsu", 6, 67, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).kinjutsu) + "", 80, 67, -12829636);

		this.font.draw(poseStack, "Senjutsu", 6, 77, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).senjutsu) + "", 80, 77, -12829636);

		this.font.draw(poseStack, "Medical", 6, 87, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).medical) + "", 80, 87, -12829636);

		this.font.draw(poseStack, "Speed", 6, 97, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).speed) + "", 80, 97, -12829636);

		this.font.draw(poseStack, "Intelligence", 6, 107, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).intelligence) + "", 80, 107, -12829636);




		this.font.draw(poseStack, "Lvl:", 47, 127, -12829636);
		this.font.draw(poseStack, "XP:", 47, 137, -12829636);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModVariables.PlayerVariables())).level) + "", 80, 127, -12829636);
		this.font.draw(poseStack,
				"" + (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ModVariables.PlayerVariables())).xp) + " / "
						+ (int) ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ModVariables.PlayerVariables())).xpMax)
						+ "",
				80, 137, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 5, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(0, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 15, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(1, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 25, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(2, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));

		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 35, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(3, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));

		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 45, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(4, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));

		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 55, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(5, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));

		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 65, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(6, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));

		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 75, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(7, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));

		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 85, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(8, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));

		this.addRenderableWidget(new Button(this.leftPos + -10, this.topPos + 95, 10, 10, new TextComponent("+"), e -> {
			if (true) {
				NarutoMod.PACKET_HANDLER.sendToServer(new StatsButtonMessage(9, x, y, z));
				StatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
