package com.godhenko.narutorevival.custom.customitems;

import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.Random;

public class ChakraPaperItem extends Item {
    public ChakraPaperItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide()) {
            ItemStack itemstack = player.getItemInHand(hand);
            Random rand = new Random();
            player.getCooldowns().addCooldown(this, 10);
            ItemStack _setstack;
            //clans
            int uchiha = 0;
            int hyuga = 1;
            int uzumaki = 2;
            int aburame = 3;
            int akimichi = 4;
            int hatake = 5;
            int hozuki = 6;
            int iburi = 7;
            int inuzuka = 8;
            int jugo = 9;
            int kaguya = 10;
            int kurama = 11;
            int tsuchigumo = 12;
            int nara = 13;
            int sarutobi = 14;
            int fuma = 15;
            int senju = 16;
            int yuki = 17;
            int yamanaka = 18;
            int lee = 19;
            int chinoike = 20;
            int shirogane = 21;

            //Afil
             //double village = 0;
             int konohagakure = 0;
             int sunagakure = 1;
             int kumogakure = 2;
             int iwagakure = 3;
             int akatsuki = 4;
             int amegakure = 5;
             int getsugakure = 6;
             int hoshigakure = 7;
             int ishigakure = 8;
             int jomae = 9;
             int kirigakure = 10;
             int kusagakure = 11;
             int nadeshiko = 12;
             int otagakure = 13;
             int ryuchi_cave = 14;
             int shimogakure = 15;
             int takigaure = 16;
             int takumi = 17;
             int tanigakure = 18;
             int mount_myoboku = 19;
             int yugagakure = 20;
             int yukigakure = 21;
             int yumegakure = 22;
             int shikotsu = 23;

             //natures
            int fire = 0;
            int wind = 1;
            int earth = 2;
            int lightning = 3;
            int water = 4;
            //Dual Fires
            int fireAndWind = 0;
            int fireAndEarth = 0;
            int fireAndLightning = 0;
            int fireAndWater = 0;
            //Dual Winds
            int windAndEarth = 0;
            int windAndLightning = 0;
            int windAndWater = 0;
            //dual Earth
            int earthAndLighting = 0;
            int earthAndWater = 0;
            //dual water
            int waterAndLightning = 0;




            //Land
            int land_of_earth = 0;
            int land_of_fire = 1;
            int land_of_iron = 2;
            int land_of_lightning = 3;
            int land_of_sky = 4;
            int land_of_snow = 5;
            int land_of_sound = 6;
            int land_of_water = 7;
            int land_of_wind = 8;

            int clan = rand.nextInt(0,21);
            int affiliation = rand.nextInt(0,23);
            int nature = rand.nextInt(150);
            int land = rand.nextInt(0,8);

            double ogrank = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoRevivalModVariables.PlayerVariables())).rank = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new NarutoRevivalModVariables.PlayerVariables())).rank = 1);
            {
                player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.rank = ogrank;
                    capability.syncPlayerVariables(player);
                });
            }

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
                    double clan2 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) = 2;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan2;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Hyuga Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.HYUGA.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (clan == uzumaki) {
                    double clan3 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =3;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan3;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Uzumaki Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.UZUMAKI.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == aburame) {
                    double clan4 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =4;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan4;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Aburame Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.ABURAME.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == akimichi) {
                    double clan5 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =5;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan5;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Akimichi Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.AKIMICHI.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == hatake) {
                    double clan6 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =6;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan6;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Hatake Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.HATAKE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == hozuki) {
                    double clan7= ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =7;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan7;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Hozuki Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.HOZUKI.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == iburi) {
                    double clan8 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =8;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan8;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Iburi Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.IBURI.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == inuzuka) {
                    double clan9 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =9;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan9;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Inuzuka Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.INUZUKA.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == jugo) {
                    double clan10 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =10;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan10;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Jugo Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.JUGO.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (clan == kaguya) {
                    double clan11 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =11;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan11;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Kaguya Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.KAGUYA.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == kurama) {
                    double clan12 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =12;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan12;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Kurama Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.KURAMA.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == tsuchigumo) {
                    double clan13 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =13;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan13;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Tsuchigumo Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.TSUCHIGUMO.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == nara) {
                    double clan14 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =14;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan14;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Nara Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.NARA.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == sarutobi) {
                    double clan15 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =15;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan15;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Sarutobi Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.SARUTOBI.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == fuma) {
                    double clan16 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =16;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan16;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Fuma Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.FUMA.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == senju) {
                    double clan17 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =17;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan17;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Senju Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.SENJU.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == yuki) {
                    double clan18 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =18;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan18;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Yuki Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.YUKI.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == yamanaka) {
                    double clan19 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =19;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan19;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Yamanaka Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.YAMANAKA.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == lee) {
                    double clan20 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =20;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan20;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Lee Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.LEE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == chinoike) {
                    double clan21 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =21;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan21;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Chinioke Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.CHINIOKE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                } else if (clan == shirogane) {
                    double clan22 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).clan) =22;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.clan = clan22;
                        capability.syncPlayerVariables(player);
                    });
                    player.sendMessage(new TranslatableComponent("You are now part of the Shirogane Clan"), player.getUUID());
                    _setstack = new ItemStack(ItemInit.SHIROGANE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);

                }

                if (affiliation == konohagakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });

                } else if (affiliation == sunagakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =2;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == kumogakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =3;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == iwagakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =4;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == amegakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =6;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == getsugakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =7;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == hoshigakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =8;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == ishigakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =9;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == jomae) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =10;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == kirigakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =11;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == kusagakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =12;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == nadeshiko) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =13;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == otagakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =14;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == shimogakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =16;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == takigaure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =17;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == takumi) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =18;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == tanigakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =19;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == yugagakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =21;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == yukigakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =22;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == yumegakure) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =23;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                } else if (affiliation == shikotsu) {
                    double village = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).village) =24;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.village = village;
                        capability.syncPlayerVariables(player);
                    });
                }

                if (nature < 20) {
                    double fire1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).fire) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.fire = fire1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_FIRE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 40) {
                    double earth1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).earth) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.earth = earth1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_EARTH.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 60) {
                    double wind1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).wind) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.wind = wind1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WIND.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 80) {
                    double lightning1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).lightning) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.fire = lightning1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_LIGHTNING.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 100) {
                    double water1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).water) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.fire = water1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WATER.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 105) {
                    double fire1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).fire) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.fire = fire1;
                        capability.syncPlayerVariables(player);
                    });
                    double wind1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).wind) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.wind = wind1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WIND.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_FIRE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 110) {
                    double fire1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).fire) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.fire = fire1;
                        capability.syncPlayerVariables(player);
                    });
                    double earth1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).earth) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.earth = earth1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_EARTH.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_FIRE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 115) {
                    double fire1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).fire) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.fire = fire1;
                        capability.syncPlayerVariables(player);
                    });
                    double lightning1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).lightning) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.lightning = lightning1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_LIGHTNING.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_FIRE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 120) {
                    double fire1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).fire) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.fire = fire1;
                        capability.syncPlayerVariables(player);
                    });
                    double water1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).water) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.water = water1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WATER.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_FIRE.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 125) {
                    double earth1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).earth) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.earth = earth1;
                        capability.syncPlayerVariables(player);
                    });
                    double wind1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).wind) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.wind = wind1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WIND.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_EARTH.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 130) {
                    double lightning1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).lightning) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.lightning = lightning1;
                        capability.syncPlayerVariables(player);
                    });
                    double wind1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).wind) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.wind = wind1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WIND.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_LIGHTNING.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 135) {
                    double water1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).water) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.water = water1;
                        capability.syncPlayerVariables(player);
                    });
                    double wind1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).wind) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.wind = wind1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WIND.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WATER.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 140) {
                    double earth1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).earth) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.earth = earth1;
                        capability.syncPlayerVariables(player);
                    });
                    double lightning1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).lightning) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.lightning = lightning1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_EARTH.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_LIGHTNING.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 145) {
                    double earth1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).earth) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.earth = earth1;
                        capability.syncPlayerVariables(player);
                    });
                    double water1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).water) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.water = water1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_EARTH.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WATER.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                } else if (nature < 150) {
                    double water1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).water) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.water = water1;
                        capability.syncPlayerVariables(player);
                    });
                    double lightning1 = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).lightning) =1;
                    player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.lightning = lightning1;
                        capability.syncPlayerVariables(player);
                    });
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_WATER.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    _setstack = new ItemStack(ModRegistry.SKILL_LEARNER_LIGHTNING.get());
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                }
                if (land == land_of_earth) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_earth);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                } else if (land == land_of_fire) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_fire);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                } else if (land == land_of_iron) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_iron);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                } else if (land == land_of_lightning) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_lightning);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                } else if (land == land_of_sky) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_sky);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                } else if (land == land_of_snow) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_snow);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                } else if (land == land_of_sound) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_sound);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                } else if (land == land_of_water) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_water);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                } else if (land == land_of_wind) {
                    double landof = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land = ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new NarutoRevivalModVariables.PlayerVariables())).land_of_wind);
                    {
                        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.land = landof;
                            capability.syncPlayerVariables(player);
                        });
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
            }

            return super.use(world, player, hand);
        }

}
