package net.jinx.netherspace.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties AMERICAS_FRIES = new FoodProperties.Builder().nutrition(1).fast()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 3), 1f).build();
}
