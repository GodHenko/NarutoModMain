package com.godhenko.narutorevival.custom.customitems;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class IntelligenceScroll extends Item {
    public IntelligenceScroll(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (NarutoRevivalModVariables.MapVariables.get(world).intelligence > NarutoRevivalModVariables.MapVariables.get(world).maxIntelligence) {
            NarutoRevivalModVariables.MapVariables.get(world).intelligence = NarutoRevivalModVariables.MapVariables.get(world).intelligence + 0;
            NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(0);
            }

        } else if
        (NarutoRevivalModVariables.MapVariables.get(world).intelligence >= 0) {
            NarutoRevivalModVariables.MapVariables.get(world).intelligence = NarutoRevivalModVariables.MapVariables.get(world).intelligence + 5;
            NarutoRevivalModVariables.MapVariables.get(world).syncData(world);

            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            }

            return super.use(world, player, hand);
        }


        @Override
        public void appendHoverText (ItemStack pStack, @Nullable Level
        pLevel, List < Component > pTooltipComponents, TooltipFlag pIsAdvanced){
            pTooltipComponents.add(new TextComponent("Adds 5 Intelligence to your stats!"));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

    }

