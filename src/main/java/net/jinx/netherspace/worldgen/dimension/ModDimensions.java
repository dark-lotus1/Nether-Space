package net.jinx.netherspace.worldgen.dimension;

import com.mojang.datafixers.util.Pair;
import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<LevelStem> NEITHERDIM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(NetherSpace.MOD_ID, "neitherspace"));
    public static final ResourceKey<Level> NEITHERDIM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(NetherSpace.MOD_ID, "neitherdim"));
    public static final ResourceKey<DimensionType> NEITHER_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(NetherSpace.MOD_ID, "neitherdim_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(NEITHER_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, //infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(true, true, ConstantInt.of(0),0)));
    }

    public static void bootStrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noisGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.NEITHER_BIOME)),
                noisGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.NEITHER_BIOME)),
                                Pair.of(
                                        Climate.parameters(0.1F, 0.2F, 0.6F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.WARPED_FOREST)),
                                Pair.of(
                                        Climate.parameters(0.3F, 0.6F, 0.5F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.CRIMSON_FOREST)),
                                Pair.of(
                                        Climate.parameters(0.4F, 0.3F, 0.5F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.CHERRY_GROVE)),
                                Pair.of(
                                        Climate.parameters(0.5F, 0.7F, 0.5F, 0.8F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.NETHER_WASTES))
                        ))),
                noisGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.NEITHER_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(NEITHERDIM_KEY, stem);
    }
}
