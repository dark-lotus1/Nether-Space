package net.jinx.netherspace.item;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier NETHER = TierSortingRegistry.registerTier(
            new ForgeTier(100, 999999999, 999999999, 999999999, 999999999,
                    ModTags.Blocks.NEEDS_NETHER_TOOL, () -> Ingredient.of(ModItems.NETHER_INGOT.get())),
            new ResourceLocation(NetherSpace.MOD_ID, "nether_ingot"), List.of(Tiers.NETHERITE), List.of());

}
