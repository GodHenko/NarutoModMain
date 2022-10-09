package com.godhenko.narutorevival.chakra;

import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class PlayerChakra{

    private float chakra = 0;

    public float getMaxChakra() {
        return maxChakra;
    }

    public float maxChakra = 100;

    public float getChakra() {
        return chakra;
    }

    public void setChakra(float chakra) {
        this.chakra = chakra;

        if (this.chakra > maxChakra) {
            this.chakra = maxChakra;
        }
        if (this.chakra < 0) {
            this.chakra = 0;
        }
    }

    public void addChakra(float chakra) {
        this.chakra += chakra;

        if (this.chakra > maxChakra) {
            this.chakra = maxChakra;
        }
        if (this.chakra < 0) {
            this.chakra = 0;
        }
    }

    public void decreaseChakra(float chakra) {
        this.chakra -= chakra;

        if (this.chakra >maxChakra) {
            this.chakra = maxChakra;
        }
        if (this.chakra < 0) {
            this.chakra = 0;
        }
    }



    public void toNbt(CompoundTag tag) {
        tag.putFloat("chakra", chakra);
    }

    public void fromNbt(CompoundTag tag) {
        this.chakra = tag.getFloat("chakra");
    }

}


