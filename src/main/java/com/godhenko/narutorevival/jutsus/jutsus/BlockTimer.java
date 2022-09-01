package com.godhenko.narutorevival.jutsus.jutsus;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;

public class BlockTimer {
    private final Level world;
    private final Iterable<BlockPos> poses;
    private Integer time;
    private Block block;

    public BlockTimer(Level world, Integer time, Iterable<BlockPos> poses, Block block) {
        this.world = world;
        this.time = time;
        this.poses = poses;
        this.block = block;
    }

    public BlockTimer(Level world, Integer time, BlockPos pos, Block block) {
        this.world = world;
        this.time = time;
        this.block = block;
        ArrayList<BlockPos> poses = new ArrayList<>();
        poses.add(pos);
        this.poses = poses;
    }

    public Integer time() {
        return time;
    }

    public Iterable<BlockPos> poses() {
        return poses;
    }

    public Level world() {
        return world;
    }

    public Block block() {
        return block;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
