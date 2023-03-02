package com.bungfro.corruption.item.custom;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

public class ToxicFlameBowItem extends BowItem {

    public ToxicFlameBowItem(Properties pProperties) {
        super(pProperties);
    }

    protected double getArrowDamage(ItemStack bowStack, AbstractArrow arrowEntity) {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
        return (double)powerLevel + 1.5D;
    }
}
