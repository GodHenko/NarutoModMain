package com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves;

import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.projectile.SharkProjectile;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SharkBulletJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 1;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.WATER;
    }

    @Override
    public InteractionResult cast(Player player, Level world) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!ChakraManager.decreaseChakraIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        float power = world.isRainingAt(player.blockPosition()) ? 4f : 3.5f;
        world.addFreshEntity(new SharkProjectile(player, power, world));

        return InteractionResult.SUCCESS;
    }

    public int attackDamage() {
        return 10 ;
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
