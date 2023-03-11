package com.godhenko.narutorevival.network.extra.stat;

import com.godhenko.narutorevival.network.extra.StatNetworkChannel;
import com.mojang.datafixers.util.Pair;

import net.minecraft.Util;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatManager {
    private final HashMap<String, Vec3> playerPositions = new HashMap<>();
    private final List<Pair<Player, Float>> statOverTime = new ArrayList<>();
    private long lastMillis = Util.getMillis();
    private final float naturalRegenAmount;
    private final String id;

    public StatManager(String id, float naturalRegenAmount) {
        this.id = id;
        this.naturalRegenAmount = naturalRegenAmount;
    }

    public void tick() {
        List<ServerPlayer> players = ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers();
        players.forEach((player) -> {
            player.getCapability(StatCapabilityProvider.CAPABILITY).ifPresent((capability) -> {
                String playerName = player.getName().getString();
                float stat = capability.get(id);

                // Check if the player is standing still
                if (naturalRegenAmount > 0.0f && player.position().equals(playerPositions.get(playerName))) {
                    // Apply natural regen
                    addOverTime(player, naturalRegenAmount);
                }

                playerPositions.put(playerName, player.position());

                // Send mana amount to the client
                StatNetworkChannel.sendS2C(new UpdateStatPacket(id, stat), player);
            });
        });

        statOverTime.forEach(pair -> doAddOverTime(pair.getFirst(), pair.getSecond()));
        statOverTime.clear();

        lastMillis = Util.getMillis();
    }

    public void set(Player player, float amount) {
        player.getCapability(StatCapabilityProvider.CAPABILITY).ifPresent((capability) -> {
            capability.set(id, amount);
        });
    }

    public void decrease(Player player, float amount) {
        player.getCapability(StatCapabilityProvider.CAPABILITY).ifPresent((capability) -> {
            capability.decrease(id, amount);
        });
    }

    public void add(Player player, float amount) {
        player.getCapability(StatCapabilityProvider.CAPABILITY).ifPresent((capability) -> {
            capability.add(id, amount);
        });
    }

    public float get(Player player) {
        StatCapability stat = player.getCapability(StatCapabilityProvider.CAPABILITY).orElse(new StatCapability());
        return stat.get(id);
    }

    public void decreaseOverTime(Player player, float amount) {
        // Schedule decreasing mana next tick
        statOverTime.add(Pair.of(player, -amount));
    }

    public void addOverTime(Player player, float amount) {
        // Schedule adding mana next tick
        statOverTime.add(Pair.of(player, amount));
    }

    private void doAddOverTime(Player player, float amount) {
        long mspt = Util.getMillis() - lastMillis;
        float msAmount = (amount/1000) * mspt;

        add(player, msAmount);
    }


    public boolean decreaseIfEnough(Player player, float amount) {
        boolean haveEnough = hasEnough(player, amount);

        if (haveEnough) {
            decrease(player, amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean decreaseOverTimeIfEnough(Player player, float amount) {
        boolean haveEnough = hasEnough(player, amount);

        if (haveEnough) {
            decreaseOverTime(player, amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean hasEnough(Player player, float amount) {
        StatCapability statCapability = player.getCapability(StatCapabilityProvider.CAPABILITY).orElse(new StatCapability());
        return (statCapability.get(id) >= amount) || isPlayerStatInfinite(player);
    }

    public boolean isPlayerStatInfinite(Player player) {
        return player.isCreative() || player.isSpectator();
    }
}
