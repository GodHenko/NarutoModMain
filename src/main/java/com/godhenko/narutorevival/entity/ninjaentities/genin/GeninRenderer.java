package com.godhenko.narutorevival.entity.ninjaentities.genin;

import com.godhenko.narutorevival.NarutoRevival;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class GeninRenderer extends HumanoidMobRenderer<GeninEntity, GeninModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(NarutoRevival.MOD_ID, "textures/entity/genin.png");


    public GeninRenderer(EntityRendererProvider.Context context) {
        super(context, new GeninModel(context.bakeLayer(GeninModel.GENIN_LAYER)), 1f);
    }


    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(GeninEntity entity) {
        return TEXTURE;
    }
}
