package com.godhenko.narutorevival.datagen.server;



import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, NarutoRevival.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(BlockInit.UCHIHA_CLOTH.get());


	}

}
