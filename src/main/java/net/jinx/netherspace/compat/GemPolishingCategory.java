package net.jinx.netherspace.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.recipe.GemPolishingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class GemPolishingCategory implements IRecipeCategory<GemPolishingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(NetherSpace.MOD_ID, "gem_polishing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(NetherSpace.MOD_ID,
            "textures/gui/gem_polishing_station_gui.png");

    public static final RecipeType<GemPolishingRecipe> GEM_POLISHING_TYPE =
            new RecipeType<>(UID, GemPolishingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public GemPolishingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.GEM_POLISHING_STATION.get()));
    }


    @Override
    public RecipeType<GemPolishingRecipe> getRecipeType() {
        return GEM_POLISHING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.netherspace.gem_polishing_station");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, GemPolishingRecipe recipe, IFocusGroup recipes) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResultItem(null));
    }
}
