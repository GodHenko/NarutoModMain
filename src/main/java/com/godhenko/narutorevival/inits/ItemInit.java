package com.godhenko.narutorevival.inits;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.custom.armor.ModArmorMaterials;
import com.godhenko.narutorevival.custom.customitems.ClanRoll;
import com.godhenko.narutorevival.custom.customitems.IntelligenceScroll;
import com.godhenko.narutorevival.custom.customitems.xp10000;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.google.common.base.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                NarutoRevival.MOD_ID);

    public static final RegistryObject<Item> RAMEN = register("ramen",
            () -> new Item(new Item.Properties().tab(NarutoRevival.Food_TAB).food(new FoodProperties.Builder().nutrition(50)
                    .saturationMod(10.0f).build())));

    public static final RegistryObject<Item> BRONZE_RYO = register("bronze_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> SILVER_RYO = register("silver_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> GOLD_RYO = register("gold_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));


    public static final RegistryObject<Item> UCHIHA = register("uchiha",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> HYUGA = register("hyuga",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> UZUMAKI = register("uzumaki",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> ABURAME = register("aburame",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> AKIMICHI = register("akimichi",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> HATAKE = register("hatake",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> HOZUKI = register("hozuki",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> IBURI = register("iburi",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> INUZUKA = register("inuzuka",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> JUGO = register("jugo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> KAGUYA = register("kaguya",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> KURAMA = register("kurama",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> TSUCHIGUMO = register("tsuchigumo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> NARA = register("nara",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> SARUTOBI = register("sarutobi",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> FUMA = register("fuma",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> SENJU = register("senju",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> YUKI = register("yuki",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> YAMANAKA = register("yamanaka",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> LEE = register("lee",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> CHINIOKE = register("chinoike",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    public static final RegistryObject<Item> SHIROGANE = register("shirogane",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.CLAN_TAB)));
    //Natures
    public static final RegistryObject<Item> FIRE_NATURE = register("fire_nature",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB)));
    public static final RegistryObject<Item> WATER_NATURE = register("water_nature",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB)));
    public static final RegistryObject<Item> WIND_NATURE = register("wind_nature",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB)));
    public static final RegistryObject<Item> EARTH_NATURE = register("earth_nature",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB)));
    public static final RegistryObject<Item> LIGHTNING_NATURE = register("lightning_nature",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.NATURES_TAB)));



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



    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
