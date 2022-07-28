package com.godhenko.narutorevival.entity.ninjaentities.jonin;

import com.godhenko.narutorevival.NarutoRevival;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class JoninRenderer extends HumanoidMobRenderer<JoninEntity, JoninModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(NarutoRevival.MOD_ID, "textures/entity/jonin.png");


    public JoninRenderer(EntityRendererProvider.Context context) {
        super(context, new JoninModel(context.bakeLayer(JoninModel.JONIN_LAYER)), 1f);
    }


    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(JoninEntity entity) {
        return TEXTURE;
    }
}
