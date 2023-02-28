package com.bungfro.corruption.item;

import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.base.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Corruption.MOD_ID);

    public static final RegistryObject<Item> CorruptedDust = ITEMS.register("corrupteddust", () -> new Item(new Item.Properties()));

    // Armor Items
    public static final RegistryObject<ArmorItem> TOXIC_FLAME_HELMET_LIGHT = ITEMS.register("toxic_flame_helmet_light",
            () -> new ArmorItem(ArmorTiers.TOXIC_FLAME_LIGHT, EquipmentSlot.HEAD, new Item.Properties()));

    public static final RegistryObject<ArmorItem> TOXIC_FLAME_CHESTPLATE_LIGHT = ITEMS.register("toxic_flame_chestplate_light",
            () -> new ArmorItem(ArmorTiers.TOXIC_FLAME_LIGHT, EquipmentSlot.CHEST, new Item.Properties()));

    public static final RegistryObject<ArmorItem> TOXIC_FLAME_LEGGINGS_LIGHT = ITEMS.register("toxic_flame_leggings_light",
            () -> new ArmorItem(ArmorTiers.TOXIC_FLAME_LIGHT, EquipmentSlot.LEGS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> TOXIC_FLAME_BOOTS_LIGHT = ITEMS.register("toxic_flame_boots_light",
            () -> new ArmorItem(ArmorTiers.TOXIC_FLAME_LIGHT, EquipmentSlot.FEET, new Item.Properties()));

    // Toxic Flame Heavy
    public static final RegistryObject<ArmorItem> TOXIC_FLAME_HELMET_HEAVY = ITEMS.register("toxic_flame_helmet_heavy",
            () -> new ArmorItem(ArmorTiers.TOXIC_FLAME_HEAVY, EquipmentSlot.HEAD, new Item.Properties()));

    public static final RegistryObject<ArmorItem> TOXIC_FLAME_CHESTPLATE_HEAVY = ITEMS.register("toxic_flame_chestplate_heavy",
            () -> new ArmorItem(ArmorTiers.TOXIC_FLAME_HEAVY, EquipmentSlot.CHEST, new Item.Properties()));

    public static final RegistryObject<ArmorItem> TOXIC_FLAME_LEGGINGS_HEAVY = ITEMS.register("toxic_flame_leggings_heavy",
            () -> new ArmorItem(ArmorTiers.TOXIC_FLAME_HEAVY, EquipmentSlot.LEGS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> TOXIC_FLAME_BOOTS_HEAVY = ITEMS.register("toxic_flame_boots_heavy",
            () -> new ArmorItem(ArmorTiers.TOXIC_FLAME_HEAVY, EquipmentSlot.FEET, new Item.Properties()));

    public static final RegistryObject<Item> TOXIC_FLAME_BOW = ITEMS.register("toxic_flame_bow", () -> new BowItem(new Item.Properties().durability(500)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class ArmorTiers {
        public static final ArmorMaterial TOXIC_FLAME_LIGHT = new ModArmorMaterial(
                "toxic_flame_light",
                500,
                new int[] { 20, 40, 50, 10 },
                300,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                () -> Ingredient.of(ModItems.CorruptedDust.get())
        );

        public static final ArmorMaterial TOXIC_FLAME_HEAVY = new ModArmorMaterial(
                "toxic_flame_heavy",
                500,
                new int[] { 20, 40, 50, 10 },
                300,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                () -> Ingredient.of(ModItems.CorruptedDust.get())
        );
    }
}
