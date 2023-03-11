package com.godhenko.narutorevival.jutsus.client;

import java.util.HashMap;
import java.util.Optional;

public class ClientEarthArmorPlayers {
    private static final HashMap<String, Boolean> clientEarthArmorPlayers = new HashMap<>();

    public static void set(String username, boolean isOn) {
        clientEarthArmorPlayers.put(username, isOn);
    }

    public static boolean get(String username) {
        return Optional.ofNullable(clientEarthArmorPlayers.get(username)).orElse(false);
    }
}
