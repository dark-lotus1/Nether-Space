package net.jinx.netherspace.item;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.jinx.netherspace.entity.ModEntities;
import net.jinx.netherspace.entity.custom.ModBoatEntity;
import net.jinx.netherspace.item.custom.FuelItem;
import net.jinx.netherspace.item.custom.MetalDetectorItem;
import net.jinx.netherspace.item.custom.ModArmorItem;
import net.jinx.netherspace.item.custom.ModBoatItem;
import net.jinx.netherspace.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NetherSpace.MOD_ID);

    public static final RegistryObject<Item> NETHER_INGOT = ITEMS.register("nether_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JAKE = ITEMS.register("jake",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUMIX_INGOT = ITEMS.register("lumix_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SKULY_INGOT = ITEMS.register("skuly_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HORI_INGOT = ITEMS.register("hori_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NETHER = ITEMS.register("raw_nether",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability((int) Double.POSITIVE_INFINITY)));

    public static final RegistryObject<Item> NETHER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("nether_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AMERICAS_FRIES = ITEMS.register("americas_fries",
            () -> new Item(new Item.Properties().food(ModFoods.AMERICAS_FRIES)));
    public static final RegistryObject<Item> SKITTLE = ITEMS.register("skittle",
            () -> new Item(new Item.Properties().food(ModFoods.SKITTLE)));
    public static final RegistryObject<Item> MTG_SWAMP = ITEMS.register("mtg_swamp",
            () -> new Item(new Item.Properties().food(ModFoods.MTG_SWAMP)));

    public static final RegistryObject<Item> NETHERCONE = ITEMS.register("nethercone",
            () -> new FuelItem(new Item.Properties(),1000));


    public static final RegistryObject<Item> NETHER_SWORD = ITEMS.register("nether_sword",
            () -> new SwordItem(ModToolTiers.NETHER, (int) Double.POSITIVE_INFINITY, (int) Double.POSITIVE_INFINITY, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_AXE = ITEMS.register("nether_axe",
            () -> new AxeItem(ModToolTiers.NETHER, (int) Double.POSITIVE_INFINITY, (int) Double.POSITIVE_INFINITY, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_PICKAXE = ITEMS.register("nether_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NETHER, (int) Double.POSITIVE_INFINITY, (int) Double.POSITIVE_INFINITY, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_SHOVEL = ITEMS.register("nether_shovel",
            () -> new ShovelItem(ModToolTiers.NETHER, (int) Double.POSITIVE_INFINITY, (int) Double.POSITIVE_INFINITY, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_HOE = ITEMS.register("nether_hoe",
            () -> new HoeItem(ModToolTiers.NETHER, (int) Double.POSITIVE_INFINITY, (int) Double.POSITIVE_INFINITY, new  Item.Properties()));

    public static final RegistryObject<Item> LUMIX_GREAT_SWORD = ITEMS.register("lumix_great_sword",
            () -> new SwordItem(ModToolTiers.NETHER, 9999999, 0.1f, new  Item.Properties()));
    public static final RegistryObject<Item> SKULLOX_MACE = ITEMS.register("skullox_mace",
            () -> new SwordItem(ModToolTiers.NETHER, 16, 0.3f, new  Item.Properties()));
    public static final RegistryObject<Item> JORDAN_KATANA = ITEMS.register("jordan_katana",
            () -> new SwordItem(ModToolTiers.NETHER, 99999, 0.5f, new  Item.Properties()));

    public static final RegistryObject<Item> NETHER_HELMET = ITEMS.register("nether_helmet",
            () -> new ModArmorItem(ModArmorMaterials.NETHER, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_CHESTPLATE = ITEMS.register("nether_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.NETHER, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_LEGGINGS = ITEMS.register("nether_leggings",
            () -> new ModArmorItem(ModArmorMaterials.NETHER, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_BOOTS = ITEMS.register("nether_boots",
            () -> new ModArmorItem(ModArmorMaterials.NETHER, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> JAKE_HELMET = ITEMS.register("jake_helmet",
            () -> new ModArmorItem(ModArmorMaterials.JAKE, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> JAKE_CHESTPLATE = ITEMS.register("jake_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.JAKE, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));
    public static final RegistryObject<Item> JAKE_LEGGINGS = ITEMS.register("jake_leggings",
            () -> new ModArmorItem(ModArmorMaterials.JAKE, ArmorItem.Type.LEGGINGS, new  Item.Properties()));
    public static final RegistryObject<Item> JAKE_BOOTS = ITEMS.register("jake_boots",
            () -> new ModArmorItem(ModArmorMaterials.JAKE, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> SKULY_MASK = ITEMS.register("skuly_mask",
            () -> new ArmorItem(ModArmorMaterials.SKULY, ArmorItem.Type.HELMET, new  Item.Properties()));
    public static final RegistryObject<Item> HORI_BOOTS = ITEMS.register("hori_boots",
            () -> new ArmorItem(ModArmorMaterials.HORI, ArmorItem.Type.BOOTS, new  Item.Properties()));

    public static final RegistryObject<Item> SKITTLE_SEEDS = ITEMS.register("skittle_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SKITTLE_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new RecordItem(6, ModSounds.BAR_BRAWL, new Item.Properties().stacksTo(1), 2440));

    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c6,
                    new Item.Properties()));

    public static final RegistryObject<Item> NETHER_SIGN = ITEMS.register("nether_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.NETHER_SIGN.get(), ModBlocks.NETHER_WALL_SIGN.get()));
    public static final RegistryObject<Item> NETHER_HANGING_SIGN = ITEMS.register("nether_hanging_sign",
            () -> new HangingSignItem(ModBlocks.NETHER_HANGING_SIGN.get(), ModBlocks.NETHER_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> NETHER_BOAT = ITEMS.register("nether_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.NETHER, new Item.Properties()));
    public static final RegistryObject<Item> NETHER_CHEST_BOAT = ITEMS.register("nether_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.NETHER, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
