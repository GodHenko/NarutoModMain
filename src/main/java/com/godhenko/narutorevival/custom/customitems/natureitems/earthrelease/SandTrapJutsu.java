package com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease;

import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.EarthTrapProjectile;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SandTrapJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 2;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.EARTH;
    }

    @Override
    public InteractionResult cast(Player player, Level world) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!ChakraManager.decreaseChakraIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        world.addFreshEntity(new EarthTrapProjectile(player, 2, world));

        return InteractionResult.SUCCESS;
    }



    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
