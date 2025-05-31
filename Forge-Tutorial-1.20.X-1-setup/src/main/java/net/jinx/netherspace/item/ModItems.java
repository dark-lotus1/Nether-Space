package net.jinx.netherspace.item;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.item.custom.FuelItem;
import net.jinx.netherspace.item.custom.MetalDetectorItem;
import net.jinx.netherspace.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NetherSpace.MOD_ID);

    public static final RegistryObject<Item> NETHER_INGOT = ITEMS.register("nether_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUMIX_INGOT = ITEMS.register("lumix_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HORI_INGOT = ITEMS.register("hori_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NETHER = ITEMS.register("raw_nether",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100000000)));

    public static final RegistryObject<Item> NETHER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("nether_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AMERICAS_FRIES = ITEMS.register("americas_fries",
            () -> new Item(new Item.Properties().food(ModFoods.AMERICAS_FRIES)));

    public static final RegistryObject<Item> SKITTLE = ITEMS.register("skittle",
            () -> new Item(new Item.Properties().food(ModFoods.SKITTLE)));

    public static final RegistryObject<Item> NETHERCONE = ITEMS.register("nethercone",
            () -> new FuelItem(new Item.Properties(),1000));


    public static final RegistryObject<Item> NETHER_SWORD = ITEMS.register("nether_sword",
            () -> new SwordItem(ModToolTiers.NETHER, 999999999, 999999999, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_AXE = ITEMS.register("nether_axe",
            () -> new AxeItem(ModToolTiers.NETHER, 999999999, 999999999, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_PICKAXE = ITEMS.register("nether_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NETHER, 999999999, 999999999, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_SHOVEL = ITEMS.register("nether_shovel",
            () -> new ShovelItem(ModToolTiers.NETHER, 999999999, 999999999, new  Item.Properties()));
    public static final RegistryObject<Item> NETHER_HOE = ITEMS.register("nether_hoe",
            () -> new HoeItem(ModToolTiers.NETHER, 999999999, 999999999, new  Item.Properties()));

    public static final RegistryObject<Item> LUMIX_GREAT_SWORD = ITEMS.register("lumix_great_sword",
            () -> new SwordItem(ModToolTiers.NETHER, 9999999, 0.1f, new  Item.Properties()));
    public static final RegistryObject<Item> SKULLOX_MACE = ITEMS.register("skullox_mace",
            () -> new SwordItem(ModToolTiers.NETHER, 99999, 0.3f, new  Item.Properties()));
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

    public static final RegistryObject<Item> HORI_BOOTS = ITEMS.register("hori_boots",
            () -> new ArmorItem(ModArmorMaterials.HORI, ArmorItem.Type.BOOTS, new  Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
