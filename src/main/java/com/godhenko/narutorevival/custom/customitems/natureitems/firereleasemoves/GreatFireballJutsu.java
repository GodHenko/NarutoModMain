package com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves;

import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.projectile.GreatFireballProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class GreatFireballJutsu implements Jutsu {
    @Override
    public void cast(Player player, Level world) {
        if (world.isClientSide()) return;

        world.addFreshEntity(new GreatFireballProjectile(player, 7 + ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).ninjutsu)/10, world));


    }

    @Override
    public void tick(Player player, Level world) {

    }
    @Override
    public Jutsu init() {
        return this;
    }

}
