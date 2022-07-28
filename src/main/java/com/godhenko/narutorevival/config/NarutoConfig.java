package com.godhenko.narutorevival.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class NarutoConfig  {

    public static ForgeConfigSpec.IntValue CHAKRA_HUD_X;
    public static ForgeConfigSpec.IntValue CHAKRA_HUD_Y;
    public static ForgeConfigSpec.IntValue CHAKRA_HUD_COLOR;

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for Naruto Revival Mod");




        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static void registerClientConfig(ForgeConfigSpec.Builder CLIENT_BUILDER) {
        CLIENT_BUILDER.comment("Settings for the chakra system").push("chakra");

        CHAKRA_HUD_X = CLIENT_BUILDER
                .comment("X location of the chakra hud")
                .defineInRange("chakraHudX", 10, -1, Integer.MAX_VALUE);
        CHAKRA_HUD_Y = CLIENT_BUILDER
                .comment("Y location of the chakra hud")
                .defineInRange("chakraHudY", 10, -1, Integer.MAX_VALUE);
        CHAKRA_HUD_COLOR = CLIENT_BUILDER
                .comment("Color of the chakra hud")
                .defineInRange("chakraHudColor", 0xffffffff, Integer.MIN_VALUE, Integer.MAX_VALUE);

        CLIENT_BUILDER.pop();
    }
}

