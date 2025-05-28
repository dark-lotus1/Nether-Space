package net.jinx.netherspace.datagen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
