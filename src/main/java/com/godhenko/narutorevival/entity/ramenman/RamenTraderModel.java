package com.godhenko.narutorevival.entity.ramenman;

import com.godhenko.narutorevival.NarutoRevival;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class RamenTraderModel extends HumanoidModel<RamenTraderEntity> {


    public static final String BODY = "body";

    public static ModelLayerLocation RAMEN_TRADER_LAYER = new ModelLayerLocation(new ResourceLocation(NarutoRevival.MOD_ID, "textures/entity/ramen_trader"), BODY);

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public RamenTraderModel(ModelPart part) {
        super(part);
    }
}
