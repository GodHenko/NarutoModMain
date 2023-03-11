package com.godhenko.narutorevival.projectile.render;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.projectile.OverloadProjectile;
import com.godhenko.narutorevival.projectile.model.OverloadModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class OverloadRenderer extends EntityRenderer<OverloadProjectile> {
    private static final ResourceLocation OVERLOAD_LOCATION = new ResourceLocation(NarutoRevival.NAMESPACE, "textures/entity/overload.png");
    private final OverloadModel<OverloadProjectile> model;

    public OverloadRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new OverloadModel<>(pContext.bakeLayer(OverloadModel.LAYER_LOCATION));
    }

    @Override
    public void render(OverloadProjectile pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0D, 1D, 0.0D);

        pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(pEntity.getXRot()));
        pMatrixStack.mulPose(Vector3f.YP.rotationDegrees((float) (Math.sin(pEntity.tickCount) * 180f)));
        pMatrixStack.scale(1.0F, -1.0F, -1.0F);

        this.model.setupAnim(pEntity, pPartialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(OVERLOAD_LOCATION));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(OverloadProjectile pEntity) {
        return OVERLOAD_LOCATION;
    }
}
