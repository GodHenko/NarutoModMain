
package com.godhenko.narutorevival.world.inventory;

import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.screens.gui.BackpackScreen;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;



import javax.annotation.Nullable;
import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class PouchInventoryCapability implements ICapabilitySerializable<CompoundTag> {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntityItem().getItem().getItem() == ItemInit.POUCH.get()) {
			if (Minecraft.getInstance().screen instanceof BackpackScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}

	private final LazyOptional<ItemStackHandler> inventory = LazyOptional.of(this::createItemHandler);

	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? this.inventory.cast() : LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		return getItemHandler().serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		getItemHandler().deserializeNBT(nbt);
	}

	private ItemStackHandler createItemHandler() {
		return new ItemStackHandler(36) {
			@Override
			public int getSlotLimit(int slot) {
				return 64;
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return stack.getItem() != ItemInit.POUCH.get();
			}

			@Override
			public void setSize(int size) {
			}
		};
	}

	private ItemStackHandler getItemHandler() {
		return inventory.orElseThrow(RuntimeException::new);
	}
}
