package com.bungfro.corruption.events;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.entity.ModEntity;
import com.bungfro.corruption.entity.entities.BulculiterEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Corruption.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntity.BULCULITER.get(), BulculiterEntity.getBulculiterAttributes().build());
    }
}
