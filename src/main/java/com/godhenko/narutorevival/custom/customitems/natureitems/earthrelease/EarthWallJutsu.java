package com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease;


import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.BlockTimer;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.godhenko.narutorevival.network.extra.Stats;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class EarthWallJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 1;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.EARTH;
    }

    @Override
    public InteractionResult cast(Player player, Level world, int level) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        BlockHitResult hitResult = JutsuHelper.raycast(world, player, 8*level);
        if (hitResult.getType() == HitResult.Type.MISS) {
            return InteractionResult.PASS;
        }

        if (!Stats.CHAKRA.get().getManager().decreaseIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        BlockPos blockPos = hitResult.getBlockPos();
        Direction hitDir = hitResult.getDirection();
        Direction playerDir = player.getDirection();

        JutsuHelper.spawnCircleParticles(world, ParticleTypes.HAPPY_VILLAGER, Direction.Axis.Y, player.getX(), player.getY(), player.getZ(), 0, 0.5, 0, 1, 3, 64);
        JutsuHelper.spawnCircleParticles(world, ParticleTypes.CAMPFIRE_COSY_SMOKE, Direction.Axis.Y, player.getX(), player.getY(), player.getZ(), -0.2, 0, -0.2, 1, 3.5, 64);

        Iterable<BlockPos> poses = getPoses(playerDir, hitDir, blockPos, level);
        for (BlockPos pos : poses) {
            if (world.getBlockState(pos).isAir() && world.isInWorldBounds(pos)) {
                world.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
            }
        }
        BlockTimer timer = new BlockTimer(world, 50, poses, Blocks.DIRT);
        JutsuTicker.addTimer(timer);

        return InteractionResult.SUCCESS;
    }

    private static Iterable<BlockPos> getPoses(Direction playerDir, Direction hitDir, BlockPos blockPos, int level) {
        int x1 = blockPos.getX();
        int x2 = blockPos.getX();
        int y1 = blockPos.getY() - 1;
        int y2 = blockPos.getY() + level;
        int z1 = blockPos.getZ();
        int z2 = blockPos.getZ();

        if (playerDir == Direction.NORTH || playerDir == Direction.SOUTH) {
            x1 -= level;
            x2 += level;
        } else {
            z1 -= level;
            z2 += level;
        }

        if (hitDir == Direction.UP) {
            y1 += 1;
            y2 += 1;
        } else if (hitDir == Direction.DOWN) {
            y1 -= level;
            y2 -= level;
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
