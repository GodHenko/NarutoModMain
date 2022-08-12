package com.godhenko.narutorevival.world.dimension;

import com.godhenko.narutorevival.NarutoRevival;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> NRDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,new ResourceLocation(NarutoRevival.MOD_ID,"nrdim"));

    public static final ResourceKey<DimensionType> NRDIM_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,NRDIM_KEY.getRegistryName());

    public static void register(){
        System.out.println("Registering ModDimensions for " + NarutoRevival.MOD_ID);
    }
}
