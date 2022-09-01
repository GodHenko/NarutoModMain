package com.godhenko.narutorevival.custom.customitems.jutsuitems;

import net.minecraft.ChatFormatting;

import java.util.Locale;

public enum JutsuType {
    FIRE (ChatFormatting.RED),
    WATER (ChatFormatting.BLUE),
    EARTH (ChatFormatting.GREEN),
    WIND (ChatFormatting.WHITE),
    LIGHTNING (ChatFormatting.YELLOW);

    ChatFormatting color;
    JutsuType(ChatFormatting color) {
        this.color = color;
    }

    public String getName() {
        return super.toString().toLowerCase(Locale.ROOT);
    }

    public ChatFormatting getColor() {
        return color;
    }
}
