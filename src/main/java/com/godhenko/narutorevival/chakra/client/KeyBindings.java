package com.godhenko.narutorevival.chakra.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {
    public static KeyMapping GATHER_CHAKRA_KEYBINDING;

    public static void register() {
        GATHER_CHAKRA_KEYBINDING = new KeyMapping("key.gather_chakra", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, InputConstants.KEY_N, KeyMapping.CATEGORY_GAMEPLAY);
        ClientRegistry.registerKeyBinding(GATHER_CHAKRA_KEYBINDING);
    }
}
