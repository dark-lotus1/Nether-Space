package net.jinx.netherspace.worldgen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.worldgen.tree.custom.NetherTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_NETHER_ORE_KEY = registerKey("nether_nether_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_NETHER_ORE_KEY = registerKey("end_nether_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_KEY = registerKey("nether");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, NETHER_NETHER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_NETHER_ORE.get().defaultBlockState(), 2));
        register(context, END_NETHER_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.END_STONE_NETHER_ORE.get().defaultBlockState(), 6));

        register(context, NETHER_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.NETHER_LOG.get()),
                new NetherTrunkPlacer(5, 4, 3),

                BlockStateProvider.simple(ModBlocks.NETHER_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(NetherSpace.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
