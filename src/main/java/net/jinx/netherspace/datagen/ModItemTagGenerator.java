package net.jinx.netherspace.datagen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, NetherSpace.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItems.NETHER_HELMET.get(),
                        ModItems.NETHER_CHESTPLATE.get(),
                        ModItems.NETHER_LEGGINGS.get(),
                        ModItems.NETHER_BOOTS.get(),

                        ModItems.JAKE_HELMET.get(),
                        ModItems.JAKE_CHESTPLATE.get(),
                        ModItems.JAKE_LEGGINGS.get(),
                        ModItems.JAKE_BOOTS.get(),

                        ModItems.SKULY_MASK.get(),
                        ModItems.HORI_BOOTS.get()
                );

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.BAR_BRAWL_MUSIC_DISC.get())
                .add(ModItems.EERIE_EXPERIMENT_MUSIC_DISK.get())
        ;

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.BAR_BRAWL_MUSIC_DISC.get())
                .add(ModItems.EERIE_EXPERIMENT_MUSIC_DISK.get())
        ;

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.NETHER_LOG.get().asItem())
                .add(ModBlocks.NETHER_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_NETHER_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_NETHER_WOOD.get().asItem())
        ;

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.NETHER_PLANKS.get().asItem())
        ;

        this.tag(ItemTags.SWORDS)
                .add(ModItems.NETHER_SWORD.get())
                .add(ModItems.LUMIX_GREAT_SWORD.get())
                .add(ModItems.JORDAN_KATANA.get())
        ;
    }
}
