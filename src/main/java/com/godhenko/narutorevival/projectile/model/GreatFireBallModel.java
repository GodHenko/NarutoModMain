package com.godhenko.narutorevival.projectile.model;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.projectile.GreatFireballProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class GreatFireBallModel<T extends GreatFireballProjectile> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(NarutoRevival.NAMESPACE, "greatfireball"), "main");
	private final ModelPart bb_main1;

	public GreatFireBallModel(ModelPart root) {
		this.bb_main1 = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 4).addBox(-24.0F, -48.0F, -24.0F, 49.0F, 48.0F, 48.0F, new CubeDeformation(20.0F))
				.texOffs(0, 4).addBox(-31.0F, -44.0F, -18.0F, 7.0F, 40.0F, 35.0F, new CubeDeformation(20.0F))
				.texOffs(0, 4).addBox(25.0F, -44.0F, -18.0F, 7.0F, 40.0F, 35.0F, new CubeDeformation(20.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 4).addBox(-7.0F, -20.0F, -18.0F, 7.0F, 40.0F, 35.0F, new CubeDeformation(20.0F))
				.texOffs(0, 4).addBox(48.0F, -20.0F, -18.0F, 7.0F, 40.0F, 35.0F, new CubeDeformation(20.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 4).addBox(24.0F, -44.0F, -18.0F, 7.0F, 40.0F, 35.0F, new CubeDeformation(20.0F))
				.texOffs(0, 4).addBox(-31.0F, -44.0F, -18.0F, 7.0F, 40.0F, 35.0F, new CubeDeformation(20.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}