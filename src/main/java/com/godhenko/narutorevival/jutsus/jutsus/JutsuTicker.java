package com.godhenko.narutorevival.jutsus.jutsus;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class JutsuTicker {
    private static final HashMap<Jutsu, ArrayList<Player>> playerTickers = new HashMap<>();
    private static final HashSet<Jutsu> tickers = new HashSet<>();
    private static final ArrayList<BlockTimer> timers = new ArrayList<>();
    private static final ArrayList<FreezeTimer> freeze = new ArrayList<>();

    public static void registerPlayerTicker(Jutsu jutsu) {
        playerTickers.put(jutsu, new ArrayList<>());
    }

    public static void registerTicker(Jutsu jutsu) {
        tickers.add(jutsu);
    }

    public static void startTicking(Jutsu jutsu, Player player) {
        if (playerTickers.get(jutsu).contains(player) || player.getLevel().isClientSide()) {
            return;
        }
        playerTickers.get(jutsu).add(player);
    }

    public static void stopTicking(Jutsu jutsu, Player player) {
        playerTickers.get(jutsu).remove(player);
    }

    public static boolean isTicking(Jutsu jutsu, Player player) {
        return playerTickers.get(jutsu).contains(player);
    }

    public static void addTimer(BlockTimer timer) {
        timers.add(timer);
    }

    public static void freeze(FreezeTimer timer) {
        freeze.add(timer);
    }

    public static void tick() {
        // Clone player tickers to prevent concurrent modification
        HashMap<Jutsu, ArrayList<Player>> playerTickersToTick = new HashMap<>();
        playerTickers.forEach(((jutsu, players) -> {
            ArrayList<Player> clonedPlayers = new ArrayList<>(players);
            playerTickersToTick.put(jutsu, clonedPlayers);
        }));

        playerTickersToTick.forEach(((jutsu, players) -> {
            for (Player player : players) {
                jutsu.tick(player, player.getLevel());
            }
        }));
        tickers.forEach((spell -> {
            spell.tick(null, null);
        }));

        tickTimers();
        tickFreezes();
    }

    private static void tickTimers() {
        ArrayList<BlockTimer> timersToRemove = new ArrayList<>();

        for (int i = 0; i < timers.size(); i++) {
            BlockTimer timer = timers.get(i);

            int time = timer.time() - 1;
            timer.setTime(time);

            if (time <= 0) {
                Level world = timer.world();
                Iterable<BlockPos> poses = timer.poses();
                Block block = timer.block();

                for(BlockPos pos : poses) {
                    if (world.getBlockState(pos).is(block) && world.isInWorldBounds(pos)) {
                        // i have no idea why but it crashes when calling Level#setBlockAndUpdate
                        world.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_SUPPRESS_LIGHT+Block.UPDATE_ALL);
                    }
                }

                timersToRemove.add(timer);
            } else {
                timers.set(i, timer);
            }
        }

        for (BlockTimer timer : timersToRemove) {
            timers.remove(timer);
        }
    }

    private static void tickFreezes() {
        ArrayList<FreezeTimer> timersToRemove = new ArrayList<>();

        for (int i = 0; i < freeze.size(); i++) {
            FreezeTimer timer = freeze.get(i);

            int time = timer.time() - 1;
            timer.setTime(time);

            if (time <= 0) {
                timersToRemove.add(timer);
                continue;
            }

            freeze.set(i, timer);

            Level world = timer.world();
            Player player = world.getPlayerByUUID(timer.uuid());

            if (player == null) {
                continue;
            }

            player.teleportTo(timer.x(), timer.y(), timer.z());
        }

        for (FreezeTimer timer : timersToRemove) {
            freeze.remove(timer);
        }
    }
}

