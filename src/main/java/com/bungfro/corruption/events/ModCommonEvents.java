package com.bungfro.corruption.events;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.entity.ModEntityTypes;
import com.bungfro.corruption.entity.custom.BulculiterEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Corruption.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
       event.put(ModEntityTypes.BULCULITER.get(), BulculiterEntity.setAttributes());
    }
}
