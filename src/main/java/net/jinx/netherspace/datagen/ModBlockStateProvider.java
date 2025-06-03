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

        simpleBlockWithItem(ModBlocks.GEM_POLISHING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));

        makeSkittleCrop((CropBlock) ModBlocks.SKITTLE_CROP.get(), "skittle_stage", "skittle_stage");
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
