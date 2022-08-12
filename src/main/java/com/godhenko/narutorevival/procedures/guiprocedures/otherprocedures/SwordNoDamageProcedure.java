package com.godhenko.narutorevival.procedures.guiprocedures.otherprocedures;

import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;



@Mod.EventBusSubscriber
public class SwordNoDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (NarutoRevivalModVariables.MapVariables.get(world).kenjutsu < 20
					&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WOODEN_SWORD) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
					sourceentity.sendMessage(new TranslatableComponent("Not Enough Kenjutsu"),sourceentity.getUUID());
				}
			} else if (NarutoRevivalModVariables.MapVariables.get(world).kenjutsu < 50
					&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.STONE_SWORD) {
				if (event != null && event.isCancelable()) {
					sourceentity.sendMessage(new TranslatableComponent("Not Enough Kenjutsu"),sourceentity.getUUID());
					event.setCanceled(true);
				}
			} else if (NarutoRevivalModVariables.MapVariables.get(world).kenjutsu < 80
					&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.IRON_SWORD) {
				if (event != null && event.isCancelable()) {
					sourceentity.sendMessage(new TranslatableComponent("Not Enough Kenjutsu"),sourceentity.getUUID());
					event.setCanceled(true);
				}
			} else if (NarutoRevivalModVariables.MapVariables.get(world).kenjutsu < 110
					&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_SWORD) {
				if (event != null && event.isCancelable()) {
					sourceentity.sendMessage(new TranslatableComponent("Not Enough Kenjutsu"),sourceentity.getUUID());
					event.setCanceled(true);
				}
			} else if (NarutoRevivalModVariables.MapVariables.get(world).kenjutsu < 140
					&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_SWORD) {
				if (event != null && event.isCancelable()) {
					sourceentity.sendMessage(new TranslatableComponent("Not Enough Kenjutsu"),sourceentity.getUUID());
					event.setCanceled(true);
				}
			} else if (NarutoRevivalModVariables.MapVariables.get(world).kenjutsu < 170
					&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_SWORD) {
				if (event != null && event.isCancelable()) {
					sourceentity.sendMessage(new TranslatableComponent("Not Enough Kenjutsu"),sourceentity.getUUID());
					event.setCanceled(true);
				}
			} else if (NarutoRevivalModVariables.MapVariables.get(world).kenjutsu < 200
					&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemInit.GUNBAI
							.get()) {
				if (event != null && event.isCancelable()) {
					sourceentity.sendMessage(new TranslatableComponent("Not Enough Kenjutsu"),sourceentity.getUUID());
					event.setCanceled(true);
				}
			}
		}
	}
}
