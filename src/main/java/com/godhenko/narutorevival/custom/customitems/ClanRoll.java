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
            //int clans = 0;
            int uchiha=0;
            int hyuga=1;
            int uzumaki=2;
            int aburame  =3;
            int akimichi  =4;
            int hatake  =5;
            int hozuki  =6;
            int iburi  =7;
            int inuzuka  =8;
            int jugo  =9;
            int kaguya  =10;
            int kurama  =11;
            int tsuchigumo  =12;
            int nara  =13;
            int sarutobi  =14;
            int fuma  =15;
            int senju  =16;
            int yuki  = 17;
            int yamanaka  =18;
            int lee  =19;
            int chinoike  =20;
            int shirogane  =21;

            int clan = rand.nextInt(22);


            if (clan == uchiha) {
                NarutoRevivalModVariables.MapVariables.get(world).clan = 1;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Uchiha Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.UCHIHA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            } else if (clan == hyuga) {
                NarutoRevivalModVariables.MapVariables.get(world).clan = 2;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Hyuga Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.HYUGA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            } else if (clan == uzumaki){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 3;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Uzumaki Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.UZUMAKI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == aburame){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 4;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Aburame Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.ABURAME.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == akimichi){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 5;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Akimichi Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.AKIMICHI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == hatake){
                NarutoRevivalModVariables.MapVariables.get(world).clan =6;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Hatake Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.HATAKE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == hozuki){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 7;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Hozuki Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.HOZUKI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == iburi){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 8;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Iburi Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.IBURI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == inuzuka){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 9;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Inuzuka Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.INUZUKA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == jugo){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 10;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Jugo Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.JUGO.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            }
            else if (clan == kaguya){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 11;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Kaguya Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.KAGUYA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == kurama){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 12;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Kurama Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.KURAMA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == tsuchigumo){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 13;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Tsuchigumo Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.TSUCHIGUMO.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == nara){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 14;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Nara Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.NARA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == sarutobi){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 15;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Sarutobi Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.SARUTOBI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == fuma){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 16;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Fuma Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.FUMA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == senju){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 17;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Senju Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.SENJU.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == yuki){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 18;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Yuki Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.YUKI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == yamanaka){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 19;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Yamanaka Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.YAMANAKA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == lee){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 20;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Lee Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.LEE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == chinoike){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 21;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Chinioke Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.CHINIOKE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else {
                NarutoRevivalModVariables.MapVariables.get(world).clan = 22;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Shirogane Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.SHIROGANE.get());
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

