package com.godhenko.narutorevival.network.extra;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.extra.client.ClientPlayerStats;
import com.godhenko.narutorevival.network.extra.util.LevelingHelper;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public enum Stats {
    LVL(new Stat("smmlvl", (player) -> Float.POSITIVE_INFINITY, 0f)),
    LEVEL(new Stat("smmlevel", (player) -> Float.POSITIVE_INFINITY, 0f)),
    JP(new Stat("smmjp", (player) -> Float.POSITIVE_INFINITY, 0f)),
    SP(new Stat("smmsp", (player) -> Float.POSITIVE_INFINITY, 0f)),
    NINJUTSU(new Stat("smmninjutsu", (player) -> Float.POSITIVE_INFINITY, 0f)),
    TAIJUTSU(new Stat("smmtaijutsu", (player) -> Float.POSITIVE_INFINITY, 0f)),
    GENJUTSU(new Stat("smmgenjutsu", (player) -> Float.POSITIVE_INFINITY, 0f)),
    KENJUTSU(new Stat("smmkenjutsu", (player) -> Float.POSITIVE_INFINITY, 0f)),
    SHURIKENJUTSU(new Stat("smmshurikenjutsu", (player) -> Float.POSITIVE_INFINITY, 0f)),
    SUMMONING(new Stat("smmsummoning", (player) -> Float.POSITIVE_INFINITY, 0f)),
    KINJUTSU(new Stat("smmkinjutsu", (player) -> Float.POSITIVE_INFINITY, 0f)),
    senjutsu(new Stat("smmsenjutsu", (player) -> Float.POSITIVE_INFINITY, 0f)),
    MEDICAL(new Stat("smmmedical", (player) -> Float.POSITIVE_INFINITY, 0f)),
    INTEL(new Stat("smmintel", (player) -> Float.POSITIVE_INFINITY, 0f)),
    SPEED(new Stat("smmspeed", (player) -> Float.POSITIVE_INFINITY, 0f)),

    CHAKRA(new Stat("chakra", (player) -> {
        float initialMaxChakra = 100f;
        float chakraPerLVL = (float) (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).ninjutsu * 5;

        if (player == null) return Float.POSITIVE_INFINITY;

        float exp = 0;
        if (player.level.isClientSide()) {
            exp = ClientPlayerStats.get("smmlvl").get();
        } else {
            exp = LVL.get().getManager().get(player);
        }

        float lvl = LevelingHelper.exponential(exp, 2) - 1f;

        return initialMaxChakra + (chakraPerLVL);
    }, 0.5f));





    final Stat stat;
    Stats(Stat stat) {
        this.stat = stat;
    }

    public Stat get() {
        return stat;
    }

    public static Collection<String> getNames() {
        List<String> list = Lists.newArrayList();
        for (Stats stats : values()) {
            list.add(stats.get().getId().replace("smm", ""));
        }
        return list;
    }

    public static Stats getByName(String name) {
        for (Stats stats : values()) {
            if (stats.get().getId().replace("smm", "").equals(name)) return stats;
        }
        return null;
    }
}
