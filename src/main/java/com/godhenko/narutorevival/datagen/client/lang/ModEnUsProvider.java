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
		add(ItemInit.RAMEN_TRADER_SPAWN_EGG.get(),"Ramen Trader Spawn Egg");add(ItemInit.CLAN_ROLL.get(),"Clan Roll");
		add(ItemInit.GENIN_HELMET.get(),"Genin Headband");
		add(ItemInit.GENIN_CHESTPLATE.get(),"Genin Chestplate");
		add(ItemInit.GENIN_LEGGINGS.get(),"Genin Leggings");
		add(ItemInit.GENIN_BOOTS.get(),"Genin Boots");add(ItemInit.KATANA.get(),"Iron Katana");
		add(ItemInit.CHAKRA_PAPER.get(),"Chakra Paper");
		add(ItemInit.GUNBAI.get(),"Gunbai");
		add(ItemInit.MADARA_GUNBAI.get(),"Madara Gunbai");
		//Learners
		add(ModRegistry.SKILL_LEARNER_FIRE.get(),"Fire Release Learner");
		add(ModRegistry.SKILL_LEARNER_WATER.get(),"Water Release Learner");
		add(ModRegistry.SKILL_LEARNER_WIND.get(),"Wind Release Learner");
		add(ModRegistry.SKILL_LEARNER_LIGHTNING.get(),"Lightning Release Learner");
		add(ModRegistry.SKILL_LEARNER_EARTH.get(),"Earth Release Learner");


		//Jutsus
		//Earth
		add(ModRegistry.EARTH_ARMOR_JUTSU.get(),"Earth Armor");
		add(ModRegistry.EARTH_WALL_JUTSU.get(),"Earth Wall");
		add(ModRegistry.SAND_TRAP_JUTSU.get(),"Sand Trap");
		//Fire
		add(ModRegistry.FIRE_BALL_JUTSU.get(),"Fire Ball");
		add(ModRegistry.FIRE_STAGES_JUTSU.get(),"Stages Of Fire");
		add(ModRegistry.RUNNING_FIRE_JUTSU.get(),"Running Fire");
		//Lightning
		add(ModRegistry.LARIAT_JUTSU.get(),"Lariat");
		add(ModRegistry.LIGHTNING_BALL_JUTSU.get(),"Lightning Ball");
		add(ModRegistry.STATIC_FORCE_JUTSU.get(),"Static Force");
		//Water
		add(ModRegistry.WATER_SHARK_JUTSU.get(),"Water Shark");
		add(ModRegistry.WATER_NEEDLES_JUTSU.get(),"Water Needles");
		add(ModRegistry.WATER_WALL_JUTSU.get(),"Water Wall");
		//Wind
		add(ModRegistry.GALE_BURST_JUTSU.get(),"Gale Burst");
		add(ModRegistry.RASENSHURIKEN_JUTSU.get(),"Rasenshuriken");
		add(ModRegistry.WIND_MODE_JUTSU.get(),"Wind Mode");

		//Jutsu Desc
		//Earth
		add("item.narutorevival.earth_wall_jutsu.desc","Creates an earth wall in the direction you're looking at.");
		add("item.narutorevival.sand_trap_jutsu.desc","Traps and damages the entity you're looking at.");
		//Fire
		add("item.narutorevival.fire_ball_jutsu.desc","Shoots a fireball causing an explosion on impact.");
		add("item.narutorevival.running_fire_jutsu.desc","Spawns a fire around you, burning nearby enemies.");
		//Lightning
		add("item.narutorevival.lightning_ball_jutsu.desc","Shoots out a ball lightning that stuns and damages your enemies.");
		add("item.narutorevival.static_force_jutsu.desc","Stuns nearby enemies.");
		//Water
		add("item.narutorevival.shark_bullet_jutsu.desc","Shoots out a shark that will eat through your enemies.");
		add("item.narutorevival.water_wall_jutsu.desc","Spawns a waterfall in the direction you're looking to.");
		//Wind
		add("item.narutorevival.gale_strike_jutsu.desc","Shoots out an air burst, pushing away your enemies.");
		add("item.narutorevival.wind_force_jutsu.desc","Gives you speed, jump boost, and resistance.");
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
		add("other.narutorevival.damage", "Damage: ");
		add("other.narutorevival.uses", "Uses: ");
		add("other.narutorevival.chakra", "Chakra: ");
		add("other.narutorevival.nextjutsu", "Next Jutsu: ");
		//Entities
		add(ModRegistry.AIR_BURST_PROJECTILE.get(),"Air Burst");
		add(ModRegistry.EARTH_TRAP_PROJECTILE.get(),"Sand Trap");
		add(ModRegistry.FIREBALL_PROJECTILE.get(),"Fire Ball");
		add(ModRegistry.LIGHTNING_BALL_PROJECTILE.get(),"Lightning Ball");
		add(ModRegistry.SHARK_PROJECTILE.get(),"Shark");
		add(ModRegistry.ICE_NEEDLES_PROJECTILE.get(),"Ice Needles");
		add(ModRegistry.OVERLOAD_PROJECTILE.get(),"OVERLOAD");

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
		add("other.narutorevival.stage","stage");
		add("other.Narutorevival.chakra","Chakra:");
		add("other.narutorevival.lvl","Lvl:");
		add("other.narutorevival.xp","XP:");

		add("jutsu.narutorevival.level.0","Genin");
		add("jutsu.narutorevival.level.1","Chunin");
		add("jutsu.narutorevival.level.2","Jonin");
		add("jutsu.narutorevival.level.3","Anbu");
		add("jutsu.narutorevival.level.4","Kage");


	}

}
