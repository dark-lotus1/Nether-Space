package net.jinx.netherspace.item;

import net.jinx.netherspace.NetherSpace;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    NETHER("nether", 999999999, new int[]{999999999, 999999999, 999999999, 999999999}, 999999999,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 999999999f, 999999999f, () -> Ingredient.of(ModItems.NETHER_INGOT.get())),
    HORI("hori", 999, new int[]{9999, 9999, 9999, 9999}, 9999,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 9999f, 9999f, () -> Ingredient.of(ModItems.HORI_INGOT.get())),
    SKULY("skuly", 999, new int[]{9999, 9999, 9999, 9999}, 9999,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 9999f, 9999f, () -> Ingredient.of(ModItems.SKULY_INGOT.get())),
    JAKE("jake", 999, new int[]{999, 999, 999, 999}, 999,
    SoundEvents.ARMOR_EQUIP_NETHERITE, 999f, 999f, () -> Ingredient.of(ModItems.JAKE.get()));


    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 13, 17, 15, 11};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return NetherSpace.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}