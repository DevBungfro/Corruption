package com.bungfro.corruption.block.entity;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Corruption.MOD_ID);

    public static final RegistryObject<BlockEntityType<WorkplaceOfCorruptionBlockEntity>> WORKPLACE_OF_CORRUPTION =
            BLOCK_ENTITIES.register("workplace_of_corruption", () ->
                    BlockEntityType.Builder.of(WorkplaceOfCorruptionBlockEntity::new,
                            ModBlocks.WORKPLACE_OF_CORRUPTION.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}