package com.godhenko.narutomod.datagen.client;


import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.inits.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, NarutoMod.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(BlockInit.UCHIHA_CLOTH.get());
	}
}
