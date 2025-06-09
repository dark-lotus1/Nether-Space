package net.jinx.netherspace.datagen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NetherSpace.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.NETHER_NETHER_ORE.get())
                .add(ModBlocks.END_STONE_NETHER_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.NETHER_BLOCK.get(),
                        ModBlocks.RAW_NETHER_BLOCK.get(),
                        ModBlocks.NETHER_NETHER_ORE.get(),
                        ModBlocks.END_STONE_NETHER_ORE.get(),
                        ModBlocks.END_STONE_NETHER_ORE.get(),
                        ModBlocks.DRAGON_ROAR_BLOCK.get());



        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.NETHER_NETHER_ORE.get())
                .add(ModBlocks.END_STONE_NETHER_ORE.get());

        this.tag(ModTags.Blocks.NEEDS_NEITHER_TOOL)
                .add(ModBlocks.NETHER_BLOCK.get())
                .add(ModBlocks.RAW_NETHER_BLOCK.get())
                .add(ModBlocks.DRAGON_ROAR_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.NETHER_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.NETHER_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.NETHER_WALL.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.NETHER_LOG.get())
                .add(ModBlocks.NETHER_WOOD.get())
                .add(ModBlocks.STRIPPED_NETHER_LOG.get())
                .add(ModBlocks.STRIPPED_NETHER_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.NETHER_PLANKS.get());

    }
}
