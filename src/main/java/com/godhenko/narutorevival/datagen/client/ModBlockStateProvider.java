package com.godhenko.narutorevival.datagen.client;


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, NarutoRevival.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(BlockInit.UCHIHA_CLOTH.get());

	}
}
