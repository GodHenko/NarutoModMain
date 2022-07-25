package com.godhenko.narutorevival.entity.ramenman;

import com.godhenko.narutorevival.NarutoRevival;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class RamenTraderRenderer extends HumanoidMobRenderer<RamenTraderEntity, RamenTraderModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(NarutoRevival.MOD_ID, "textures/entity/thief.png");

    public RamenTraderRenderer(EntityRendererProvider.Context context) {
        super(context, new RamenTraderModel(context.bakeLayer(RamenTraderModel.RAMEN_TRADER_LAYER)), 1f);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(RamenTraderEntity entity) {
        return TEXTURE;
    }
}

