package com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves;

import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.projectile.FireBulletProjectile;
import com.godhenko.narutorevival.projectile.FireballProjectile;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class FireBulletJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 1;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.FIRE;
    }


    @Override
    public InteractionResult cast(Player player, Level world) {

        if ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).fire == 0) {
            player.sendMessage(new TranslatableComponent("You don't have the fire nature"), player.getUUID());
        } else {
            if (world.isClientSide()) {
                return InteractionResult.PASS;
            }

            if (!ChakraManager.decreaseChakraIfEnough(player, chakraCost(player, world))) {
                return InteractionResult.PASS;
            }


            world.addFreshEntity(new FireBulletProjectile(player, 3.5, world));
        }
            return InteractionResult.SUCCESS;


    }



    @Override
    public void tick(Player player, Level world) {
    }
    @Override
    public int attackDamage() {
        return 4 ;
    }
    @Override
    public Jutsu init() {
        return this;
    }

}
