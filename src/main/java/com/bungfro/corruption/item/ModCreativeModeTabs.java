package com.bungfro.corruption.item;

import com.bungfro.corruption.Corruption;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Corruption.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab CorruptionTab;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        CorruptionTab = event.registerCreativeModeTab(new ResourceLocation(Corruption.MOD_ID, "corruption_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.CorruptedDust.get()))
                        .title(Component.translatable("creativemodetab.corruption_tab")));
    }
}
