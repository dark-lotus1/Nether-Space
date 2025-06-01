package net.jinx.netherspace.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties AMERICAS_FRIES = new FoodProperties.Builder().nutrition(1).fast().alwaysEat()
            .saturationMod(0.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 3), 1f).build();

    public static final FoodProperties SKITTLE = new FoodProperties.Builder().nutrition(10).fast().alwaysEat()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 5), 1f).build();

    public static final FoodProperties MTG_SWAMP = new FoodProperties.Builder().nutrition(10).fast().alwaysEat()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 1), 1f)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999, 5), 1f)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 999999, 5), 1f)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 999999, 5), 1f)
            .build();
}
