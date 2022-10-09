package com.godhenko.narutorevival.chakra;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerChakraProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerChakra> CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    private PlayerChakra playerChakra = null;
    private final LazyOptional<PlayerChakra> chakraOptional = LazyOptional.of(this::getPlayerChakra);

    private @NotNull PlayerChakra getPlayerChakra() {
        if (playerChakra == null) {
            playerChakra = new PlayerChakra();
        }
        return playerChakra;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction side) {
        if (capability == CAPABILITY) {
            return chakraOptional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        this.getPlayerChakra().toNbt(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.getPlayerChakra().fromNbt(tag);
    }
}
