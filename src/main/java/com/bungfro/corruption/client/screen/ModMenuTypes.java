package com.bungfro.corruption.client.screen;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.client.screen.wpoc.WorkplaceOfCorruptionContainer;
import com.bungfro.corruption.client.screen.wpoc.WorkplaceOfCorruptionMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Corruption.MOD_ID);

    public static final RegistryObject<MenuType<WorkplaceOfCorruptionMenu>> WORKPLACE_OF_CORRUPTION_MENU =
            registerMenuType(WorkplaceOfCorruptionMenu::new, "workplace_of_corruption_menu");


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
