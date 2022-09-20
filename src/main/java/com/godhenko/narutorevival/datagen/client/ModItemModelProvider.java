package com.godhenko.narutorevival.datagen.client;


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.BlockInit;
import com.godhenko.narutorevival.inits.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, NarutoRevival.MOD_ID, helper);
	}

	protected void simpleBlockItem(Item item) {
		getBuilder(item.getRegistryName().toString())
				.parent(getExistingFile(modLoc("block/" + item.getRegistryName().getPath())));
	}

	protected void oneLayerItem(Item item, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated")))
					.texture("layer0", itemTexture);
		} else {
			System.out.println(
					"Texture for " + item.getRegistryName().toString() + " not present at " + itemTexture.toString());
		}
	}

	protected void oneLayerHeldItem(Item item, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/handheld")))
					.texture("layer0", itemTexture);
		} else {
			System.out.println(
					"Texture for " + item.getRegistryName().toString() + " not present at " + itemTexture.toString());
		}
	}
	
	protected void oneLayerItem(Item item) {
		oneLayerItem(item, item.getRegistryName());
	}

	protected void oneLayerHeldItem(Item item) {
		oneLayerItem(item, item.getRegistryName());
	}

	@Override
	protected void registerModels() {
		
		// Block Items
		simpleBlockItem(BlockInit.UCHIHA_CLOTH.get().asItem());

		oneLayerItem(ItemInit.UCHIHA.get());
		oneLayerItem(ItemInit.HYUGA.get());
		oneLayerItem(ItemInit.UZUMAKI.get());
		oneLayerItem(ItemInit.ABURAME.get());
		oneLayerItem(ItemInit.AKIMICHI.get());
		oneLayerItem(ItemInit.HATAKE.get());
		oneLayerItem(ItemInit.HOZUKI.get());
		oneLayerItem(ItemInit.IBURI.get());
		oneLayerItem(ItemInit.INUZUKA.get());
		oneLayerItem(ItemInit.JUGO.get());
		oneLayerItem(ItemInit.KAGUYA.get());
		oneLayerItem(ItemInit.KURAMA.get());
		oneLayerItem(ItemInit.TSUCHIGUMO.get());
		oneLayerItem(ItemInit.NARA.get());
		oneLayerItem(ItemInit.SARUTOBI.get());
		oneLayerItem(ItemInit.FUMA.get());
		oneLayerItem(ItemInit.SENJU.get());
		oneLayerItem(ItemInit.YUKI.get());
		oneLayerItem(ItemInit.YAMANAKA.get());
		oneLayerItem(ItemInit.LEE.get());
		oneLayerItem(ItemInit.CHINIOKE.get());
		oneLayerItem(ItemInit.SHIROGANE.get());

		oneLayerItem(ItemInit.FIRE_RELEASE.get());
		oneLayerItem(ItemInit.WATER_RELEASE.get());
		oneLayerItem(ItemInit.WIND_RELEASE.get());
		oneLayerItem(ItemInit.EARTH_RELEASE.get());
		oneLayerItem(ItemInit.LIGHTNING_RELEASE.get());
		oneLayerItem(ItemInit.CHAKRA_PAPER.get());
		//Jutsu
		oneLayerItem(ItemInit.JUTSU_FIRE_BALL.get());
		oneLayerItem(ItemInit.JUTSU_RUNNING_FIRE.get());
		oneLayerItem(ItemInit.JUTSU_FIRE_BULLET.get());
		oneLayerItem(ItemInit.JUTSU_GREAT_FIREBALL.get());
		oneLayerItem(ItemInit.JUTSU_EARTH_WALL.get());
		oneLayerItem(ItemInit.JUTSU_SAND_TRAP.get());
		oneLayerItem(ItemInit.JUTSU_WATER_WALL.get());
		oneLayerItem(ItemInit.JUTSU_SHARK_BULLET.get());
		oneLayerItem(ItemInit.JUTSU_WIND_MODE.get());
		oneLayerItem(ItemInit.JUTSU_GALE_STRIKE.get());
		oneLayerItem(ItemInit.JUTSU_STATIC_FORCE.get());
		oneLayerItem(ItemInit.JUTSU_LIGHTNING_BALL.get());


		// Simple Items
		oneLayerItem(ItemInit.RAMEN.get());
		oneLayerItem(ItemInit.BRONZE_RYO.get());
		oneLayerItem(ItemInit.SILVER_RYO.get());
		oneLayerItem(ItemInit.GOLD_RYO.get());
		oneLayerItem(ItemInit.CLAN_ROLL.get());
		oneLayerItem(ItemInit.GENIN_HELMET.get());
		oneLayerItem(ItemInit.GENIN_CHESTPLATE.get());
		oneLayerItem(ItemInit.GENIN_LEGGINGS.get());
		oneLayerItem(ItemInit.GENIN_BOOTS.get());


		//layer
		oneLayerHeldItem(ItemInit.KATANA.get());




		withExistingParent(ItemInit.GENIN_SPAWN_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ItemInit.CHUNIN_SPAWN_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ItemInit.JONIN_SPAWN_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));


		withExistingParent(ItemInit.RAMEN_TRADER_SPAWN_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));


	}

}
