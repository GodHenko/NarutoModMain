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

public class ClanRoll extends Item {
    public ClanRoll(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide()) {
            ItemStack itemstack = player.getItemInHand(hand);
            Random rand = new Random();
            player.getCooldowns().addCooldown(this, 60);
            ItemStack _setstack;
            int uchiha=0;
            int hyuga=1;
            int uzumaki=2;
            int aburame  =3;
            int akimichi  =4;
            int hatake  =5;
            int hozuki  =6;
            int iburi  =7;
            int inuzuka  =8;
            int jugo  =10;
            int kaguya  =11;
            int kurama  =12;
            int tsuchigumo  =13;
            int nara  =14;
            int sarutobi  =15;
            int fuma  =16;
            int senju  =17;
            int yuki  = 18;
            int yamanaka  =19;
            int lee  =20;
            int chinoike  =21;
            int shirogane  =22;




            int clan = rand.nextInt(3);


            if (clan == uchiha) {

                NarutoRevivalModVariables.MapVariables.get(world).clan = 1;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Uchiha Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.RAMEN.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            } else if (clan == hyuga) {
                NarutoRevivalModVariables.MapVariables.get(world).clan = 2;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Hyuga Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.NINJA_FABRIC.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            } else if (clan == uzumaki){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 3;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Uzumaki Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.CHUNIN_SPAWN_EGG.get());
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
        pLevel, List < Component > pTooltipComponents, TooltipFlag pIsAdvanced){
            pTooltipComponents.add(new TextComponent("Gives you a random clan!"));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

