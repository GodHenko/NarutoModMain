package com.godhenko.narutomod.api;

import com.godhenko.narutomod.api.attribute.IPlayerAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;

public class RevivalAPI {

    /** Capability access. */
    public static final Capability<IPlayerAttributes> PLAYER_ATTRIBUTES = CapabilityManager.get(new CapabilityToken<>(){});;
    public static final String MODID = "narutomod";

    /**
     * @param par0 Player instance.
     * @return The player attributes capability instance.
     */
    public static LazyOptional<IPlayerAttributes> playerAttributes(Player par0) {
        return par0.getCapability(PLAYER_ATTRIBUTES, null);
    }
}