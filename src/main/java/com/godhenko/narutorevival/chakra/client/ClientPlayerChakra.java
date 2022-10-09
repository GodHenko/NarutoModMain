package com.godhenko.narutorevival.chakra.client;

public class ClientPlayerChakra {
    private static float playerchakra;
    private static float playerMaxChakra;

    public static void setChakra(float chakra) {
        playerchakra = chakra;
    }
    public static void setMaxChakra(float maxchakra) {
        playerchakra = maxchakra;
    }

    public static float getChakra() {
        return playerchakra;
    }
    public static float getMaxChakra() {
        return playerchakra;
    }
}
