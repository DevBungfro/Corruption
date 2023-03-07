package com.bungfro.corruption.integration;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.recipe.WorkplaceOfCorruptionRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEICorruptionPlugin implements IModPlugin {

    public static RecipeType<WorkplaceOfCorruptionRecipe> WORKPLACE_TYPE =
            new RecipeType<>(WorkplaceOfCorruptionRecipeCategory.UID, WorkplaceOfCorruptionRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Corruption.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                WorkplaceOfCorruptionRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<WorkplaceOfCorruptionRecipe> workplaceOfCorruptionRecipes = rm.getAllRecipesFor(WorkplaceOfCorruptionRecipe.Type.INSTANCE);
        registration.addRecipes(WORKPLACE_TYPE, workplaceOfCorruptionRecipes);
    }
}