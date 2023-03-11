package com.godhenko.narutorevival.network.extra.stat;

import net.minecraft.world.entity.player.Player;

import java.util.function.Function;

public class StatCapabilityRecord {
    private final String id;
    private final Function<Player, Float> maxStat;
    private float stat;

    public StatCapabilityRecord(String id, Function<Player, Float> maxStat, float stat) {
        this.id = id;
        this.maxStat = maxStat;
        this.stat = stat;
    }

    public void setStat(float stat) {
        this.stat = stat;
    }

    public String getId() {
        return id;
    }

    public Function<Player, Float> getMaxStat() {
        return maxStat;
    }

    public float getStat() {
        return stat;
    }
}
