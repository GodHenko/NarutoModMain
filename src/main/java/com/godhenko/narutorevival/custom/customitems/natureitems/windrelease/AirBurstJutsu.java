package com.godhenko.narutorevival.custom.customitems.natureitems.windrelease;

import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.AirBurstProjectile;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class AirBurstJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 1;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.WIND;
    }

    @Override
    public InteractionResult cast(Player player, Level world) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!ChakraManager.decreaseChakraIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        world.addFreshEntity(new AirBurstProjectile(player, 3, world));

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
