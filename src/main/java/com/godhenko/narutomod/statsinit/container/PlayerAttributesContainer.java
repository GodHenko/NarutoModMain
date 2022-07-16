package com.godhenko.narutomod.statsinit.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class PlayerAttributesContainer extends AbstractContainerMenu {
    public PlayerAttributesContainer(final int par0, final Inventory par1) {
        super(Registry.ATTRIBUTES_CONTAINER, par0);
    }

    @Override
    public boolean stillValid(final Player par0) {
        return true;
    }
}