package com.bungfro.corruption.client.screen;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.client.screen.wpoc.WorkplaceOfCorruptionMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Corruption.MOD_ID);

    public static final RegistryObject<MenuType<WorkplaceOfCorruptionMenu>> WORKPLACE = MENU_TYPES.register("workplace", () -> new MenuType(WorkplaceOfCorruptionMenu::new));

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }

}
