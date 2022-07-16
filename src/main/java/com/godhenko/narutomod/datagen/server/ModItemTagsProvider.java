package com.godhenko.narutomod.datagen.server;



import com.godhenko.narutomod.NarutoMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
		super(generator, blocks, NarutoMod.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {

	}

}
