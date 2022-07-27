package com.godhenko.narutorevival.datagen.client.lang;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.godhenko.narutorevival.inits.BlockInit;
import com.godhenko.narutorevival.inits.ItemInit;
import net.minecraft.data.DataGenerator;
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
		add("itemGroup.misc", "Misc Tab");
		
		// Items
		add(ItemInit.RAMEN.get(), "Ramen");
		add(ItemInit.BRONZE_RYO.get(),"Bronze Ryo");
		add(ItemInit.SILVER_RYO.get(),"Silver Ryo");
		add(ItemInit.GOLD_RYO.get(),"Gold Ryo");
		add(ItemInit.GENIN_SPAWN_EGG.get(),"Genin Spawn Egg");
		add(ItemInit.RAMEN_TRADER_SPAWN_EGG.get(),"Ramen Trader Spawn Egg");

		// Blocks
		add(BlockInit.UCHIHA_CLOTH.get(), "Example Block");
		// Entities
		add(ModEntityTypes.GENIN.get(),"Genin");
		add(ModEntityTypes.RAMEN_TRADER.get(),"Ramen Trader");
		add("entity.minecraft.villager.narutorevival.ramentrader", "Ramen Trader");


	}

}
