package com.godhenko.narutomod.entity.renderers;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.entity.custom.RamenTraderEntity;
import com.godhenko.narutomod.entity.models.RamenTraderModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RamenTraderRenderer extends GeoEntityRenderer<RamenTraderEntity> {
    public RamenTraderRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RamenTraderModel());
        this.shadowRadius = 0.3f;
    }


    @Override
    public ResourceLocation getTextureLocation(RamenTraderEntity instance) {
        return new ResourceLocation(NarutoMod.MOD_ID, "textures/entity/raccoon/raccoon.png");
    }

    @Override
    public RenderType getRenderType(RamenTraderEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
