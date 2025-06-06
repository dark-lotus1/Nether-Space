package net.jinx.netherspace.datagen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.block.custom.SkittleCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NetherSpace.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NETHER_BLOCK);
        blockWithItem(ModBlocks.RAW_NETHER_BLOCK);

        blockWithItem(ModBlocks.NETHER_NETHER_ORE);
        blockWithItem(ModBlocks.END_STONE_NETHER_ORE);

        blockWithItem(ModBlocks.DRAGON_ROAR_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.NETHER_STAIRS.get()), blockTexture(ModBlocks.NETHER_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.NETHER_SLAB.get()), blockTexture(ModBlocks.NETHER_BLOCK.get()), blockTexture(ModBlocks.NETHER_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.NETHER_BUTTON.get()), blockTexture(ModBlocks.NETHER_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.NETHER_PRESSURE_PLATE.get()), blockTexture(ModBlocks.NETHER_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.NETHER_FENCE.get()), blockTexture(ModBlocks.NETHER_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.NETHER_FENCE_GATE.get()), blockTexture(ModBlocks.NETHER_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.NETHER_WALL.get()), blockTexture(ModBlocks.NETHER_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.NETHER_DOOR.get()), modLoc("block/nether_door_bottom"), modLoc("block/nether_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.NETHER_TRAPDOOR.get()), modLoc("block/nether_trapdoor"), true, "cutout");

        makeSkittleCrop((CropBlock) ModBlocks.SKITTLE_CROP.get(), "skittle_stage", "skittle_stage");

        simpleBlockWithItem(ModBlocks.GEM_POLISHING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));

        logBlock(((RotatedPillarBlock) ModBlocks.NETHER_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.NETHER_WOOD.get()), blockTexture(ModBlocks.NETHER_LOG.get()),
                blockTexture(ModBlocks.NETHER_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_NETHER_LOG.get()), blockTexture(ModBlocks.STRIPPED_NETHER_LOG.get()),
                new ResourceLocation(NetherSpace.MOD_ID, "block/stripped_nether_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_NETHER_WOOD.get()), blockTexture(ModBlocks.STRIPPED_NETHER_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_NETHER_LOG.get()));

        blockItem(ModBlocks.NETHER_LOG);
        blockItem(ModBlocks.NETHER_WOOD);
        blockItem(ModBlocks.STRIPPED_NETHER_LOG);
        blockItem(ModBlocks.STRIPPED_NETHER_WOOD);

        blockWithItem(ModBlocks.NETHER_PLANKS);

        leavesBlock(ModBlocks.NETHER_LEAVES);

        signBlock(((StandingSignBlock) ModBlocks.NETHER_SIGN.get()), ((WallSignBlock) ModBlocks.NETHER_WALL_SIGN.get()),
                blockTexture(ModBlocks.NETHER_PLANKS.get()));

        hangingSignBlock(ModBlocks.NETHER_HANGING_SIGN.get(), ModBlocks.NETHER_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.NETHER_PLANKS.get()));


    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem (RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(NetherSpace.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
        }


    public void makeSkittleCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> skittleStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] skittleStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SkittleCropBlock) block).getAgeProperty()),
                new ResourceLocation(NetherSpace.MOD_ID, "block/" + textureName + state.getValue(((SkittleCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
