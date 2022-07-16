package com.godhenko.narutomod.inits;

import com.godhenko.narutomod.NarutoMod;
import com.google.common.base.Supplier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                NarutoMod.MOD_ID);

    public static final RegistryObject<Item> RAMEN = register("ramen",
            () -> new Item(new Item.Properties().tab(NarutoMod.Food_TAB).food(new FoodProperties.Builder().nutrition(50)
                    .saturationMod(10.0f).build())));


    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
