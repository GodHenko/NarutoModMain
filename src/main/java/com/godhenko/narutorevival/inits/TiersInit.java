package com.godhenko.narutorevival.inits;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TiersInit {

    public static final ForgeTier GENIN = new ForgeTier(1,1500,1f,3f,10, BlockTags.NEEDS_IRON_TOOL
    ,() -> Ingredient.of(ItemInit.NINJA_FABRIC.get()));
}
