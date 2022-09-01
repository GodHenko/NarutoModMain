package com.godhenko.narutorevival.projectile.render;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.projectile.SharkProjectile;
import com.godhenko.narutorevival.projectile.model.SharkModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SharkRenderer extends EntityRenderer<SharkProjectile> {
    private static final ResourceLocation SHARK_LOCATION = new ResourceLocation(NarutoRevival.NAMESPACE, "textures/entity/shark.png");
    private final SharkModel<SharkProjectile> model;

    public SharkRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SharkModel<>(pContext.bakeLayer(SharkModel.LAYER_LOCATION));
    }

    @Override
    public void render(SharkProjectile pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0D, 1.75D, 0.0D);

        pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - pEntityYaw));
        pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(pEntity.getXRot()));
        pMatrixStack.scale(1.0F, -1.0F, -1.0F);

        this.model.setupAnim(pEntity, pPartialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(SHARK_LOCATION));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SharkProjectile pEntity) {
        return SHARK_LOCATION;
    }
}
