package com.godhenko.narutomod.entity.models;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.entity.custom.RamenTraderEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RamenTraderModel extends AnimatedGeoModel<RamenTraderEntity> {
    @Override
    public ResourceLocation getModelLocation(RamenTraderEntity object) {
        return new ResourceLocation(NarutoMod.MOD_ID, "geo/raccoon.geo.json");    }

    @Override
    public ResourceLocation getTextureLocation(RamenTraderEntity object) {
        return new ResourceLocation(NarutoMod.MOD_ID, "textures/entity/raccoon/raccoon.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RamenTraderEntity animatable) {
        return new ResourceLocation(NarutoMod.MOD_ID, "animations/raccoon.animation.json");
    }
}
