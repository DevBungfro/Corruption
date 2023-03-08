package com.bungfro.corruption.events;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.block.entity.ModBlockEntities;
import com.bungfro.corruption.block.entity.renderer.WorkplaceOfCorruptionBlockEntityRenderer;
import com.bungfro.corruption.client.screen.ModMenuTypes;
import com.bungfro.corruption.client.screen.wpoc.WorkplaceOfCorruptionScreen;
import com.bungfro.corruption.entity.ModEntityTypes;
import com.bungfro.corruption.entity.client.BulculiterRenderer;
import com.bungfro.corruption.util.ModItemProperties;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Corruption.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
        EntityRenderers.register(ModEntityTypes.BULCULITER.get(), BulculiterRenderer::new);

        event.enqueueWork(
                () -> MenuScreens.register(ModMenuTypes.WORKPLACE_OF_CORRUPTION_MENU.get(), WorkplaceOfCorruptionScreen::new)
        );
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.WORKPLACE_OF_CORRUPTION.get(),
                WorkplaceOfCorruptionBlockEntityRenderer::new);
    }
}
