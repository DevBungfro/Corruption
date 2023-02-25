package com.bungfro.corruption.block;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Corruption.MOD_ID);

    public static final RegistryObject<Block> SOUL_CONTAINER = registerBlock("soul_container", () ->
            new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_WOOD = registerBlock("corrupted_wood", () ->
            new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CORRUPTED_LEAVES = registerBlock("corrupted_leaves", () ->
            new Block(BlockBehaviour.Properties.of(Material.LEAVES).strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_LOGS = registerBlock("corrupted_logs", () ->
            new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(6f).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject <T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
