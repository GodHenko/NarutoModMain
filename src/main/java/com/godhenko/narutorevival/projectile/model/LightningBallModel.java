package com.godhenko.narutorevival.projectile.model;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.projectile.LightningBallProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings

public class LightningBallModel<T extends LightningBallProjectile> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(NarutoRevival.NAMESPACE, "lightning_ball"), "main");

    private final ModelPart bb_main;

    public LightningBallModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -30.0F, -14.0F, 28.0F, 28.0F, 28.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(14.0F, -28.5F, -12.5F, 2.0F, 25.0F, 25.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-16.0F, -28.5F, -12.5F, 2.0F, 25.0F, 25.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.5F, -28.5F, 14.0F, 25.0F, 25.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.5F, -28.5F, -16.0F, 25.0F, 25.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.5F, -32.0F, -12.5F, 25.0F, 2.0F, 25.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.5F, -2.0F, -12.5F, 25.0F, 2.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}
