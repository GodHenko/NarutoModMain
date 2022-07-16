package com.godhenko.narutomod.inits;

import com.godhenko.narutomod.NarutoMod;
import com.google.common.base.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            NarutoMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;


    public static final RegistryObject<Block> UCHIHA_CLOTH = register("uchiha_cloth",() -> new Block
            (BlockBehaviour.Properties.copy(Blocks.BLUE_WOOL)),
                    object -> () -> new BlockItem(object.get(), new Item.Properties().tab(NarutoMod.BLOCK_TAB)));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name,
                                                                     final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
                                                                Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }
}
