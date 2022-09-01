package com.godhenko.narutorevival.projectile.render;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.projectile.FireballProjectile;
import com.godhenko.narutorevival.projectile.GreatFireballProjectile;
import com.godhenko.narutorevival.projectile.model.FireballModel;
import com.godhenko.narutorevival.projectile.model.GreatFireBallModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class GreatFireballRenderer extends EntityRenderer<GreatFireballProjectile> {
    private static final ResourceLocation FIREBALL_LOCATION = new ResourceLocation(NarutoRevival.NAMESPACE, "textures/entity/fireball.png");
    private final GreatFireBallModel<GreatFireballProjectile> model;

    public GreatFireballRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new GreatFireBallModel<>(pContext.bakeLayer(GreatFireBallModel.LAYER_LOCATION));
    }

    @Override
    public void render(GreatFireballProjectile pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0D, 0.5D, 0.0D);
        this.model.setupAnim(pEntity, pPartialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(FIREBALL_LOCATION));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(GreatFireballProjectile pEntity) {
        return FIREBALL_LOCATION;
    }
}
