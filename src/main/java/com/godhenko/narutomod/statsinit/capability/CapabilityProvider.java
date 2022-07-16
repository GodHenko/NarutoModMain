package com.godhenko.narutomod.statsinit.capability;

import com.godhenko.narutomod.api.RevivalAPI;
import com.godhenko.narutomod.api.attribute.IPlayerAttributes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CapabilityProvider implements ICapabilitySerializable<Tag> {
    private final LazyOptional<IPlayerAttributes> optional;
    private final IPlayerAttributes data;

    public CapabilityProvider() {
        this.data = new AttributesCapability();
        this.optional = LazyOptional.of(() -> data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nullable Capability<T> par0, Direction par1) {
        return RevivalAPI.PLAYER_ATTRIBUTES.orEmpty(par0, optional);
    }

    @Override
    public Tag serializeNBT() {
        return data.write();
    }

    @Override
    public void deserializeNBT(Tag par0) {
        data.read((CompoundTag) par0);
    }
}