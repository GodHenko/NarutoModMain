package com.godhenko.narutorevival.inits;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.custom.armor.ModArmorMaterials;
import com.godhenko.narutorevival.custom.customitems.*;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuItem;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.custom.customitems.natureitems.FireReleaseLearnerItem;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.EarthOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.EarthTwoJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireBulletJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireTwoJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.GreatFireballJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.LightningOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.LightningTwoJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves.WaterOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves.WaterTwoJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.WindOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.WindTwoJutsu;
import com.godhenko.narutorevival.custom.customitems.weapons.Gunbai;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.google.common.base.Supplier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                NarutoRevival.MOD_ID);

    public static final RegistryObject<Item> RAMEN = register("ramen",
            () -> new Item(new Item.Properties().tab(NarutoRevival.Food_TAB).food(new FoodProperties.Builder().nutrition(50)
                    .saturationMod(10.0f).build())));
    public static final RegistryObject<Item> SPECIAL_RAMEN = register("special_ramen",
            () -> new Item(new Item.Properties().tab(NarutoRevival.Food_TAB).food(new FoodProperties.Builder().nutrition(50)
                    .saturationMod(10.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200), 0.1f).build())));


    public static final RegistryObject<Item> BRONZE_RYO = register("bronze_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> SILVER_RYO = register("silver_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> GOLD_RYO = register("gold_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));


    public static final RegistryObject<Item> UCHIHA = register("uchiha",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> HYUGA = register("hyuga",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> UZUMAKI = register("uzumaki",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ABURAME = register("aburame",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> AKIMICHI = register("akimichi",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> HATAKE = register("hatake",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> HOZUKI = register("hozuki",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> IBURI = register("iburi",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> INUZUKA = register("inuzuka",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> JUGO = register("jugo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> KAGUYA = register("kaguya",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> KURAMA = register("kurama",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> TSUCHIGUMO = register("tsuchigumo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> NARA = register("nara",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> SARUTOBI = register("sarutobi",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> FUMA = register("fuma",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> SENJU = register("senju",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> YUKI = register("yuki",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> YAMANAKA = register("yamanaka",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> LEE = register("lee",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> CHINIOKE = register("chinoike",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    public static final RegistryObject<Item> SHIROGANE = register("shirogane",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB).stacksTo(1)));
    //Natures
    public static final RegistryObject<Item> FIRE_RELEASE = register("fire_release",() -> new FireReleaseLearnerItem(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB).stacksTo(1).durability(50)));
    public static final RegistryObject<Item> WATER_RELEASE = register("water_release",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB).stacksTo(1)));
    public static final RegistryObject<Item> WIND_RELEASE = register("wind_release",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB).stacksTo(1)));
    public static final RegistryObject<Item> EARTH_RELEASE = register("earth_release",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB).stacksTo(1)));
    public static final RegistryObject<Item> LIGHTNING_RELEASE = register("lightning_release",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB).stacksTo(1)));

    public static final RegistryObject<Item> GUNBAI = register("gunbai",() -> new Gunbai());
    public static final RegistryObject<Item> RAMEN_TRADER_SPAWN_EGG = register("ramen_trader_spawn_egg",() -> new
            ForgeSpawnEggItem(ModEntityTypes.RAMEN_TRADER,0xff0000, 0x00ff00, new Item.Properties().tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> GENIN_SPAWN_EGG = register("genin_spawn_egg",() -> new
            ForgeSpawnEggItem(ModEntityTypes.GENIN,0x808080, 0x800000, new Item.Properties().tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> CHUNIN_SPAWN_EGG = register("chunin_spawn_egg",() -> new
            ForgeSpawnEggItem(ModEntityTypes.CHUNIN,0x808080, 0xC0C0C0, new Item.Properties().tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> JONIN_SPAWN_EGG = register("jonin_spawn_egg",() -> new
            ForgeSpawnEggItem(ModEntityTypes.JONIN,0x808080, 0xFFFF00, new Item.Properties().tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> SCROLL = register("scroll",() -> new IntelligenceScroll(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> CLAN_ROLL = register("clan_roll",() -> new ClanRoll(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> RANDOM_NATURE = register("random_nature",() -> new RandomNatureItem(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));


    public static final RegistryObject<Item> CHAKRA_PAPER = register("chakra_paper",() -> new ChakraPaperItem(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> NINJA_FABRIC = register("ninja_fabric",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> GENIN_HELMET = ITEMS.register("genin_helmet",
            () -> new ArmorItem(ModArmorMaterials.GENIN, EquipmentSlot.HEAD,
                    new Item.Properties().tab(NarutoRevival.ARMOR_TAB)));
    public static final RegistryObject<Item> GENIN_CHESTPLATE = ITEMS.register("genin_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GENIN, EquipmentSlot.CHEST,
                    new Item.Properties().tab(NarutoRevival.ARMOR_TAB)));
    public static final RegistryObject<Item> GENIN_LEGGINGS = ITEMS.register("genin_leggings",
            () -> new ArmorItem(ModArmorMaterials.GENIN, EquipmentSlot.LEGS,
                    new Item.Properties().tab(NarutoRevival.ARMOR_TAB)));
    public static final RegistryObject<Item> GENIN_BOOTS = ITEMS.register("genin_boots",
            () -> new ArmorItem(ModArmorMaterials.GENIN, EquipmentSlot.FEET,
                    new Item.Properties().tab(NarutoRevival.ARMOR_TAB)));

    public static final RegistryObject<Item> XP_10000 = ITEMS.register("xp_10000",
            () -> new xp10000(new Item.Properties().tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            () -> new SwordItem(TiersInit.GENIN,2,3f,new Item.Properties().tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> WOODEN_KATANA = ITEMS.register("wooden_katana",
            () -> new SwordItem(TiersInit.GENIN,2,3f,new Item.Properties().tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> POUCH = ITEMS.register("pouch", () -> new PouchItem());
    public static final RegistryObject<Item> RYO_POUCH = ITEMS.register("ryo_pouch", () -> new RyobagItem());

    //JUTSU
    //Fire
    public static final RegistryObject<Item> JUTSU_FIRE_BALL = ITEMS.register("jutsu_fire_ball", () -> new JutsuItem(JutsuType.FIRE, 1, new FireOneJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_GREAT_FIREBALL = ITEMS.register("jutsu_great_fireball", () -> new JutsuItem(JutsuType.FIRE, 1, new GreatFireballJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_FIRE_BULLET = ITEMS.register("jutsu_fire_bullet", () -> new JutsuItem(JutsuType.FIRE, 1, new FireBulletJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> JUTSU_RUNNING_FIRE = ITEMS.register("jutsu_running_fire", () -> new JutsuItem(JutsuType.FIRE, 2, new FireTwoJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_EARTH_WALL = ITEMS.register("jutsu_earth_wall", () -> new JutsuItem(JutsuType.EARTH, 1, new EarthOneJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_SAND_TRAP = ITEMS.register("jutsu_sand_trap", () -> new JutsuItem(JutsuType.EARTH, 2, new EarthTwoJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_WATER_WALL = ITEMS.register("jutsu_water_wall", () -> new JutsuItem(JutsuType.WATER, 1, new WaterOneJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_SHARK_BULLET = ITEMS.register("jutsu_shark_bullet", () -> new JutsuItem(JutsuType.WATER, 2, new WaterTwoJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_WIND_MODE = ITEMS.register("jutsu_wind_mode", () -> new JutsuItem(JutsuType.WIND, 1, new WindOneJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_GALE_STRIKE = ITEMS.register("jutsu_gale_strike", () -> new JutsuItem(JutsuType.WIND, 2, new WindTwoJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_STATIC_FORCE = ITEMS.register("jutsu_static_force", () -> new JutsuItem(JutsuType.LIGHTNING, 1, new LightningOneJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> JUTSU_LIGHTNING_BALL = ITEMS.register("jutsu_lightning_ball", () -> new JutsuItem(JutsuType.LIGHTNING, 2, new LightningTwoJutsu().init(), new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
