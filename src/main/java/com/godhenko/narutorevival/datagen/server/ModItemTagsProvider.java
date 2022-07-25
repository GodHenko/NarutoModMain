package com.godhenko.narutorevival.datagen.server;



import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
		super(generator, blocks, NarutoRevival.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(ItemInit.ITEMS.createTagKey("ryo"))
				.add(ItemInit.BRONZE_RYO.get())
				.add(ItemInit.SILVER_RYO.get())
				.add(ItemInit.GOLD_RYO.get());
	}


}
