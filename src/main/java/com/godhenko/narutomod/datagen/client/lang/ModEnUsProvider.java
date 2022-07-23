package com.godhenko.narutomod.datagen.client.lang;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.inits.BlockInit;
import com.godhenko.narutomod.inits.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {

	public ModEnUsProvider(DataGenerator gen) {
		super(gen, NarutoMod.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		//Keybindings Categories//
		add( "key.narutomod.category","Naruto Revival");
		//Keybindings//
		add("key.narutomod.open_stats_menu", "Player Card");

		// Item Groups
		add("itemGroup.food", "Food Tab");
		add("itemGroup.blocks", "Blocks Tab");
		add("itemGroup.misc", "Misc Tab");
		
		// Items
		add(ItemInit.RAMEN.get(), "Ramen");
		
		// Blocks
		add(BlockInit.UCHIHA_CLOTH.get(), "Example Block");

	}

}
