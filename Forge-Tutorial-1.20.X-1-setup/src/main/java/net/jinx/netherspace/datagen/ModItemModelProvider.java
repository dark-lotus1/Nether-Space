package net.jinx.netherspace.datagen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NetherSpace.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.NETHER_INGOT);
        simpleItem(ModItems.LUMIX_INGOT);
        simpleItem(ModItems.HORI_INGOT);
        simpleItem(ModItems.RAW_NETHER);

        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.NETHERCONE);
        simpleItem(ModItems.AMERICAS_FRIES);
        simpleItem(ModItems.SKITTLE);
        simpleItem(ModItems.NETHER_UPGRADE_SMITHING_TEMPLATE);

        simpleBlockItem(ModBlocks.NETHER_DOOR);

        fenceItem(ModBlocks.NETHER_FENCE, ModBlocks.NETHER_BLOCK);
        buttonItem(ModBlocks.NETHER_BUTTON, ModBlocks.NETHER_BLOCK);
        wallItem(ModBlocks.NETHER_WALL, ModBlocks.NETHER_BLOCK);

        evenSimplerBlockItem(ModBlocks.NETHER_STAIRS);
        evenSimplerBlockItem(ModBlocks.NETHER_SLAB);
        evenSimplerBlockItem(ModBlocks.NETHER_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.NETHER_FENCE_GATE);

        trapdoorItem(ModBlocks.NETHER_TRAPDOOR);

        handheldItem(ModItems.NETHER_SWORD);
        handheldItem(ModItems.NETHER_AXE);
        handheldItem(ModItems.NETHER_PICKAXE);
        handheldItem(ModItems.NETHER_SHOVEL);
        handheldItem(ModItems.NETHER_HOE);

        handheldItem(ModItems.LUMIX_GREAT_SWORD);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NetherSpace.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(NetherSpace.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public  void  fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(NetherSpace.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public  void  buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(NetherSpace.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public  void  wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(NetherSpace.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NetherSpace.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NetherSpace.MOD_ID,"item/" + item.getId().getPath()));
    }
}
