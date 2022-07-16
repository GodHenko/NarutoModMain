package com.godhenko.narutomod.datagen.server;



import com.godhenko.narutomod.datagen.BaseLootTableProvider;
import com.godhenko.narutomod.inits.BlockInit;
import com.godhenko.narutomod.inits.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModLootTableProvider extends BaseLootTableProvider {

	public ModLootTableProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void addTables() {
		dropSelf(BlockInit.UCHIHA_CLOTH.get());

	}

	protected void silkTouch(Block block, Item silk, int min, int max) {
		add(block, createSilkTouchTable(block.getRegistryName().getPath(), block, silk, min, max));
	}

	protected void dropSelf(Block block) {
		add(block, createSimpleTable(block.getRegistryName().getPath(), block));
	}
}
