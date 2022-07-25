package com.godhenko.narutorevival.datagen;


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.datagen.client.ModBlockStateProvider;
import com.godhenko.narutorevival.datagen.client.ModItemModelProvider;
import com.godhenko.narutorevival.datagen.client.lang.ModEnUsProvider;
import com.godhenko.narutorevival.datagen.server.ModBlockTagsProvider;
import com.godhenko.narutorevival.datagen.server.ModItemTagsProvider;
import com.godhenko.narutorevival.datagen.server.ModLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = NarutoRevival.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
