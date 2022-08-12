package com.godhenko.narutorevival.custom.customitems;

import com.godhenko.narutorevival.inits.ItemInit;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class woodensword extends Item {
    public woodensword(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pStack = new ItemStack(Items.WOODEN_SWORD.asItem());
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.mccourse.dowsing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.mccourse.dowsing_rod.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
