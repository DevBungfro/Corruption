package com.bungfro.corruption.entity.client;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.entity.custom.BulculiterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BulculiterModel extends GeoModel<BulculiterEntity> {
    @Override
    public ResourceLocation getModelResource(BulculiterEntity object) {
        return new ResourceLocation(Corruption.MOD_ID, "geo/bulculiter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BulculiterEntity object) {
        return new ResourceLocation(Corruption.MOD_ID, "textures/entity/bulculiter_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BulculiterEntity animatable) {
        return new ResourceLocation(Corruption.MOD_ID, "animations/bulculiter.animation.json");
    }
}
