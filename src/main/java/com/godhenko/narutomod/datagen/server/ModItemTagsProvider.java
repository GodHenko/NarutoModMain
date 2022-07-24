package com.godhenko.narutomod.datagen.server;



import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.inits.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
		super(generator, blocks, NarutoMod.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(ItemInit.ITEMS.createTagKey("ryo"))
				.add(ItemInit.BRONZE_RYO.get())
				.add(ItemInit.SILVER_RYO.get())
				.add(ItemInit.GOLD_RYO.get());
	}


}
