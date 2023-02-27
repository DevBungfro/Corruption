package com.bungfro.corruption.client.renderer;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.client.models.BulculiterEntityModel;
import com.bungfro.corruption.entity.entities.BulculiterEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BulculiterEntityRenderer extends MobRenderer<BulculiterEntity, BulculiterEntityModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(Corruption.MOD_ID, "textures/entities/bulculiter_entity.png");
    public BulculiterEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BulculiterEntityModel(pContext.bakeLayer(BulculiterEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BulculiterEntity pEntity) {
        return TEXTURE;
    }
}
