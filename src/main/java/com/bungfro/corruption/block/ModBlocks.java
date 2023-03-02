package com.bungfro.corruption.block;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.block.custom.ModFlammableRotatedPillarBlock;
import com.bungfro.corruption.block.custom.WorkplaceOfCorruptionBlock;
import com.bungfro.corruption.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
    public static final RegistryObject<Block> SOUL_INFUSER = registerBlock("soul_infuser", () ->
            new Block(BlockBehaviour.Properties.of(Material.PISTON).strength(6f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> WORKPLACE_OF_CORRUPTION = registerBlock("workplace_of_corruption", () ->
            new WorkplaceOfCorruptionBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(4F).sound(SoundType.METAL)));


    // Corrupted Grass Tiers
    public static final RegistryObject<Block> CORRUPTED_GRASS_T1 = registerBlock("corrupted_grass_t1", () ->
            new Block(BlockBehaviour.Properties.of(Material.GRASS).strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_GRASS_T2 = registerBlock("corrupted_grass_t2", () ->
            new Block(BlockBehaviour.Properties.of(Material.GRASS).strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_GRASS_T3 = registerBlock("corrupted_grass_t3", () ->
            new Block(BlockBehaviour.Properties.of(Material.GRASS).strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_GRASS_T4 = registerBlock("corrupted_grass_t4", () ->
            new Block(BlockBehaviour.Properties.of(Material.GRASS).strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_GRASS_T5 = registerBlock("corrupted_grass_t5", () ->
            new Block(BlockBehaviour.Properties.of(Material.GRASS).strength(2f).requiresCorrectToolForDrops()));

    // Corrupted Wood / Planks / Leaves/ ETC
    public static final RegistryObject<Block> CORRUPTED_LOG = registerBlock("corrupted_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CORRUPTED_WOOD = registerBlock("corrupted_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STRIPPED_CORRUPTED_LOG = registerBlock("stripped_corrupted_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STRIPPED_CORRUPTED_WOOD = registerBlock("stripped_corrupted_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_PLANKS = registerBlock("corrupted_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> CORRUPTED_LEAVES = registerBlock("corrupted_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });
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
