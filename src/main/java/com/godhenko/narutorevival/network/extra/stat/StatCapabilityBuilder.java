package com.godhenko.narutorevival.network.extra.stat;


import com.godhenko.narutorevival.network.extra.Stat;
import com.godhenko.narutorevival.network.extra.Stats;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.function.Function;

public class StatCapabilityBuilder {
    private final HashMap<String, StatCapabilityRecord> records = new HashMap<>();
    private Player player;

    public StatCapabilityBuilder register(String id, Function<Player, Float> maxStat, float stat) {
        putRecord(id, maxStat, stat);
        return this;
    }

    public StatCapabilityBuilder registerAll() {
        for (Stats stats : Stats.values()) {
            Stat stat = stats.get();
            putRecord(stat.getId(), stat.getMaxStat(), 0.0f);
        }
        return this;
    }

    public StatCapabilityBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public StatCapability build() {
        return new StatCapability(player, records);
    }

    private void putRecord(String id, Function<Player, Float> maxStat, float stat) {
        StatCapabilityRecord record = new StatCapabilityRecord(id, maxStat, stat);
        records.put(id, record);
    }
}
