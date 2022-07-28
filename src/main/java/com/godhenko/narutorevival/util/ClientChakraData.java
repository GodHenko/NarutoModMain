package com.godhenko.narutorevival.util;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.level.LevelAccessor;

public class ClientChakraData {


    public static double playerChakra;
    public static double playerMaxChakra;

    public static void execute(LevelAccessor world) {
    ClientChakraData.playerChakra = NarutoRevivalModVariables.MapVariables.get(world).chakra;
    ClientChakraData.playerMaxChakra = NarutoRevivalModVariables.MapVariables.get(world).maxChakra;
    }
    public static double getPlayerChakra(){
        return playerChakra;
    }

    public static double getPlayerMaxChakra() {
        return playerMaxChakra;
    }
}
