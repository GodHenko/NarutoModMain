package com.godhenko.narutorevival.datagen.client.lang;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.godhenko.narutorevival.inits.BlockInit;
import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.inits.ModRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {

	public ModEnUsProvider(DataGenerator gen) {
		super(gen, NarutoRevival.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		//Keybindings Categories//
		add( "key.narutorevival.category","Naruto Revival");
		//Keybindings//
		add("key.narutorevival.open_stats_menu", "Player Card");
		add("key.narutorevival.charge_chakra", "Charge Chakra");
		add("key.narutorevival.chakra_control_key","Chakra Control");

		// Item Groups
		add("itemGroup.food", "Food Tab");
		add("itemGroup.blocks", "Blocks Tab");
		add("itemGroup.armor", "Armor Tab");
		add("itemGroup.misc", "Misc Tab");
		
		// Items
		add(ItemInit.RAMEN.get(), "Ramen");
		add(ItemInit.BRONZE_RYO.get(),"Bronze Ryo");
		add(ItemInit.SILVER_RYO.get(),"Silver Ryo");
		add(ItemInit.GOLD_RYO.get(),"Gold Ryo");
		add(ItemInit.GENIN_SPAWN_EGG.get(),"Genin Spawn Egg");
		add(ItemInit.CHUNIN_SPAWN_EGG.get(),"Chunin Spawn Egg");
		add(ItemInit.JONIN_SPAWN_EGG.get(),"Jonin Spawn Egg");
		add(ItemInit.RAMEN_TRADER_SPAWN_EGG.get(),"Ramen Trader Spawn Egg");
		add(ItemInit.SCROLL.get(),"Scroll");
		add(ItemInit.CLAN_ROLL.get(),"Clan Roll");
		add(ItemInit.GENIN_HELMET.get(),"Genin Headband");
		add(ItemInit.GENIN_CHESTPLATE.get(),"Genin Chestplate");
		add(ItemInit.GENIN_LEGGINGS.get(),"Genin Leggings");
		add(ItemInit.GENIN_BOOTS.get(),"Genin Boots");
		add(ItemInit.XP_10000.get(),"10,000 XP Scroll");
		add(ItemInit.KATANA.get(),"Iron Katana");
		add(ItemInit.CHAKRA_PAPER.get(),"Chakra Paper");
		add(ItemInit.RANDOM_NATURE.get(),"Random Nature");
		add(ItemInit.FIRE_RELEASE.get(),"Fire Release");
		add(ItemInit.WATER_RELEASE.get(),"Water Release");
		add(ItemInit.WIND_RELEASE.get(),"Wind Release");
		add(ItemInit.LIGHTNING_RELEASE.get(),"Lightning Release");
		add(ItemInit.EARTH_RELEASE.get(),"Earth Release");
		add(ItemInit.GUNBAI.get(),"Gunbai");

		//Jutsus
		add(ItemInit.JUTSU_FIRE_BALL.get(),"Fire Ball Jutsu");
		add(ItemInit.JUTSU_RUNNING_FIRE.get(),"Running Fire Jutsu");
		add(ItemInit.JUTSU_EARTH_WALL.get(),"Earth Wall Jutsu");
		add(ItemInit.JUTSU_SAND_TRAP.get(),"Sand Trap Jutsu");
		add(ItemInit.JUTSU_WATER_WALL.get(),"Water Wall Jutsu");
		add(ItemInit.JUTSU_SHARK_BULLET.get(),"Shark Bullet Jutsu");
		add(ItemInit.JUTSU_WIND_MODE.get(),"Wind Mode Jutsu");
		add(ItemInit.JUTSU_GALE_STRIKE.get(),"Gale Strike Jutsu");
		add(ItemInit.JUTSU_STATIC_FORCE.get(),"Static Force Jutsu");
		add(ItemInit.JUTSU_LIGHTNING_BALL.get(),"Lighting Ball Jutsu");

		//Jutsu Desc
		add("item.narutorevival.jutsu_fire_ball.desc","Shoots a fireball causing an explosion on impact.");
		//Natures
		add("jutsu.narutorevival.fire","Fire");
		add("jutsu.narutorevival.water","Water");
		add("jutsu.narutorevival.wind","Wind");
		add("jutsu.narutorevival.lightning","Lightning");
		add("jutsu.narutorevival.earth","Earth");
		//Item Text
		add("other.narutorevival.owner", "Owner: ");
		add("other.narutorevival.type", "Type: ");
		add("other.narutorevival.level", "Level: ");
		//Entities
		add(ModRegistry.AIR_BURST_PROJECTILE.get(),"Air Burst");
		add(ModRegistry.EARTH_TRAP_PROJECTILE.get(),"Sand Trap");
		add(ModRegistry.FIREBALL_PROJECTILE.get(),"Fire Ball");
		add(ModRegistry.LIGHTNING_BALL_PROJECTILE.get(),"Lightning Ball");
		add(ModRegistry.SHARK_PROJECTILE.get(),"Shark");
		//Deaths
		add("death.attack.stun_jutsu","%1$s was stunned by %2$s");
		add( "death.attack.shark_jutsu","%1$s got eaten by %2$s's shark");
		add("death.attack.fire_jutsu","%1$s got fried by %2$s");
		add("death.attack.stun_jutsu.item","%1$s was stunned by %2$s");
		add("death.attack.shark_jutsu.item","%1$s got eaten by %2$s's shark");
		add("death.attack.fire_jutsu.item","%1$s got fried by %2$s");
		//Jutsu Calls
		add("jutsu.narutorevival.earth_wall","Earth Wall No Jutsu!");



		//Clans
		add(ItemInit.UCHIHA.get(),"Uchiha Clan Learner");
		add(ItemInit.HYUGA.get(),"Hyuga Clan Learner");
		add(ItemInit.UZUMAKI.get(),"Uzumaki Clan Learner");
		add(ItemInit.ABURAME.get(),"Aburame Clan Learner");
		add(ItemInit.AKIMICHI.get(),"Akimichi Clan Learner");
		add(ItemInit.HATAKE.get(),"Hatake Clan Learner");
		add(ItemInit.HOZUKI.get(),"Hozuki Clan Learner");
		add(ItemInit.IBURI.get(),"Iburi Clan Learner");
		add(ItemInit.INUZUKA.get(),"Inuzuka Clan Learner");
		add(ItemInit.JUGO.get(),"Jugo Clan Learner");
		add(ItemInit.KAGUYA.get(),"Kaguya Clan Learner");
		add(ItemInit.KURAMA.get(),"Kurama Clan Learner");
		add(ItemInit.TSUCHIGUMO.get(),"Tsuchigumo Clan Learner");
		add(ItemInit.NARA.get(),"Nara Clan Learner");
		add(ItemInit.SARUTOBI.get(),"Sarutobi Clan Learner");
		add(ItemInit.FUMA.get(),"Fuma Clan Learner");
		add(ItemInit.SENJU.get(),"Senju Clan Learner");
		add(ItemInit.YUKI.get(),"Yuki Clan Learner");
		add(ItemInit.YAMANAKA.get(),"Yamanaka Clan Learner");
		add(ItemInit.LEE.get(),"Lee Clan Learner");
		add(ItemInit.CHINIOKE.get(),"Chinoike Clan Learner");
		add(ItemInit.SHIROGANE.get(),"Shirogane Clan Learner");




		// Blocks
		add(BlockInit.UCHIHA_CLOTH.get(), "Example Block");
		// Entities
		add(ModEntityTypes.GENIN.get(),"Genin");
		add(ModEntityTypes.CHUNIN.get(),"Chunin");
		add(ModEntityTypes.JONIN.get(),"Jonin");

		add(ModEntityTypes.RAMEN_TRADER.get(),"Ramen Trader");
		//POIS
		add("entity.minecraft.villager.narutorevival.ramentrader", "Ramen Trader");
		//Sounds
		add("sounds.narutorevival.ninja_hurt_sfx","Genin Grunt");
		add("sounds.narutorevival.ninja_death_sfx","Genin Died");

		//Translations
		add("You are now part of the Uzumaki Clan","You are now part of the Uzumaki Clan");
		add("You are now part of the Uchiha Clan","You are now part of the Uchiha Clan");
		add("You are now part of the Hyuga Clan","You are now part of the Hyuga Clan");




	}

}
