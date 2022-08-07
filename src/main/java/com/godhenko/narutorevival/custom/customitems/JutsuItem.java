package com.godhenko.narutorevival.custom.customitems;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class JutsuItem extends Item {
    public JutsuItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public void inventoryTick(ItemStack pStack, Level world, Entity pEntity, int pSlotId, boolean pIsSelected) {

        super.inventoryTick(pStack, world, pEntity, pSlotId, pIsSelected);
    }
}
