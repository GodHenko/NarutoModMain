package com.godhenko.narutomod.datagen.server;



import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.inits.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, NarutoMod.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(BlockInit.UCHIHA_CLOTH.get());

	}

}
