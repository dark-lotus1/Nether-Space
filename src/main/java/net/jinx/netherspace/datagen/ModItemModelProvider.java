package net.jinx.netherspace.datagen;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NetherSpace.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.NETHER_INGOT);
        simpleItem(ModItems.JAKE);
        simpleItem(ModItems.LUMIX_INGOT);
        simpleItem(ModItems.SKULY_INGOT);
        simpleItem(ModItems.HORI_INGOT);
        simpleItem(ModItems.RAW_NETHER);

        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.NETHERCONE);

        simpleItem(ModItems.AMERICAS_FRIES);
        simpleItem(ModItems.SKITTLE);
        simpleItem(ModItems.SKITTLE_SEEDS);
        simpleItem(ModItems.MTG_SWAMP);

        simpleItem(ModItems.BAR_BRAWL_MUSIC_DISC);
        simpleItem(ModItems.EERIE_EXPERIMENT_MUSIC_DISK);

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
        handheldItem(ModItems.SKULLOX_MACE);
        handheldItem(ModItems.JORDAN_KATANA);

        trimmedArmorItem(ModItems.NETHER_HELMET);
        trimmedArmorItem(ModItems.NETHER_CHESTPLATE);
        trimmedArmorItem(ModItems.NETHER_LEGGINGS);
        trimmedArmorItem(ModItems.NETHER_BOOTS);

        trimmedArmorItem(ModItems.JAKE_HELMET);
        trimmedArmorItem(ModItems.JAKE_CHESTPLATE);
        trimmedArmorItem(ModItems.JAKE_LEGGINGS);
        trimmedArmorItem(ModItems.JAKE_BOOTS);

        trimmedArmorItem(ModItems.SKULY_MASK);
        trimmedArmorItem(ModItems.HORI_BOOTS);

        withExistingParent(ModItems.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        simpleItem(ModItems.NETHER_SIGN);
        simpleItem(ModItems.NETHER_HANGING_SIGN);

        simpleItem(ModItems.NETHER_BOAT);
        simpleItem(ModItems.NETHER_CHEST_BOAT);


        saplingItem(ModBlocks.NETHER_SAPLING);
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = NetherSpace.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NetherSpace.MOD_ID, "block/" + item.getId().getPath()));
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
