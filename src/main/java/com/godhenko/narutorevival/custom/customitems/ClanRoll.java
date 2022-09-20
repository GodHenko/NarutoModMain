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
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 1;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Uchiha Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.UCHIHA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            } else if (clan == hyuga) {
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 2;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Hyuga Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.HYUGA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            } else if (clan == uzumaki){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 3;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Uzumaki Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.UZUMAKI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == aburame){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 4;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Aburame Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.ABURAME.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == akimichi){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 5;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Akimichi Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.AKIMICHI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == hatake){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 6;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Hatake Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.HATAKE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == hozuki){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 7;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Hozuki Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.HOZUKI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == iburi){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 8;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Iburi Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.IBURI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == inuzuka){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 9;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Inuzuka Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.INUZUKA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == jugo){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 10;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Jugo Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.JUGO.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            }
            else if (clan == kaguya){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 11;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Kaguya Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.KAGUYA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == kurama){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 12;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Kurama Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.KURAMA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == tsuchigumo){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 13;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Tsuchigumo Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.TSUCHIGUMO.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == nara){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 14;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Nara Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.NARA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == sarutobi){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 15;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Sarutobi Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.SARUTOBI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == fuma){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 16;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Fuma Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.FUMA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == senju){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 17;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Senju Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.SENJU.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == yuki){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 18;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Yuki Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.YUKI.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == yamanaka){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 19;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Yamanaka Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.YAMANAKA.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == lee){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 20;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Lee Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.LEE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else if (clan == chinoike){
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 21;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
                player.sendMessage(new TranslatableComponent("You are now part of the Chinioke Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.CHINIOKE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }
            else {
                double clan1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 22;
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.clan = clan1;
                    capability.syncPlayerVariables(player);
                });
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

