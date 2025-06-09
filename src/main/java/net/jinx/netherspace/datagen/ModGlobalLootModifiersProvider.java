package net.jinx.netherspace.datagen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.item.ModItems;
import net.jinx.netherspace.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, NetherSpace.MOD_ID);
    }

    @Override
    protected void start() {
        add("nethercone_from_nether_sprouts", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.NETHER_SPROUTS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.NETHERCONE.get()));

        add("mtg_swamp_from_soul_soil", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SOUL_SOIL).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.MTG_SWAMP.get()));

        add("americas_fries_from_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build() }, ModItems.AMERICAS_FRIES.get()));

        add("metal_detector_from_bastion_treasure", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.01f).build()}, ModItems.METAL_DETECTOR.get()));
    }
}
