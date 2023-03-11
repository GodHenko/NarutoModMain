package com.godhenko.narutorevival.projectile.render;

import com.godhenko.narutorevival.NarutoRevival;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Items;

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings

public class EarthArmorModel<T extends AbstractClientPlayer> extends HumanoidModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(NarutoRevival.NAMESPACE, "earth_armor"), "main");

    private final ModelPart right_leg;
    private final ModelPart left_leg;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart hat;

    public EarthArmorModel(ModelPart root) {
        super(root);
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.hat = root.getChild("hat");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = createMesh(new CubeDeformation(0.5f), 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_leg = partdefinition.getChild("right_leg");
        PartDefinition left_leg = partdefinition.getChild("left_leg");
        PartDefinition head = partdefinition.getChild("head");
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition left_arm = partdefinition.getChild("left_arm");
        PartDefinition right_arm = partdefinition.getChild("right_arm");

        PartDefinition right_leg_cubes = right_leg.addOrReplaceChild("right_leg_cubes", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
        PartDefinition left_leg_cubes = left_leg.addOrReplaceChild("left_leg_cubes", CubeListBuilder.create().mirror(), PartPose.offset(0.0F, 12.0F, 0.0F));
        PartDefinition head_cubes = head.addOrReplaceChild("head_cubes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body_cubes = body.addOrReplaceChild("body_cubes", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
        PartDefinition left_arm_cubes = left_arm.addOrReplaceChild("left_arm_cubes", CubeListBuilder.create().mirror(), PartPose.offset(2.0F, 8.0F, 0.0F));
        PartDefinition right_arm_cubes = right_arm.addOrReplaceChild("right_arm_cubes", CubeListBuilder.create(), PartPose.offset(-2.0F, 8.0F, 0.0F));

        head_cubes.addOrReplaceChild("head_cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, -0.3491F, 0.3927F, -0.2618F));
        head_cubes.addOrReplaceChild("head_cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -4.0F, -0.3491F, 0.3927F, -0.2618F));
        head_cubes.addOrReplaceChild("head_cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(4.0F, -5.0F, -4.0F, -0.3491F, 0.5672F, -0.2618F));

        body_cubes.addOrReplaceChild("body_cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(1.0F, -6.0F, 1.0F, -0.7854F, -0.5672F, -0.9163F));
        body_cubes.addOrReplaceChild("body_cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(3.0F, -8.0F, -4.0F, -0.6981F, -0.1745F, -0.6545F));
        body_cubes.addOrReplaceChild("body_cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -3.0F, -0.2182F, 0.3491F, -0.1745F));

        right_arm_cubes.addOrReplaceChild("right_arm_cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(3.0F, -8.0F, 0.0F, -0.3927F, -0.3927F, -0.2182F));
        right_arm_cubes.addOrReplaceChild("right_arm_cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(3.0F, 0.0F, -2.0F, 0.0436F, 0.3927F, -0.3491F));

        left_arm_cubes.addOrReplaceChild("left_arm_cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, -0.1745F, -0.3054F));
        left_arm_cubes.addOrReplaceChild("left_arm_cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -11.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, -0.1309F, -0.2618F));

        right_leg_cubes.addOrReplaceChild("right_leg_cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 1.0F, 0.4363F, 0.0F, 0.2182F));
        right_leg_cubes.addOrReplaceChild("right_leg_cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(2.0F, -7.0F, -3.0F, 0.2618F, 0.3491F, -0.2182F));

        left_leg_cubes.addOrReplaceChild("left_leg_cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-1.0F, -9.0F, 2.0F, 0.4363F, -0.1309F, 0.1309F));
        left_leg_cubes.addOrReplaceChild("left_leg_cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(2.0F, -3.0F, -3.0F, 0.3054F, 0.3491F, 0.1309F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void setupAnim(T pEntity, float pPartialTick, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        crouching = pEntity.isCrouching();
        attackTime = pEntity.getAttackAnim(pPartialTick);
        swimAmount = pEntity.getSwimAmount(pPartialTick);
        riding = pEntity.isPassenger();

        leftArmPose = ArmPose.EMPTY;
        rightArmPose = ArmPose.EMPTY;

        if (pEntity.hasItemInSlot(EquipmentSlot.MAINHAND)) {
            if (pEntity.getMainArm() == HumanoidArm.LEFT) {
                leftArmPose = ArmPose.ITEM;
            } else {
                rightArmPose = ArmPose.ITEM;
            }
        }

        if (pEntity.hasItemInSlot(EquipmentSlot.OFFHAND)) {
            if (pEntity.getMainArm() == HumanoidArm.LEFT) {
                rightArmPose = ArmPose.ITEM;
            } else {
                leftArmPose = ArmPose.ITEM;
            }
        }

        if (pEntity.isUsingItem() && pEntity.getUseItem().is(Items.SPYGLASS)) {
            if (pEntity.getUsedItemHand() == InteractionHand.MAIN_HAND) {
                if(pEntity.getMainArm() == HumanoidArm.LEFT) {
                    leftArmPose = ArmPose.SPYGLASS;
                } else {
                    rightArmPose = ArmPose.SPYGLASS;
                }
            } else {
                if(pEntity.getMainArm() == HumanoidArm.LEFT) {
                    rightArmPose = ArmPose.SPYGLASS;
                } else {
                    leftArmPose = ArmPose.SPYGLASS;
                }
            }
        }

        if (pEntity.isHolding(Items.CROSSBOW)) {
            if (pEntity.isUsingItem()) {
                leftArmPose = ArmPose.CROSSBOW_CHARGE;
                rightArmPose = ArmPose.CROSSBOW_CHARGE;
            } else if (CrossbowItem.isCharged(pEntity.getMainHandItem())) {
                leftArmPose = ArmPose.CROSSBOW_HOLD;
                rightArmPose = ArmPose.CROSSBOW_HOLD;
            } else if (CrossbowItem.isCharged(pEntity.getOffhandItem())) {
                leftArmPose = ArmPose.CROSSBOW_HOLD;
                rightArmPose = ArmPose.CROSSBOW_HOLD;
            }
        }

        if (pEntity.isHolding(Items.BOW) && pEntity.isUsingItem()) {
            leftArmPose = ArmPose.BOW_AND_ARROW;
            rightArmPose = ArmPose.BOW_AND_ARROW;
        }

        if (pEntity.isUsingItem() && pEntity.getUseItem().is(Items.TRIDENT)) {
            if (pEntity.getUsedItemHand() == InteractionHand.MAIN_HAND) {
                if(pEntity.getMainArm() == HumanoidArm.LEFT) {
                    leftArmPose = ArmPose.THROW_SPEAR;
                } else {
                    rightArmPose = ArmPose.THROW_SPEAR;
                }
            } else {
                if(pEntity.getMainArm() == HumanoidArm.LEFT) {
                    rightArmPose = ArmPose.THROW_SPEAR;
                } else {
                    leftArmPose = ArmPose.THROW_SPEAR;
                }
            }
        }

        super.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}
