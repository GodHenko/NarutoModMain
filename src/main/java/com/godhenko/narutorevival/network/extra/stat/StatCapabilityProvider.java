package com.godhenko.narutorevival.network.extra.stat;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StatCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<StatCapability> CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    private final Player player;
    private StatCapability playerStat = null;
    private final LazyOptional<StatCapability> statOptional = LazyOptional.of(this::getPlayerStat);

    public StatCapabilityProvider(Player player) {
        this.player = player;
    }

    private @NotNull StatCapability getPlayerStat() {
        if (playerStat == null) {
            playerStat = new StatCapabilityBuilder().registerAll().setPlayer(player).build();
        }
        return playerStat;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CAPABILITY) {
            return statOptional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        this.getPlayerStat().toNbt(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.getPlayerStat().fromNbt(tag);
    }
}
