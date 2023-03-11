package com.godhenko.narutorevival.projectile.model;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.projectile.IceNeedlesProjectile;
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

public class IceNeedlesModel<T extends IceNeedlesProjectile> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(NarutoRevival.NAMESPACE, "ice_needles"), "main");

    private final ModelPart bb_main;

    public IceNeedlesModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(20, 9).addBox(0.0F, -5.0F, 0.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-3.0F, -10.0F, -2.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(10, 19).addBox(4.0F, -7.0F, -5.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-6.0F, -1.0F, -2.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(10, 10).addBox(3.0F, -12.0F, -5.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(10, 1).addBox(-6.0F, -5.0F, -6.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(4.9F, -1.0F, -7.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.1F, -14.0F, 0.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

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
