package com.godhenko.narutorevival.jutsus.jutsus;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public interface Jutsu {
    InteractionResult cast(Player player, Level world, int level);

    void tick(Player player, Level world);

    default int chakraCost(@Nullable Player player, Level world) {
        return jutsuLevel() * 5;
    }

    default int skillPointCost() {
        return jutsuLevel();
    }

    default int attackDamage(int level) {
        return 0;
    }

    /**
     * Used for tooltips
     */
    int jutsuLevel();

    /**
     * Used for tooltips
     */
    JutsuType jutsuType();

    Jutsu init();
}