package com.godhenko.narutomod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class NarutoConfig  {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for Naruto Revival Mod");




        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}

