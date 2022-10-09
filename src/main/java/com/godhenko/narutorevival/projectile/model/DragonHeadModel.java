package com.godhenko.narutorevival.projectile.model;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.godhenko.narutorevival.projectile.FireDragonProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DragonHeadModel<T extends FireDragonProjectile> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "fire_dragon"), "main");
	private final ModelPart neck;

	public DragonHeadModel(ModelPart root) {
		this.neck = root.getChild("neck");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -41.6472F, -33.9741F, 8.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 46.0F, 37.0F));

		PartDefinition cube_r1 = neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 42).addBox(-3.99F, -4.99F, -4.99F, 7.0F, 5.0F, 9.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -37.6472F, -30.1741F, -0.3927F, 0.0F, 0.0F));

		PartDefinition h_head = neck.addOrReplaceChild("h_head", CubeListBuilder.create().texOffs(60, 55).addBox(3.9045F, 0.95F, -14.95F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(56, 49).addBox(-3.9045F, 0.95F, -14.95F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(105, 23).addBox(-3.0F, 0.5F, -18.55F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 86).addBox(-4.8995F, -5.05F, -8.95F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 16).addBox(-3.9045F, -3.05F, -14.95F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0001F))
		.texOffs(0, 0).addBox(-4.6045F, -1.05F, -9.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 56).addBox(-3.0F, -5.05F, -8.95F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(40, 81).addBox(-1.0905F, -5.05F, -4.95F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(79, 55).addBox(-4.9095F, -5.05F, -4.95F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 85).addBox(-1.0905F, -5.05F, -8.95F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(2.6045F, -1.05F, -9.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 52).addBox(-0.0955F, -3.05F, -14.95F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0001F))
		.texOffs(92, 13).addBox(-2.0F, -1.5F, -19.15F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0001F)), PartPose.offset(0.0F, -37.0F, -31.0F));

		PartDefinition cube_r2 = h_head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(101, 35).addBox(-3.1F, -2.1F, -1.1F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.09F)), PartPose.offsetAndRotation(1.0F, -2.55F, -19.3F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r3 = h_head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(92, 88).addBox(-3.05F, -2.0F, 0.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.6718F, -2.8F, -17.8F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r4 = h_head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(106, 48).addBox(-2.8F, -1.75F, 3.15F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.6718F, -3.2F, -21.8F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r5 = h_head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(91, 70).addBox(3.05F, 1.55F, 4.65F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1455F, -2.6F, -17.6F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r6 = h_head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(104, 9).addBox(1.55F, -2.0F, -5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(3.55F, 2.0F, -5.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0545F, -1.05F, -12.75F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r7 = h_head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(63, 91).addBox(-5.05F, 1.55F, 4.65F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(90, 80).addBox(-5.05F, 1.55F, 4.65F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1455F, -2.6F, -17.6F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r8 = h_head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(102, 0).addBox(-3.55F, -2.0F, -5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.55F, 2.0F, -5.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0545F, -1.05F, -12.75F, 0.0F, -0.3927F, 0.0F));

		PartDefinition h_horn_left = h_head.addOrReplaceChild("h_horn_left", CubeListBuilder.create().texOffs(0, 92).addBox(1.2815F, -2.742F, -1.552F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(14, 104).addBox(2.1815F, -10.642F, 2.348F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(5.739F, -3.0492F, -2.1897F, -1.1726F, -0.7953F, -3.0778F));

		PartDefinition cube_r9 = h_horn_left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(55, 45).addBox(4.8998F, -1.7617F, -32.2572F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-2.5183F, -22.8865F, 32.0395F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r10 = h_horn_left.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(105, 93).addBox(4.6998F, 23.0319F, -13.4368F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-2.7183F, -15.2865F, 28.8395F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r11 = h_horn_left.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 100).addBox(4.2998F, 19.0151F, -22.8337F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.7183F, -15.2865F, 28.8395F, -0.3927F, 0.0F, 0.0F));

		PartDefinition h_horn_left2 = h_head.addOrReplaceChild("h_horn_left2", CubeListBuilder.create().texOffs(47, 91).addBox(-5.6815F, -2.742F, -1.552F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(80, 101).addBox(-5.1815F, -10.642F, 2.348F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-5.739F, -3.0492F, -2.1897F, -1.1726F, 0.7953F, 3.0778F));

		PartDefinition cube_r12 = h_horn_left2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 52).addBox(-7.4998F, -1.7617F, -32.2572F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(2.5183F, -22.8865F, 32.0395F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r13 = h_horn_left2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(104, 85).addBox(-8.0998F, 23.0319F, -13.4368F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.7183F, -15.2865F, 28.8395F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r14 = h_horn_left2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(30, 99).addBox(-8.0998F, 19.0151F, -22.8337F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(2.7183F, -15.2865F, 28.8395F, -0.3927F, 0.0F, 0.0F));

		PartDefinition h_horn_left3 = h_head.addOrReplaceChild("h_horn_left3", CubeListBuilder.create().texOffs(74, 45).addBox(-2.0352F, -3.9873F, -3.1655F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(95, 51).addBox(-1.6352F, -12.6873F, 1.7345F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 52).addBox(-1.5352F, -18.5663F, -4.7068F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-0.4F))
		.texOffs(40, 72).addBox(-1.0352F, -14.5546F, -13.9287F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.11F))
		.texOffs(101, 70).addBox(-0.4352F, -14.0546F, -16.9287F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(41, 0).addBox(-0.4352F, -14.0546F, -19.9287F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.439F, -5.5492F, -1.1897F, -0.3917F, 0.2589F, 0.7328F));

		PartDefinition cube_r15 = h_horn_left3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(89, 19).addBox(-2.0F, -0.7F, -8.7F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.9648F, -16.8663F, -2.2068F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r16 = h_horn_left3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(100, 78).addBox(-1.975F, -2.3F, -4.6F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9648F, -16.8663F, -2.2068F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r17 = h_horn_left3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(94, 27).addBox(-2.4F, -5.6F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.8648F, -13.3351F, 2.4719F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r18 = h_horn_left3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(94, 43).addBox(-2.5F, -5.7F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.8648F, -10.1873F, 3.2345F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r19 = h_horn_left3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(26, 0).addBox(-2.5F, -5.8F, -1.8F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.4648F, -5.8873F, -0.6655F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r20 = h_horn_left3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(74, 25).addBox(-2.5F, -2.1F, -1.3F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4648F, -5.8873F, -0.6655F, -0.3927F, 0.0F, 0.0F));

		PartDefinition h_horn_right4 = h_head.addOrReplaceChild("h_horn_right4", CubeListBuilder.create().texOffs(76, 76).addBox(-2.8928F, -2.6748F, -2.6439F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(89, 96).addBox(-2.2928F, -11.3748F, 2.2561F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(83, 35).addBox(-2.3928F, -17.2538F, -4.1853F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-0.4F))
		.texOffs(91, 5).addBox(-1.8928F, -13.242F, -13.4072F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.11F))
		.texOffs(104, 17).addBox(-1.4928F, -12.742F, -16.4072F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(48, 14).addBox(-1.4928F, -12.742F, -19.4072F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.439F, -6.5492F, -1.1897F, -0.3917F, -0.2589F, -0.7328F));

		PartDefinition cube_r21 = h_horn_right4.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(31, 91).addBox(-1.0F, -0.7F, -8.7F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.8928F, -15.5538F, -1.6853F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r22 = h_horn_right4.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(99, 100).addBox(-1.025F, -2.3F, -4.6F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8928F, -15.5538F, -1.6853F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r23 = h_horn_right4.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(16, 96).addBox(-1.6F, -5.6F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.7928F, -12.0226F, 2.9934F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r24 = h_horn_right4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(96, 62).addBox(-1.5F, -5.7F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.7928F, -8.8748F, 3.7561F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r25 = h_horn_right4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(76, 0).addBox(-2.5F, -5.8F, -1.8F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.3928F, -4.5748F, -0.1439F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r26 = h_horn_right4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(76, 66).addBox(-2.5F, -2.1F, -1.3F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.3928F, -4.5748F, -0.1439F, -0.3927F, 0.0F, 0.0F));

		PartDefinition h_front = h_head.addOrReplaceChild("h_front", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.149F, -3.0024F, -11.7488F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r27 = h_front.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 36).addBox(-13.169F, -13.169F, -32.3718F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.149F, 15.5022F, 31.2091F, 0.0F, 0.0F, 0.7854F));

		PartDefinition h_machoire = h_head.addOrReplaceChild("h_machoire", CubeListBuilder.create().texOffs(26, 107).addBox(-2.1891F, -1.6909F, -16.5717F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(80, 86).addBox(-2.1891F, -1.5909F, -15.7717F, 4.0F, 11.0F, 2.0F, new CubeDeformation(-0.01F))
		.texOffs(56, 99).addBox(2.2553F, -0.6409F, -7.3575F, 2.0F, 6.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(48, 30).addBox(-4.1891F, -6.6909F, -14.9717F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(20, 56).addBox(-4.0434F, -6.6409F, -15.3575F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(40, 56).addBox(3.6652F, -6.6409F, -15.3575F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-4.1891F, -0.6409F, -15.3575F, 8.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(20, 72).addBox(-3.1891F, -0.6909F, -14.9717F, 6.0F, 10.0F, 4.0F, new CubeDeformation(0.01F))
		.texOffs(72, 10).addBox(-3.1891F, -1.4909F, -12.1717F, 6.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 72).addBox(-3.1891F, -2.0909F, -8.1717F, 6.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 71).addBox(-3.1891F, -3.0909F, -4.9717F, 6.0F, 10.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(44, 99).addBox(-4.6335F, -0.6409F, -7.3575F, 2.0F, 6.0F, 4.0F, new CubeDeformation(-0.01F))
		.texOffs(48, 0).addBox(-4.9891F, -7.9381F, -2.7458F, 9.0F, 9.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.1891F, 1.8353F, -3.5354F, 0.1047F, 0.0F, 0.0F));

		PartDefinition cube_r28 = h_machoire.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(26, 26).addBox(-7.3997F, -3.7356F, -36.7848F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(26, 10).addBox(-4.0234F, -3.7356F, -36.7848F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5224F, 15.3258F, 27.3426F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r29 = h_machoire.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 36).addBox(-12.4649F, -16.0267F, -26.0943F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5321F, 15.5258F, 17.9426F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r30 = h_machoire.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(20, 86).addBox(-1.0F, -5.5435F, -33.5707F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-1.1891F, 18.3258F, 13.1426F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r31 = h_machoire.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(68, 99).addBox(10.4649F, -16.0267F, -26.0943F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1539F, 15.5258F, 17.9426F, 0.0F, 0.3927F, 0.0F));

		PartDefinition h_eye_lash_right = h_head.addOrReplaceChild("h_eye_lash_right", CubeListBuilder.create().texOffs(55, 47).addBox(-2.5813F, -3.2979F, -4.6512F, 5.0F, 3.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.696F, -2.712F, -8.3975F, 0.3866F, 0.2644F, -0.2322F));

		PartDefinition cube_r32 = h_eye_lash_right.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 56).addBox(7.0797F, -15.2366F, -33.5354F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5635F, 10.7118F, 28.6842F, 0.0F, 0.0F, 0.3927F));

		PartDefinition h_eye_lash_left = h_head.addOrReplaceChild("h_eye_lash_left", CubeListBuilder.create().texOffs(55, 33).addBox(-3.0187F, -3.2979F, -4.6512F, 5.0F, 3.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.696F, -2.712F, -8.3975F, 0.3866F, -0.2644F, 0.2322F));

		PartDefinition cube_r33 = h_eye_lash_left.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(20, 32).addBox(-7.0797F, -15.2366F, -33.5354F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5635F, 10.7118F, 28.6842F, 0.0F, 0.0F, -0.3927F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}