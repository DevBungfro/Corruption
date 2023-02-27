package com.bungfro.corruption.entity;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.entity.entities.BulculiterEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Corruption.MOD_ID);

    public static final RegistryObject<EntityType<BulculiterEntity>> BULCULITER = ENTITIES.register("bulculiter",
            () -> EntityType.Builder.of(BulculiterEntity::new, MobCategory.MONSTER).build(Corruption.MOD_ID + ":bulculiter"));
}
