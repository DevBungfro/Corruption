package com.bungfro.corruption;

import com.bungfro.corruption.block.ModBlocks;
import com.bungfro.corruption.block.entity.ModBlockEntities;
import com.bungfro.corruption.client.screen.ModMenuTypes;
import com.bungfro.corruption.entity.ModEntityTypes;
import com.bungfro.corruption.item.ModCreativeModeTabs;
import com.bungfro.corruption.item.ModItems;
import com.bungfro.corruption.recipe.ModRecipes;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Corruption.MOD_ID)
public class Corruption
{
    public static final String MOD_ID = "corruption";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Corruption()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModEntityTypes.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addToCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void addToCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CorruptedDust);
            event.accept(ModItems.CORRUPTED_STICK);
            event.accept(ModItems.CORRUPTED_CHITIN);

            event.accept(ModItems.CORRUPTED_BRAIN);
            event.accept(ModItems.CORRUPTED_FOREGUT);
            event.accept(ModItems.TOXIC_FLAME_HEART);

        }

        if (event.getTab() == CreativeModeTabs.COMBAT) {
            // Armor
            event.accept(ModItems.TOXIC_FLAME_HELMET_LIGHT);
            event.accept(ModItems.TOXIC_FLAME_CHESTPLATE_LIGHT);
            event.accept(ModItems.TOXIC_FLAME_LEGGINGS_LIGHT);
            event.accept(ModItems.TOXIC_FLAME_BOOTS_LIGHT);

            event.accept(ModItems.TOXIC_FLAME_HELMET_HEAVY);
            event.accept(ModItems.TOXIC_FLAME_CHESTPLATE_HEAVY);
            event.accept(ModItems.TOXIC_FLAME_LEGGINGS_HEAVY);
            event.accept(ModItems.TOXIC_FLAME_BOOTS_HEAVY);
            event.accept(ModItems.TOXIC_FLAME_BOW);


            event.accept(ModItems.LAVA_SNOW_HELMET_HEAVY);
            event.accept(ModItems.LAVA_SNOW_CHESTPLATE_HEAVY);
            event.accept(ModItems.LAVA_SNOW_LEGGINGS_HEAVY);
            event.accept(ModItems.LAVA_SNOW_BOOTS_HEAVY);
            event.accept(ModItems.LAVA_SNOW_BROAD_SWORD);
        }

        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.TOXIC_FLAME_BOW);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            // Corrupted Grass
            event.accept(ModBlocks.CORRUPTED_GRASS_T1);
            event.accept(ModBlocks.CORRUPTED_GRASS_T2);
            event.accept(ModBlocks.CORRUPTED_GRASS_T3);
            event.accept(ModBlocks.CORRUPTED_GRASS_T4);
            event.accept(ModBlocks.CORRUPTED_GRASS_T5);

            event.accept(ModBlocks.CORRUPTED_WOOD);
            event.accept(ModBlocks.SOUL_CONTAINER);
            event.accept(ModBlocks.SOUL_INFUSER);

            event.accept(ModBlocks.CORRUPTED_LEAVES);
            event.accept(ModBlocks.CORRUPTED_LOG);
            event.accept(ModBlocks.STRIPPED_CORRUPTED_LOG);
            event.accept(ModBlocks.STRIPPED_CORRUPTED_WOOD);
            event.accept(ModBlocks.CORRUPTED_WOOD);
            event.accept(ModBlocks.CORRUPTED_PLANKS);

            event.accept(ModBlocks.WORKPLACE_OF_CORRUPTION);
        }

        if (event.getTab() == ModCreativeModeTabs.CorruptionTab) {
            // Corrupted Grass
            event.accept(ModBlocks.CORRUPTED_GRASS_T1);
            event.accept(ModBlocks.CORRUPTED_GRASS_T2);
            event.accept(ModBlocks.CORRUPTED_GRASS_T3);
            event.accept(ModBlocks.CORRUPTED_GRASS_T4);
            event.accept(ModBlocks.CORRUPTED_GRASS_T5);
            // CG End

            event.accept(ModBlocks.SOUL_CONTAINER);
            event.accept(ModBlocks.SOUL_INFUSER);
            event.accept(ModItems.CorruptedDust);
            event.accept(ModBlocks.WORKPLACE_OF_CORRUPTION);
            event.accept(ModItems.CORRUPTED_STICK);

            event.accept(ModItems.CORRUPTED_CHITIN);
            event.accept(ModItems.CORRUPTED_BRAIN);
            event.accept(ModItems.CORRUPTED_FOREGUT);
            event.accept(ModItems.TOXIC_FLAME_HEART);


            event.accept(ModBlocks.CORRUPTED_LEAVES);
            event.accept(ModBlocks.CORRUPTED_LOG);
            event.accept(ModBlocks.STRIPPED_CORRUPTED_LOG);
            event.accept(ModBlocks.STRIPPED_CORRUPTED_WOOD);
            event.accept(ModBlocks.CORRUPTED_WOOD);
            event.accept(ModBlocks.CORRUPTED_PLANKS);

            // Armor
            event.accept(ModItems.TOXIC_FLAME_HELMET_LIGHT);
            event.accept(ModItems.TOXIC_FLAME_CHESTPLATE_LIGHT);
            event.accept(ModItems.TOXIC_FLAME_LEGGINGS_LIGHT);
            event.accept(ModItems.TOXIC_FLAME_BOOTS_LIGHT);

            event.accept(ModItems.TOXIC_FLAME_HELMET_HEAVY);
            event.accept(ModItems.TOXIC_FLAME_CHESTPLATE_HEAVY);
            event.accept(ModItems.TOXIC_FLAME_LEGGINGS_HEAVY);
            event.accept(ModItems.TOXIC_FLAME_BOOTS_HEAVY);

            event.accept(ModItems.LAVA_SNOW_HELMET_HEAVY);
            event.accept(ModItems.LAVA_SNOW_CHESTPLATE_HEAVY);
            event.accept(ModItems.LAVA_SNOW_LEGGINGS_HEAVY);
            event.accept(ModItems.LAVA_SNOW_BOOTS_HEAVY);

            // Tools
            event.accept(ModItems.TOXIC_FLAME_BOW);
            event.accept(ModItems.LAVA_SNOW_BROAD_SWORD);
        }
    }

}
