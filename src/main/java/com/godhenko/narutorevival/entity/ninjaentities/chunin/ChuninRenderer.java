package com.godhenko.narutorevival.entity.ninjaentities.chunin;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.ninjaentities.genin.GeninEntity;
import com.godhenko.narutorevival.entity.ninjaentities.genin.GeninModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class ChuninRenderer extends HumanoidMobRenderer<ChuninEntity, ChuninModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(NarutoRevival.MOD_ID, "textures/entity/chunin.png");


    public ChuninRenderer(EntityRendererProvider.Context context) {
        super(context, new ChuninModel(context.bakeLayer(ChuninModel.CHUNIN_LAYER)), 1f);
    }


    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(ChuninEntity entity) {
        return TEXTURE;
    }
}
