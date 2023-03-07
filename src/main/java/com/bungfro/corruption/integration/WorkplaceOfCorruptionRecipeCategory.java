package com.bungfro.corruption.integration;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.block.ModBlocks;
import com.bungfro.corruption.recipe.WorkplaceOfCorruptionRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

class WorkplaceOfCorruptionRecipeCategory implements IRecipeCategory<WorkplaceOfCorruptionRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Corruption.MOD_ID, "workplace");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Corruption.MOD_ID, "textures/gui/corruption_workplace.png");

    private final IDrawable background;
    private final IDrawable icon;

    public WorkplaceOfCorruptionRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 222);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.WORKPLACE_OF_CORRUPTION.get()));
    }

    @Override
    public RecipeType getRecipeType() {
        return JEICorruptionPlugin.WORKPLACE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Workplace Of Corruption");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WorkplaceOfCorruptionRecipe recipe, IFocusGroup focuses) {
        for(int j = 0; j < 5; ++j) {
            for(int k = 0; k < 5; ++k) {
                builder.addSlot(RecipeIngredientRole.INPUT,44 + k * 18, 18 + j * 18);
            }
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 146, 54).addItemStack(recipe.getResultItem());
    }
}