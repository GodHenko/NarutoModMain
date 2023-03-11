package com.godhenko.narutorevival.network.extra.client;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Optional;

public class ClientPlayerStats {
    private static final HashMap<String, ClientPlayerStat> clientPlayerStats = new HashMap<>();

    public static void register(String id) {
        clientPlayerStats.put(id, new ClientPlayerStat());
    }

    public static @NotNull ClientPlayerStat get(String id) {
        return Optional.ofNullable(clientPlayerStats.get(id)).orElse(new ClientPlayerStat());
    }
}
