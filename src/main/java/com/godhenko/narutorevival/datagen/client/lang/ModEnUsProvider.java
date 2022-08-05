package com.godhenko.narutorevival.datagen.client.lang;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.godhenko.narutorevival.inits.BlockInit;
import com.godhenko.narutorevival.inits.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {

	public ModEnUsProvider(DataGenerator gen) {
		super(gen, NarutoRevival.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		//Keybindings Categories//
		add( "key.narutorevival.category","Naruto Revival");
		//Keybindings//
		add("key.narutorevival.open_stats_menu", "Player Card");
		add("key.gatherChakra", "Charge Chakra");

		// Item Groups
		add("itemGroup.food", "Food Tab");
		add("itemGroup.blocks", "Blocks Tab");
		add("itemGroup.armor", "Armor Tab");
		add("itemGroup.misc", "Misc Tab");
		
		// Items
		add(ItemInit.RAMEN.get(), "Ramen");
		add(ItemInit.BRONZE_RYO.get(),"Bronze Ryo");
		add(ItemInit.SILVER_RYO.get(),"Silver Ryo");
		add(ItemInit.GOLD_RYO.get(),"Gold Ryo");
		add(ItemInit.GENIN_SPAWN_EGG.get(),"Genin Spawn Egg");
		add(ItemInit.CHUNIN_SPAWN_EGG.get(),"Chunin Spawn Egg");
		add(ItemInit.JONIN_SPAWN_EGG.get(),"Jonin Spawn Egg");
		add(ItemInit.RAMEN_TRADER_SPAWN_EGG.get(),"Ramen Trader Spawn Egg");
		add(ItemInit.SCROLL.get(),"Scroll");
		add(ItemInit.CLAN_ROLL.get(),"Clan Roll");
		add(ItemInit.GENIN_HELMET.get(),"Genin Headband");
		add(ItemInit.GENIN_CHESTPLATE.get(),"Genin Chestplate");
		add(ItemInit.GENIN_LEGGINGS.get(),"Genin Leggings");
		add(ItemInit.GENIN_BOOTS.get(),"Genin Boots");
		add(ItemInit.XP_10000.get(),"10,000 XP Scroll");
		add(ItemInit.KATANA.get(),"Iron Katana");

		//Clans
		add(ItemInit.UCHIHA.get(),"Uchiha Clan Learner");
		add(ItemInit.HYUGA.get(),"Hyuga Clan Learner");
		add(ItemInit.UZUMAKI.get(),"Uzumaki Clan Learner");
		add(ItemInit.ABURAME.get(),"Aburame Clan Learner");
		add(ItemInit.AKIMICHI.get(),"Akimichi Clan Learner");
		add(ItemInit.HATAKE.get(),"Hatake Clan Learner");
		add(ItemInit.HOZUKI.get(),"Hozuki Clan Learner");
		add(ItemInit.IBURI.get(),"Iburi Clan Learner");
		add(ItemInit.INUZUKA.get(),"Inuzuka Clan Learner");
		add(ItemInit.JUGO.get(),"Jugo Clan Learner");
		add(ItemInit.KAGUYA.get(),"Kaguya Clan Learner");
		add(ItemInit.KURAMA.get(),"Kurama Clan Learner");
		add(ItemInit.TSUCHIGUMO.get(),"Tsuchigumo Clan Learner");
		add(ItemInit.NARA.get(),"Nara Clan Learner");
		add(ItemInit.SARUTOBI.get(),"Sarutobi Clan Learner");
		add(ItemInit.FUMA.get(),"Fuma Clan Learner");
		add(ItemInit.SENJU.get(),"Senju Clan Learner");
		add(ItemInit.YUKI.get(),"Yuki Clan Learner");
		add(ItemInit.YAMANAKA.get(),"Yamanaka Clan Learner");
		add(ItemInit.LEE.get(),"Lee Clan Learner");
		add(ItemInit.CHINIOKE.get(),"Chinoike Clan Learner");
		add(ItemInit.SHIROGANE.get(),"Shirogane Clan Learner");




		// Blocks
		add(BlockInit.UCHIHA_CLOTH.get(), "Example Block");
		// Entities
		add(ModEntityTypes.GENIN.get(),"Genin");
		add(ModEntityTypes.CHUNIN.get(),"Chunin");
		add(ModEntityTypes.JONIN.get(),"Jonin");

		add(ModEntityTypes.RAMEN_TRADER.get(),"Ramen Trader");
		//POIS
		add("entity.minecraft.villager.narutorevival.ramentrader", "Ramen Trader");
		//Sounds
		add("sounds.narutorevival.ninja_hurt_sfx","Genin Grunt");
		add("sounds.narutorevival.ninja_death_sfx","Genin Died");

		//Translations
		add("You are now part of the Uzumaki Clan","You are now part of the Uzumaki Clan");
		add("You are now part of the Uchiha Clan","You are now part of the Uchiha Clan");
		add("You are now part of the Hyuga Clan","You are now part of the Hyuga Clan");




	}

}
