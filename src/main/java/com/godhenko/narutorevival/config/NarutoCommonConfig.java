package com.godhenko.narutorevival.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class NarutoCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> KENJUTSU_REQUIREMENT;

    static {
        BUILDER.push("Configs for Naruto Revival Mod");

        KENJUTSU_REQUIREMENT = BUILDER.comment("Swords Requiring Kenjutsu to use")
                        .define("Defualt:True",true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}