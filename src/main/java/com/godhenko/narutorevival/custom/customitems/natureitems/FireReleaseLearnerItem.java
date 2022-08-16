package com.godhenko.narutorevival.custom.customitems.natureitems;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FireReleaseLearnerItem extends Item {


    public FireReleaseLearnerItem(Properties pProperties) {
        super(pProperties);
    }

    int learner = 0;
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
            ItemStack itemstack = player.getItemInHand(hand);
        itemstack.setDamageValue(itemstack.getDamageValue());
        if (!world.isClientSide()) {
            ItemStack _setstack;
            if (learner == 0) {
                if (NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints > 10) {
                    learner = 1;
                    itemstack.setDamageValue(itemstack.getDamageValue() - 1);
                    NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                    NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints = NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints - 10;
                    NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                    _setstack = new ItemStack(ItemInit.RAMEN.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                }
            } else {
                if (learner == 1) {
                    if (NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints > 20) {
                        itemstack.setDamageValue(itemstack.getDamageValue() - 2);
                        NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints = NarutoRevivalModVariables.MapVariables.get(world).jutsuPoints - 20;
                        NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                        _setstack = new ItemStack(ItemInit.RANDOM_NATURE.get());
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    }
                }
            }
        }

        return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level world, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (learner == 0){
            pTooltipComponents.add(new TextComponent("Fireball Jutsu:10 SkillPoints"));
        }
        if (learner == 1){
            pTooltipComponents.add(new TextComponent("placeholder"));

        }


        super.appendHoverText(pStack, world, pTooltipComponents, pIsAdvanced);
    }
}
