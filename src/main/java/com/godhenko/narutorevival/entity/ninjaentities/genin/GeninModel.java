package com.godhenko.narutorevival.entity.ninjaentities.genin;

import com.godhenko.narutorevival.NarutoRevival;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class GeninModel extends HumanoidModel<GeninEntity> {

    public static final String BODY = "body";
    public static ModelLayerLocation GENIN_LAYER = new ModelLayerLocation(new ResourceLocation(NarutoRevival.MOD_ID, "genin"),BODY);

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public GeninModel(ModelPart part) {
        super(part);
    }
}
