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
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class RandomNatureItem extends Item {
    public RandomNatureItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide()) {
            ItemStack itemstack = player.getItemInHand(hand);
            Random rand = new Random();
            ItemStack _setstack;
            int fire = 0;
            int wind = 1;
            int earth = 2;
            int lightning = 3;
            int water = 4;


            int nature = rand.nextInt(5);

            if (nature == fire){
                NarutoRevivalModVariables.MapVariables.get(world).fire = 1;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                _setstack = new ItemStack(ItemInit.FIRE_RELEASE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            }
            else if (nature == earth){
                NarutoRevivalModVariables.MapVariables.get(world).earth = 1;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                _setstack = new ItemStack(ItemInit.EARTH_RELEASE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            }
            else if (nature == wind){
                NarutoRevivalModVariables.MapVariables.get(world).wind = 1;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                _setstack = new ItemStack(ItemInit.WIND_RELEASE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            }
            else if (nature == lightning){
                NarutoRevivalModVariables.MapVariables.get(world).lightning = 1;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                _setstack = new ItemStack(ItemInit.LIGHTNING_RELEASE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            }
            else if (nature == water){
                NarutoRevivalModVariables.MapVariables.get(world).water = 1;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                _setstack = new ItemStack(ItemInit.WATER_RELEASE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            }

            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
        }

        return super.use(world, player, hand);
    }


    @Override
    public void appendHoverText (ItemStack pStack, @Nullable Level
            pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced){
        pTooltipComponents.add(new TextComponent("Gives you a random Nature!"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
