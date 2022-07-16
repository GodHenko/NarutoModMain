package com.godhenko.narutomod.statsinit.container;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.api.RevivalAPI;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class PlayerAttributesContainerProvider implements MenuProvider {

    @Override
    public AbstractContainerMenu createMenu(int par0, Inventory par1, Player par2) {
        return new PlayerAttributesContainer(par0, par1);
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(NarutoMod.MODID + ".container");
    }
}