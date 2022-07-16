package com.godhenko.narutomod.client.gui;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.api.RevivalAPI;
import com.godhenko.narutomod.api.attribute.IPlayerAttribute;
import com.godhenko.narutomod.api.attribute.PlayerAttributes;
import com.godhenko.narutomod.api.client.ClientReg;
import com.godhenko.narutomod.api.client.Page;
import com.godhenko.narutomod.statsinit.Registry;
import com.godhenko.narutomod.statsinit.capability.AddPlayerAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;

public class DefaultPage extends Page {
	
	/** Registry Name for this page. */
	public static final ResourceLocation REGISTRY_NAME = new ResourceLocation(NarutoMod.MODID, "player_attributes");
	private final List<DynamicTextComponent> dynamicTextComponents = new ArrayList<DynamicTextComponent>();
	private final IPlayerAttribute[] idToAttribute = new IPlayerAttribute[] {PlayerAttributes.CONSTITUTION, PlayerAttributes.STRENGTH, PlayerAttributes.DEXTERITY, PlayerAttributes.INTELLIGENCE, PlayerAttributes.LUCKINESS};
	private final DecimalFormat text = new DecimalFormat("##.##");
	
	private final DynamicTextComponent level = new DynamicTextComponent(20, 50, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.level", (int)par1.get(par0, PlayerAttributes.LEVEL), (int)(100 * par1.expCoeff(par0)), "%");
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.level.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.LEVEL.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	
	private final DynamicTextComponent skillPoints = new DynamicTextComponent(20, 62, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.skillpoints", (int)par1.get(par0, PlayerAttributes.SKILLPOINTS));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.skillpoints.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.SKILLPOINTS.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent constitution = new DynamicTextComponent(30, 86, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.constitution", (int)par1.get(par0, PlayerAttributes.CONSTITUTION));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.constitution.alt0")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.constitution.alt1")));
		
		ClientReg.getTooltips(PlayerAttributes.CONSTITUTION.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent strength = new DynamicTextComponent(30, 110, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.strength", (int)par1.get(par0, PlayerAttributes.STRENGTH));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.strength.alt0")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.strength.alt1")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.strength.alt2")));
		
		ClientReg.getTooltips(PlayerAttributes.STRENGTH.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent dexterity = new DynamicTextComponent(30, 134, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.dexterity", (int)par1.get(par0, PlayerAttributes.DEXTERITY));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.dexterity.alt0")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.dexterity.alt1")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.dexterity.alt2")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.dexterity.alt3")));
		
		ClientReg.getTooltips(PlayerAttributes.DEXTERITY.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent intelligence = new DynamicTextComponent(30, 158, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.intelligence", (int)par1.get(par0, PlayerAttributes.INTELLIGENCE));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.intelligence.alt0")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.intelligence.alt1")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.intelligence.alt2")));
		
		ClientReg.getTooltips(PlayerAttributes.INTELLIGENCE.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent luckiness = new DynamicTextComponent(30, 182, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.luckiness", (int)par1.get(par0, PlayerAttributes.LUCKINESS));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.luckiness.alt0")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.luckiness.alt1")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.luckiness.alt2")));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.luckiness.alt3")));
		
		ClientReg.getTooltips(PlayerAttributes.LUCKINESS.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent health = new DynamicTextComponent(130, 50, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.health", text.format((par0.getHealth() + par0.getAbsorptionAmount())), text.format(par0.getMaxHealth()));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.health.alt0")));
		var0.add(new TextComponent(" "));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.health.alt1") + text.format(((400D / 9D) * par1.get(par0, PlayerAttributes.HEALTH_REGEN))) + "/s"));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.health.alt2") + text.format(100D * par1.get(par0, PlayerAttributes.HEALTH_REGEN_AMP)) + "%"));
		
		ClientReg.getTooltips(PlayerAttributes.MAX_HEALTH.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent armor = new DynamicTextComponent(130, 62, (par0, par1) -> {
		String var0 = text.format(par1.get(par0, PlayerAttributes.ARMOR));
		TranslatableComponent var1 = new TranslatableComponent(NarutoMod.MODID + ".attribute.armor", var0);
		
		return var1.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		String var1 = text.format(par1.get(par0, PlayerAttributes.ARMOR_TOUGHNESS));
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.armor.alt0")));
		var0.add(new TextComponent(" "));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.armor.alt1") + var1));
		
		ClientReg.getTooltips(PlayerAttributes.ARMOR.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent attackSpeed = new DynamicTextComponent(130, 74, (par0, par1) -> {
		String var0 = text.format(par1.get(par0, PlayerAttributes.ATTACK_SPEED));
		TranslatableComponent var1 = new TranslatableComponent(NarutoMod.MODID + ".attribute.attack_speed", var0);
		
		return var1.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.attack_speed.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.ATTACK_SPEED.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent melee = new DynamicTextComponent(130, 86, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.melee", text.format(par1.get(par0, PlayerAttributes.MELEE_DAMAGE)));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.melee.alt0") + text.format(100D + (100D * par1.get(par0, PlayerAttributes.MELEE_CRIT_DAMAGE))) + "%"));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.melee.alt1") + text.format(100D * par1.get(par0, PlayerAttributes.MELEE_CRIT_CHANCE)) + "%"));
		
		ClientReg.getTooltips(PlayerAttributes.MELEE_DAMAGE.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent ranged = new DynamicTextComponent(130, 98, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.ranged", text.format(par1.get(par0, PlayerAttributes.RANGED_DAMAGE)));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.ranged.alt0") + text.format(100D + (100D * par1.get(par0, PlayerAttributes.RANGED_CRIT_DAMAGE))) + "%"));
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.ranged.alt1") + text.format(100D * par1.get(par0, PlayerAttributes.RANGED_CRIT_CHANCE)) + "%"));
		
		ClientReg.getTooltips(PlayerAttributes.RANGED_DAMAGE.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent evasion = new DynamicTextComponent(130, 110, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.evasion", text.format(100D * par1.get(par0, PlayerAttributes.EVASION)), "%");
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.evasion.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.EVASION.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent lifesteal = new DynamicTextComponent(130, 122, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.lifesteal", text.format(100D * par1.get(par0, PlayerAttributes.LIFESTEAL)), "%");
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.lifesteal.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.LIFESTEAL.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent luck = new DynamicTextComponent(130, 134, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.luck", text.format(par1.get(par0, PlayerAttributes.LUCK)));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.luck.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.LUCK.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent gravity = new DynamicTextComponent(130, 146, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.gravity", text.format(par1.get(par0, PlayerAttributes.GRAVITY)));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.gravity.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.GRAVITY.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent reach = new DynamicTextComponent(130, 158, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.reach_distance", text.format(par1.get(par0, PlayerAttributes.REACH_DISTANCE)));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.reach_distance.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.REACH_DISTANCE.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent movement = new DynamicTextComponent(130, 170, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.movement_speed", text.format(20D * par1.get(par0, PlayerAttributes.MOVEMENT_SPEED)));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.movement_speed.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.MOVEMENT_SPEED.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	private final DynamicTextComponent swim = new DynamicTextComponent(130, 182, (par0, par1) -> {
		TranslatableComponent var0 = new TranslatableComponent(NarutoMod.MODID + ".attribute.swim_speed", text.format(par1.get(par0, PlayerAttributes.SWIM_SPEED)));
		
		return var0.getString();
	}, (par0, par1) -> {
		List<Component> var0 = new ArrayList<Component>();
		
		var0.add(new TextComponent(ChatFormatting.GRAY + I18n.get(NarutoMod.MODID + ".attribute.swim_speed.alt")));
		
		ClientReg.getTooltips(PlayerAttributes.SWIM_SPEED.registryName()).forEach(var -> var0.add(new TextComponent(var.apply(par0, par1))));
		
		return var0;
	});
	
	public DefaultPage() {
		super(new TranslatableComponent(NarutoMod.MODID + ".page.player_attributes"));
		
		this.dynamicTextComponents.add(this.level);
		this.dynamicTextComponents.add(this.skillPoints);
		this.dynamicTextComponents.add(this.constitution);
		this.dynamicTextComponents.add(this.strength);
		this.dynamicTextComponents.add(this.dexterity);
		this.dynamicTextComponents.add(this.intelligence);
		this.dynamicTextComponents.add(this.luckiness);
		this.dynamicTextComponents.add(this.health);
		this.dynamicTextComponents.add(this.armor);
		this.dynamicTextComponents.add(this.attackSpeed);
		this.dynamicTextComponents.add(this.melee);
		this.dynamicTextComponents.add(this.ranged);
		this.dynamicTextComponents.add(this.evasion);
		this.dynamicTextComponents.add(this.lifesteal);
		this.dynamicTextComponents.add(this.luck);
		this.dynamicTextComponents.add(this.gravity);
		this.dynamicTextComponents.add(this.reach);
		this.dynamicTextComponents.add(this.movement);
		this.dynamicTextComponents.add(this.swim);
	}
	
	@Override
	public ItemStack displayStack() {
		return new ItemStack(Items.PLAYER_HEAD);
	}
	
	@Override
	public void render(PoseStack par0, int par1, int par2, float par3) {
		super.render(par0, par1, par2, par3);
		
		this.dynamicTextComponents.forEach(var -> var.drawAlt(par0, this.font, this.minecraft.player, this.width, this.height, par1, par2));
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(PoseStack par0, int par1, int par2) {
		this.font.draw(par0, this.title.getString(), 9F, 9F, 4210752);
		this.dynamicTextComponents.forEach(var -> var.draw(par0, this.font, this.minecraft.player));
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(PoseStack par0, float par1, int par2, int par3) {
		Player var0 = this.minecraft.player;
		
		RevivalAPI.playerAttributes(var0).ifPresent(var -> {
			for(AbstractWidget var1 : this.getButtonList()) {
				if(var1 instanceof TexturedButton) {
					TexturedButton var2 = (TexturedButton)var1;
					int var3 = var2.getAdditionalData();
					
					if(var3 >= 0 && var3 < this.idToAttribute.length) {
						float var4 = (float)var.get(var0, PlayerAttributes.SKILLPOINTS);
						
						var1.active = var4 > 0F;
					}
				}
			}
		});
	}
	
	@Override
	protected void init(AbstractContainerScreen<?> par0) {
		super.init(par0);
		
		for(int var = 0; var < this.idToAttribute.length; var++) {
			this.addRenderableWidget(new TexturedButton(par0, 8, 58 + (17 * var), 11, 10, 204, 0, var, (var0, var1) -> {
				Registry.NETWORK.sendToServer(new AddPlayerAttributes(Pair.of(this.idToAttribute[var1], 1.0F), Pair.of(PlayerAttributes.SKILLPOINTS, -1.0F)));
			}));
		}
	}
}
