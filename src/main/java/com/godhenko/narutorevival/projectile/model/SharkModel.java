package com.godhenko.narutorevival.projectile.model;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.projectile.SharkProjectile;
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

public class SharkModel<T extends SharkProjectile> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(NarutoRevival.NAMESPACE, "shark"), "main");

    private final ModelPart bb_main;

    public SharkModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -7.0F, 8.0F, 7.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-2.5F, -5.0F, 10.0F, 5.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition tail_fin_r1 = bb_main.addOrReplaceChild("tail_fin_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.25F, 18.25F, -2.3126F, 0.0F, 0.0F));

        PartDefinition body_r1 = bb_main.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(24, 31).addBox(-3.0F, -0.75F, -7.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -7.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition tail_fin_r2 = bb_main.addOrReplaceChild("tail_fin_r2", CubeListBuilder.create().texOffs(21, 24).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.25F, 18.25F, -0.829F, 0.0F, 0.0F));

        PartDefinition back_fin_r1 = bb_main.addOrReplaceChild("back_fin_r1", CubeListBuilder.create().texOffs(16, 39).addBox(-0.5F, -4.0F, -4.5F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 5.5F, -0.3054F, 0.0F, 0.0F));

        PartDefinition left_fin_r1 = bb_main.addOrReplaceChild("left_fin_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -1.5F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -5.0F, 1.5F, -1.5708F, 0.0F, -1.2654F));

        PartDefinition right_fin_r1 = bb_main.addOrReplaceChild("right_fin_r1", CubeListBuilder.create().texOffs(0, 39).addBox(0.0F, -1.0F, -1.5F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 1.5F, -1.5708F, 0.0F, 1.2654F));

        PartDefinition body_r2 = bb_main.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(33, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.0873F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
