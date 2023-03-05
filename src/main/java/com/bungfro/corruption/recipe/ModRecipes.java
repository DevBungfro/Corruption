package com.bungfro.corruption.recipe;

import com.bungfro.corruption.Corruption;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Corruption.MOD_ID);

    public static final RegistryObject<RecipeSerializer<WorkplaceOfCorruptionRecipe>> WORKPLACE_SERIALIZER =
            SERIALIZERS.register("workplace_shaped", () -> WorkplaceOfCorruptionRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}