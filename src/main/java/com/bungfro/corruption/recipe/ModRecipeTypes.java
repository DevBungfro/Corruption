package com.bungfro.corruption.recipe;

import com.bungfro.corruption.Corruption;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Corruption.MOD_ID);

    private static RecipeType<com.bungfro.corruption.recipe.WorkplaceOfCorruptionRecipe> WorkplaceOfCorruptionRecipe;
    public static final RegistryObject<RecipeType<WorkplaceOfCorruptionRecipe>> WORKPLACE_OF_CORRUPTION =
            RECIPE_TYPES.register("workplace", () -> WorkplaceOfCorruptionRecipe);
    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }

}
