package com.godhenko.narutorevival.jutsus.jutsus;

import net.minecraft.world.level.Level;

import java.util.UUID;

public class FreezeTimer {
    private final Level world;
    private final UUID uuid;
    private final double x;
    private final double y;
    private final double z;
    private Integer time;

    public FreezeTimer(Level world, UUID uuid, double x, double y, double z, int time) {
        this.world = world;
        this.uuid = uuid;
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
    }

    public Level world() {
        return world;
    }

    public UUID uuid() {
        return uuid;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double z() {
        return z;
    }

    public Integer time() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
