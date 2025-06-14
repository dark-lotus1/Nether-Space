package net.jinx.netherspace.worldgen.biome.surface;

import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource NEITHER = makeStateRule(ModBlocks.NETHER_BLOCK.get());
    private static final SurfaceRules.RuleSource RAW_NEITHER = makeStateRule(ModBlocks.RAW_NETHER_BLOCK.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        // Default to a grass and dirt surface
        // Default to a grass and dirt surface
        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.NEITHER_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)),


                        // Default to a grass and dirt surface
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, DIRT), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)));
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
