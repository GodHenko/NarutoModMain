package com.godhenko.narutorevival.chakra;

import com.godhenko.narutorevival.chakra.network.ChakraNetworkChannel;
import com.godhenko.narutorevival.chakra.network.UpdateChakraPacket;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.mojang.datafixers.util.Pair;
import net.minecraft.Util;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChakraManager {
    private static final HashMap<String, Vec3> playerPositions = new HashMap<>();
    private static final List<Pair<Player, Float>> chakraOverTime = new ArrayList<>();
    private static long lastMillis = Util.getMillis();

    public static void tick() {
        List<ServerPlayer> players = ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers();
        players.forEach((player) -> {
            player.getCapability(PlayerChakraProvider.CAPABILITY).ifPresent((capability) -> {
                String playerName = player.getName().getString();
                float chakra = capability.getChakra();

                // Check if the player is standing still
                if (player.position().equals(playerPositions.get(playerName))) {
                    // Apply natural regen
                    addChakraOverTime(player, 0.5f);
                }

                playerPositions.put(playerName, player.position());

                // Send chakra amount to the client
                ChakraNetworkChannel.sendS2C(new UpdateChakraPacket(chakra), player);
            });
        });

        chakraOverTime.forEach(pair -> doAddChakraOverTime(pair.getFirst(), pair.getSecond()));
        chakraOverTime.clear();

        lastMillis = Util.getMillis();
    }

    public static void setChakra(Player player, float amount) {
        player.getCapability(PlayerChakraProvider.CAPABILITY).ifPresent((capability) -> {
            capability.setChakra(amount);
        });
    }

    public static void decreaseChakra(Player player, float amount) {
        player.getCapability(PlayerChakraProvider.CAPABILITY).ifPresent((capability) -> {
            capability.decreaseChakra(amount);
        });
    }
    public static void decreaseJutsuPoints(Player player, float amount) {
        player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.jutsuPoints = amount;
            capability.syncPlayerVariables(player);
        });
    }

    public static void addChakra(Player player, float amount) {
        player.getCapability(PlayerChakraProvider.CAPABILITY).ifPresent((capability) -> {
            capability.addChakra(amount);
        });
    }

    public static void decreaseChakraOverTime(Player player, float amount) {
        // Schedule decreasing chakra next tick
        chakraOverTime.add(Pair.of(player, -amount));
    }

    public static void addChakraOverTime(Player player, float amount) {
        // Schedule adding chakra next tick
        chakraOverTime.add(Pair.of(player, amount));
    }

    private static void doAddChakraOverTime(Player player, float amount) {
        long mspt = Util.getMillis() - lastMillis;
        float msAmount = (amount/1000) * mspt;

        addChakra(player, msAmount);
    }


    public static boolean decreaseChakraIfEnough(Player player, float amount) {
        boolean haveEnough = hasEnoughChakra(player, amount);

        if (haveEnough) {
            decreaseChakra(player, amount);
            return true;
        } else {
            return false;
        }
    }

    public static boolean decreaseJutsuPointsIfEnough(Player player, float amount) {
        boolean haveEnough = hasEnoughJutsuPoints(player, amount);

        if (haveEnough) {
            decreaseJutsuPoints(player, amount);
            return true;
        } else {
            return false;
        }
    }

    public static boolean decreaseChakraOverTimeIfEnough(Player player, float amount) {
        boolean haveEnough = hasEnoughChakra(player, amount);

        if (haveEnough) {
            decreaseChakraOverTime(player, amount);
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasEnoughChakra(Player player, float amount) {
        PlayerChakra playerChakra = player.getCapability(PlayerChakraProvider.CAPABILITY).orElse(new PlayerChakra());
        return (playerChakra.getChakra() >= amount) || isPlayerChakraInfinite(player);
    }

    public static boolean hasEnoughJutsuPoints(Player player, float amount) {
        double playerChakra = (player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).jutsuPoints;
        return (playerChakra >= amount);
    }

    public static boolean isPlayerChakraInfinite(Player player) {
        return player.isCreative() || player.isSpectator();
    }
}
