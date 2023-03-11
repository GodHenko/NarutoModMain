package com.godhenko.narutorevival.projectile.render;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.jutsus.client.ClientEarthArmorPlayers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class EarthArmorLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    private static final ResourceLocation EARTH_ARMOR_LOCATION = new ResourceLocation(NarutoRevival.NAMESPACE, "textures/entity/earth_armor.png");
    private final EarthArmorModel<AbstractClientPlayer> model;

    public EarthArmorLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> pRenderer) {
        super(pRenderer);
        model = new EarthArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(EarthArmorModel.LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, AbstractClientPlayer pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (ClientEarthArmorPlayers.get(pLivingEntity.getStringUUID()) && pLivingEntity.isSkinLoaded() && !pLivingEntity.isInvisible()) {
            float f = Mth.lerp(pPartialTick, pLivingEntity.yRotO, pLivingEntity.getYRot()) - Mth.lerp(pPartialTick, pLivingEntity.yBodyRotO, pLivingEntity.yBodyRot);
            float f1 = Mth.lerp(pPartialTick, pLivingEntity.xRotO, pLivingEntity.getXRot());

            VertexConsumer vertexConsumer = pBuffer.getBuffer(model.renderType(EARTH_ARMOR_LOCATION));

            pPoseStack.pushPose();
            model.setupAnim(pLivingEntity, pPartialTick, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
            model.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
            pPoseStack.popPose();
        }
    }
}
