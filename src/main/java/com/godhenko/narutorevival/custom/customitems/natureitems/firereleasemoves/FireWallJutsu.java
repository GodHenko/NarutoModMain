package com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves;

import com.godhenko.narutorevival.inits.ItemInit;
import com.godhenko.narutorevival.jutsus.jutsus.BlockTimer;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class FireWallJutsu implements Jutsu {

    @Override
    public void cast(Player player, Level world) {
        if (world.isClientSide()) return;
        player.getCooldowns().addCooldown(ItemInit.JUTSU_EARTH_WALL.get(),60 - (int)NarutoRevivalModVariables.MapVariables.get(world).ninjutsu);
        BlockHitResult hitResult = JutsuHelper.raycast(world, player, 16);
        if (hitResult.getType() == HitResult.Type.MISS) return;

        BlockPos blockPos = hitResult.getBlockPos();
        Direction hitDir = hitResult.getDirection();
        Direction playerDir = player.getDirection();

        JutsuHelper.spawnCircleParticles(world, ParticleTypes.FLAME, Direction.Axis.Y, player.getX(), player.getY(), player.getZ(), 0, 0.5, 0, 1, 3, 64);
        JutsuHelper.spawnCircleParticles(world, ParticleTypes.CAMPFIRE_COSY_SMOKE, Direction.Axis.Y, player.getX(), player.getY(), player.getZ(), -0.2, 0, -0.2, 1, 3.5, 64);

        Iterable<BlockPos> poses = getPoses(playerDir, hitDir, blockPos);
        for (BlockPos pos : poses) {
            if (world.getBlockState(pos).isAir() && world.isInWorldBounds(pos)) {
                world.setBlockAndUpdate(pos, Blocks.FIRE.defaultBlockState());
            }
        }
        BlockTimer timer = new BlockTimer(world, 100, poses, Blocks.FIRE);
        JutsuTicker.addTimer(timer);
    }

    private static Iterable<BlockPos> getPoses(Direction playerDir, Direction hitDir, BlockPos blockPos) {
        int x1 = blockPos.getX();
        int x2 = blockPos.getX();
        int y1 = blockPos.getY() - 1;
        int y2 = blockPos.getY() + 3;
        int z1 = blockPos.getZ();
        int z2 = blockPos.getZ();

        if (playerDir == Direction.NORTH || playerDir == Direction.SOUTH) {
            x1 -= 3;
            x2 += 3;
        } else {
            z1 -= 3;
            z2 += 3;
        }

        if (hitDir == Direction.UP) {
            y1 += 1;
            y2 += 1;
        } else if (hitDir == Direction.DOWN) {
            y1 -= 3;
            y2 -= 3;
        }

        return BlockPos.betweenClosed(x1, y1, z1, x2, y2, z2);
    }

    @Override
    public void tick(Player player_, Level world_) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
