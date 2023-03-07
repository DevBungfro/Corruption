package com.bungfro.corruption.events;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.client.screen.ModMenuTypes;
import com.bungfro.corruption.client.screen.wpoc.WorkplaceOfCorruptionScreen;
import com.bungfro.corruption.entity.ModEntityTypes;
import com.bungfro.corruption.util.ModItemProperties;
import net.minecraft.client.gui.screens.MenuScreens;
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

        event.enqueueWork(
                () -> MenuScreens.register(ModMenuTypes.WORKPLACE_OF_CORRUPTION_MENU.get(), WorkplaceOfCorruptionScreen::new)
        );
    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        //event.registerEntityRenderer(ModEntityTypes.BULCULITER.get(), BulculiterEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
       // event.registerLayerDefinition(BulculiterEntityModel.LAYER_LOCATION, BulculiterEntityModel::createBodyLayer);
    }
}
