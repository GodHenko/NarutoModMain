package com.godhenko.narutorevival.custom.customitems;

import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
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
import java.util.Random;

public class ClanRoll extends Item {
    public ClanRoll(Properties pProperties) {
        super(pProperties);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Random rand = new Random();
        player.getCooldowns().addCooldown(this,60);
       // onItemUseFirst(itemstack,)

        int uchiha = 0;
        int hyuga = 1;
        int uzumaki = 2;
        int clan = rand.nextInt(2);


        if (clan == uchiha) {
            NarutoRevivalModVariables.MapVariables.get(world).clan = 1;
            NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            player.sendMessage(new TranslatableComponent("You are now part of the Uchiha Clan"),player.getUUID());

        } if (clan == hyuga) {
            NarutoRevivalModVariables.MapVariables.get(world).clan = 2;
            NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            player.sendMessage(new TranslatableComponent("You are now part of the Hyuga Clan"),player.getUUID());

        } else {
            NarutoRevivalModVariables.MapVariables.get(world).clan = 3;
            NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            player.sendMessage(new TranslatableComponent("You are now part of the Uzumaki Clan"),player.getUUID());

        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }



        return super.use(world, player, hand);
    }




    @Override
    public void appendHoverText (ItemStack pStack, @Nullable Level
            pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced){
        pTooltipComponents.add(new TextComponent("Gives you a random clan!"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
