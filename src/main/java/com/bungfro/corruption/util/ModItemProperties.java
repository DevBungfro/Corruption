package com.bungfro.corruption.util;

import com.bungfro.corruption.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        makeBow(ModItems.TOXIC_FLAME_BOW.get());
    }

    public static void makeBow(Item item){
        ItemProperties.register(item, new ResourceLocation("pull"), (itemStack, level, entity, i) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration()
                        - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        });

        ItemProperties.register(item, new ResourceLocation("pulling"), (itemStack, level, entity, i) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
    }
}
