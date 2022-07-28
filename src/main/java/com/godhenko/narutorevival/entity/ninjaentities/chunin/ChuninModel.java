package com.godhenko.narutorevival.entity.ninjaentities.chunin;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.entity.ninjaentities.genin.GeninEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class ChuninModel extends HumanoidModel<ChuninEntity> {

    public static final String BODY = "body";
    public static ModelLayerLocation CHUNIN_LAYER = new ModelLayerLocation(new ResourceLocation(NarutoRevival.MOD_ID, "chunin"),BODY);

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public ChuninModel(ModelPart part) {
        super(part);
    }
}
