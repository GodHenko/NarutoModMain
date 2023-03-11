package com.godhenko.narutorevival.network.extra.stat;

import com.godhenko.narutorevival.network.extra.Stats;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;

public class StatCapability {
    private final Player player;
    private final HashMap<String, StatCapabilityRecord> records = new HashMap<>();

    public StatCapability(Player player, HashMap<String, StatCapabilityRecord> records) {
        this.player = player;
        this.records.putAll(records);
    }

    public StatCapability() {
        this.player = null;
    }

    public float get(Stats stats) {
        String id = stats.get().getId();
        if (records.containsKey(id)) {
            return records.get(id).getStat();
        } else return 0.0f;
    }

    public float get(String id) {
        if (records.containsKey(id)) {
            return records.get(id).getStat();
        } else return 0.0f;
    }

    public void set(String id, float amount) {
        if (records.containsKey(id)) {
            StatCapabilityRecord record = records.get(id);
            float maxStat = record.getMaxStat().apply(player);

            if (amount < 0.0f) amount = 0.0f;
            if (amount > maxStat) amount = maxStat;

            record.setStat(amount);
        }
    }

    public void set(Stats stats, float amount) {
        this.set(stats.get().getId(), amount);
    }

    public void decrease(Stats stats, float amount) {
        this.set(stats, get(stats) - amount);
    }

    public void decrease(String id, float amount) {
        this.set(id, get(id) - amount);
    }

    public void add(Stats stats, float amount) {
        this.set(stats, get(stats) + amount);
    }

    public void add(String id, float amount) {
        this.set(id, get(id) + amount);
    }
    public void toNbt(CompoundTag tag) {
        for (StatCapabilityRecord record : records.values()) {
            tag.putFloat(record.getId(), record.getStat());
        }
    }

    public void fromNbt(CompoundTag tag) {
        for (StatCapabilityRecord record : records.values()) {
            float value = tag.getFloat(record.getId());
            record.setStat(value);
        }
    }
}
