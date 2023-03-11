package com.godhenko.narutorevival.custom.customitems.jutsuitems;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuItem;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JutsuCooldownItem extends JutsuItem {
    private final int cooldownTime;

    public JutsuCooldownItem(Jutsu jutsu, int cooldownTime) {
        super(jutsu);
        this.cooldownTime = cooldownTime;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> result = super.use(world, player, hand);

        if (result.getResult().consumesAction()) {
            player.getCooldowns().addCooldown(this, cooldownTime*20);
        }

        return result;
    }
}
