package com.godhenko.narutomod.datagen;


import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.datagen.client.ModBlockStateProvider;
import com.godhenko.narutomod.datagen.client.ModItemModelProvider;
import com.godhenko.narutomod.datagen.client.lang.ModEnUsProvider;
import com.godhenko.narutomod.datagen.server.ModBlockTagsProvider;
import com.godhenko.narutomod.datagen.server.ModItemTagsProvider;
import com.godhenko.narutomod.datagen.server.ModLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = NarutoMod.MOD_ID, bus = Bus.MOD)
public class TutorialDataGeneration {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if (event.includeClient()) {
			
			// Client Data Generation
			generator.addProvider(new ModBlockStateProvider(generator, helper));
			generator.addProvider(new ModItemModelProvider(generator, helper));
			generator.addProvider(new ModEnUsProvider(generator));
		}
		
		if (event.includeServer()) {
			
			ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, helper);
			
			// Server Data Generation
			generator.addProvider(blockTags);
			generator.addProvider(new ModItemTagsProvider(generator, blockTags, helper));
			generator.addProvider(new ModLootTableProvider(generator));
			
		}
	}
}
