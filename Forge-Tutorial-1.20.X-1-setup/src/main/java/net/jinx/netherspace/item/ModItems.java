package net.jinx.netherspace.item;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.item.custom.FuelItem;
import net.jinx.netherspace.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NetherSpace.MOD_ID);

    public static final RegistryObject<Item> NETHER_INGOT = ITEMS.register("nether_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NETHER = ITEMS.register("raw_nether",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100000000)));

    public static final RegistryObject<Item> NETHER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("nether_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AMERICAS_FRIES = ITEMS.register("americas_fries",
            () -> new Item(new Item.Properties().food(ModFoods.AMERICAS_FRIES)));

    public static final RegistryObject<Item> NETHERCONE = ITEMS.register("nethercone",
            () -> new FuelItem(new Item.Properties(),1000));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
