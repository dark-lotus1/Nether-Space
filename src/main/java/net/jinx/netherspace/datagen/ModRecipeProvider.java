package net.jinx.netherspace.datagen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.extensions.IForgeItem;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> NETHER_SMELTABLES = List.of(
            ModItems.RAW_NETHER.get(),
            ModBlocks.NETHER_NETHER_ORE.get(),
            ModBlocks.END_STONE_NETHER_ORE.get()
    );
    private static final List<ItemLike> NETHER_BLOCK_SMELTABLES = List.of(
            ModBlocks.RAW_NETHER_BLOCK.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, NETHER_SMELTABLES, RecipeCategory.MISC, ModItems.NETHER_INGOT.get(), 1.0f, 600, "nether");
        oreBlasting(pWriter, NETHER_SMELTABLES, RecipeCategory.MISC, ModItems.NETHER_INGOT.get(), 1.0f, 300, "nether");

        oreSmelting(pWriter, NETHER_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.NETHER_BLOCK.get(), 9.0f, 1200, "nether");
        oreBlasting(pWriter, NETHER_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.NETHER_BLOCK.get(), 9.0f, 600, "nether");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHER_BLOCK.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.NETHER_INGOT.get())
                .unlockedBy(getHasName(ModItems.NETHER_INGOT.get()), has(ModItems.NETHER_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_NETHER_BLOCK.get())
                .pattern("RRR")
                .pattern("RNR")
                .pattern("RRR")
                .define('R', ModItems.RAW_NETHER.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(ModItems.NETHER_INGOT.get()), has(ModItems.NETHER_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHER_INGOT.get(), 9)
                .requires(ModBlocks.NETHER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NETHER_BLOCK.get()), has(ModBlocks.NETHER_BLOCK.get()))
                .save(pWriter);


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, NetherSpace.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
