package com.godhenko.narutorevival.network.extra.misc;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {
    public static KeyMapping GATHER_MANA_KEYBINDING;

    public static void register() {
        GATHER_MANA_KEYBINDING = new KeyMapping("key.gather_chakra", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, InputConstants.KEY_N, "key.narutorevival.category");
        ClientRegistry.registerKeyBinding(GATHER_MANA_KEYBINDING);
    }
}
