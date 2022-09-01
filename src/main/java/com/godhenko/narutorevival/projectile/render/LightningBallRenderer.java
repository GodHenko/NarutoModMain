package com.godhenko.narutorevival.projectile.render;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.projectile.LightningBallProjectile;
import com.godhenko.narutorevival.projectile.model.LightningBallModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class LightningBallRenderer extends EntityRenderer<LightningBallProjectile> {
    private static final ResourceLocation LIGHTNING_BALL_LOCATION = new ResourceLocation(NarutoRevival.NAMESPACE, "textures/entity/lightning_ball.png");
    private final LightningBallModel<LightningBallProjectile> model;

    public LightningBallRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new LightningBallModel<>(pContext.bakeLayer(LightningBallModel.LAYER_LOCATION));
    }

    @Override
    public void render(LightningBallProjectile pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0D, 0.5D, 0.0D);
        this.model.setupAnim(pEntity, pPartialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(LIGHTNING_BALL_LOCATION));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(LightningBallProjectile pEntity) {
        return LIGHTNING_BALL_LOCATION;
    }
}
