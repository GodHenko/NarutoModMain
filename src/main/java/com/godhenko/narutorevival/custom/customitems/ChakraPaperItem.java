package com.godhenko.narutorevival.custom.customitems;

import com.godhenko.narutorevival.inits.ItemInit;
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

            int clan = rand.nextInt(22);
            int affiliation = rand.nextInt(24);
            int nature = rand.nextInt(5);
            int land = rand.nextInt(9);

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
            else if (clan == shirogane){
                NarutoRevivalModVariables.MapVariables.get(world).clan = 22;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
                player.sendMessage(new TranslatableComponent("You are now part of the Shirogane Clan"), player.getUUID());
                _setstack = new ItemStack(ItemInit.SHIROGANE.get());
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, _setstack);

            }

            if (affiliation == konohagakure){
                NarutoRevivalModVariables.MapVariables.get(world).village = 1;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);

            } else if (affiliation == sunagakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 2;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == kumogakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 3;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == iwagakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village =4;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == amegakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 6;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == getsugakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 7;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == hoshigakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 8;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == ishigakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 9;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == jomae) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 10;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == kirigakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 11;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == kusagakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 12;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == nadeshiko) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 13;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == otagakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 14;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == shimogakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village =16;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == takigaure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 17;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == takumi) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 18;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == tanigakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 19;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == yugagakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 21;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == yukigakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 22;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == yumegakure) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 23;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (affiliation == shikotsu) {
                NarutoRevivalModVariables.MapVariables.get(world).village = 24;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }

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
            if (land == land_of_earth){
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_earth;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (land == land_of_fire) {
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_fire;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (land == land_of_iron) {
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_iron;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (land == land_of_lightning) {
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_lightning;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (land == land_of_sky) {
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_sky;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (land == land_of_snow) {
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_snow;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (land == land_of_sound) {
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_sound;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (land == land_of_water) {
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_water;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }
            else if (land == land_of_wind){
                NarutoRevivalModVariables.MapVariables.get(world).land = NarutoRevivalModVariables.MapVariables.get(world).land_of_wind;
                NarutoRevivalModVariables.MapVariables.get(world).syncData(world);
            }

            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }


        }
            return super.use(world, player, hand);
        }

}
