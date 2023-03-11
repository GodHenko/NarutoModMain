package com.godhenko.narutorevival.network.extra;


import com.godhenko.narutorevival.network.extra.client.ClientPlayerStats;
import com.godhenko.narutorevival.network.extra.stat.StatManager;
import net.minecraft.world.entity.player.Player;
import java.util.function.Function;

public class Stat {
    private final StatManager manager;
    private final String id;
    private final Function<Player, Float> maxStat;

    public Stat(String id, Function<Player, Float> maxStat, float naturalRegenAmount) {
        this.maxStat = maxStat;
        this.manager = new StatManager(id, naturalRegenAmount);
        this.id = id;

        ClientPlayerStats.register(id);
    }

    public StatManager getManager() {
        return manager;
    }

    public String getId() {
        return id;
    }

    public float getMax(Player player) {
        return maxStat.apply(player);
    }

    public Function<Player, Float> getMaxStat() {
        return maxStat;
    }
}
