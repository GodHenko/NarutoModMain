package com.godhenko.narutorevival.custom.customitems.jutsuitems;

import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FireThreeBookItem extends JutsuItem {
    public FireThreeBookItem(Jutsu jutsu) {
        super(jutsu);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, LevelReader level, BlockPos pos, Player player) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        if (world != null && world.isClientSide()) {
            Player player = Minecraft.getInstance().player;
            if (player == null) return;

            String level = switch ((int) Math.floor(player.experienceLevel / 10f)) {
                case 0 -> ".level_none";
                case 1 -> ".level_i";
                case 2 -> ".level_ii";
                case 3 -> ".level_iii";
                default -> ".level_iv";
            };

            tooltip.add(new TranslatableComponent("other.narutorevival.stage")
                    .append(new TranslatableComponent(this.getDescriptionId() + level))
                    .setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA)));
        }

        super.appendHoverText(stack, world, tooltip, context);
    }
}
