package com.godhenko.narutorevival.inits;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.custom.armor.ModArmorMaterials;
import com.godhenko.narutorevival.custom.customitems.ClanRoll;
import com.godhenko.narutorevival.custom.customitems.IntelligenceScroll;
import com.godhenko.narutorevival.custom.customitems.xp10000;
import com.godhenko.narutorevival.entity.ModEntityTypes;
import com.google.common.base.Supplier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
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

    public static final RegistryObject<Item> BRONZE_RYO = register("bronze_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> SILVER_RYO = register("silver_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

    public static final RegistryObject<Item> GOLD_RYO = register("gold_ryo",() -> new Item(new Item.Properties()
            .tab(NarutoRevival.MISC_TAB)));

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



    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
