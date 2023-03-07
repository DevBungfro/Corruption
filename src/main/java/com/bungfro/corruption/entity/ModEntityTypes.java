package com.bungfro.corruption.entity;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.entity.custom.BulculiterEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Corruption.MOD_ID);

    public static final RegistryObject<EntityType<BulculiterEntity>> BULCULITER =
            ENTITY_TYPES.register("bulculiter",
                    () -> EntityType.Builder.of(BulculiterEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(Corruption.MOD_ID, "bulculiter").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}