package com.bungfro.corruption.entity.client;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.entity.custom.BulculiterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class BulculiterRenderer extends GeoEntityRenderer<BulculiterEntity> {
    public BulculiterRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BulculiterModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(BulculiterEntity instance) {
        return new ResourceLocation(Corruption.MOD_ID, "textures/entity/chomper_texture.png");
    }

    @Override
    public RenderType getRenderType(BulculiterEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
