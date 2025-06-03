package net.jinx.netherspace.datagen.loot;

import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.block.custom.SkittleCropBlock;
import net.jinx.netherspace.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.NETHER_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_NETHER_BLOCK.get());
        this.dropSelf(ModBlocks.DRAGON_ROAR_BLOCK.get());

        this.add(ModBlocks.NETHER_NETHER_ORE.get(),
                block -> createNetherOreDrops(ModBlocks.NETHER_NETHER_ORE.get(), ModItems.RAW_NETHER.get()));
        this.add(ModBlocks.END_STONE_NETHER_ORE.get(),
                block -> createEndNetherOreDrops(ModBlocks.END_STONE_NETHER_ORE.get(), ModItems.RAW_NETHER.get()));

        this.dropSelf(ModBlocks.NETHER_STAIRS.get());
        this.dropSelf(ModBlocks.NETHER_BUTTON.get());
        this.dropSelf(ModBlocks.NETHER_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NETHER_TRAPDOOR.get());
        this.dropSelf(ModBlocks.NETHER_FENCE.get());
        this.dropSelf(ModBlocks.NETHER_FENCE_GATE.get());
        this.dropSelf(ModBlocks.NETHER_WALL.get());

        this.add(ModBlocks.NETHER_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NETHER_SLAB.get()));
        this.add(ModBlocks.NETHER_DOOR.get(),
                block -> createDoorTable(ModBlocks.NETHER_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SKITTLE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SkittleCropBlock.AGE, 5));

        this.add(ModBlocks.SKITTLE_CROP.get(), createCropDrops(ModBlocks.SKITTLE_CROP.get(), ModItems.SKITTLE.get(),
                ModItems.SKITTLE_SEEDS.get(), lootitemcondition$builder));

        this.dropSelf(ModBlocks.GEM_POLISHING_STATION.get());

        this.dropSelf(ModBlocks.NETHER_LOG.get());
        this.dropSelf(ModBlocks.NETHER_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_NETHER_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_NETHER_WOOD.get());
        this.dropSelf(ModBlocks.NETHER_PLANKS.get());

        this.add(ModBlocks.NETHER_LEAVES.get(), block ->
        createLeavesDrops(block, Block.byItem(ModItems.NETHER_INGOT.get()), 0.000001f));

    }

    protected LootTable.Builder createNetherOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 9.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createEndNetherOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 20.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
