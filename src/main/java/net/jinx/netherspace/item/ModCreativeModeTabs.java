package net.jinx.netherspace.item;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NetherSpace.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NETHER_SPACE_TAB = CREATIVE_MODE_TABS.register("nether_space_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NETHER_INGOT.get()))
                    .title(Component.translatable("creativetab.nether_space.tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.NETHER_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(ModItems.NETHER_INGOT.get());
                        output.accept(ModItems.JAKE.get());
                        output.accept(ModItems.LUMIX_INGOT.get());
                        output.accept(ModItems.SKULY_INGOT.get());
                        output.accept(ModItems.HORI_INGOT.get());
                        output.accept(ModItems.RAW_NETHER.get());

                        output.accept(ModItems.METAL_DETECTOR.get());

                        output.accept(ModItems.AMERICAS_FRIES.get());
                        output.accept(ModItems.SKITTLE.get());
                        output.accept(ModItems.MTG_SWAMP.get());

                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());
                        output.accept(ModItems.EERIE_EXPERIMENT_MUSIC_DISK.get());

                        output.accept(ModItems.NETHERCONE.get());

                        output.accept(ModItems.NETHER_SWORD.get());
                        output.accept(ModItems.NETHER_AXE.get());
                        output.accept(ModItems.NETHER_PICKAXE.get());
                        output.accept(ModItems.NETHER_SHOVEL.get());
                        output.accept(ModItems.NETHER_HOE.get());

                        output.accept(ModItems.LUMIX_GREAT_SWORD.get());
                        output.accept(ModItems.SKULLOX_MACE.get());
                        output.accept(ModItems.JORDAN_KATANA.get());

                        output.accept(ModItems.NETHER_HELMET.get());
                        output.accept(ModItems.NETHER_CHESTPLATE.get());
                        output.accept(ModItems.NETHER_LEGGINGS.get());
                        output.accept(ModItems.NETHER_BOOTS.get());

                        output.accept(ModItems.JAKE_HELMET.get());
                        output.accept(ModItems.JAKE_CHESTPLATE.get());
                        output.accept(ModItems.JAKE_LEGGINGS.get());
                        output.accept(ModItems.JAKE_BOOTS.get());

                        output.accept(ModItems.SKULY_MASK.get());
                        output.accept(ModItems.HORI_BOOTS.get());

                        output.accept(ModItems.SKITTLE_SEEDS.get());

                        output.accept(ModItems.RHINO_SPAWN_EGG.get());

                        output.accept(ModItems.NETHER_SIGN.get());
                        output.accept(ModItems.NETHER_HANGING_SIGN.get());

                        output.accept(ModItems.NETHER_BOAT.get());
                        output.accept(ModItems.NETHER_CHEST_BOAT.get());

                        output.accept(ModBlocks.NETHER_BLOCK.get());
                        output.accept(ModBlocks.RAW_NETHER_BLOCK.get());

                        output.accept(ModBlocks.NETHER_NETHER_ORE.get());
                        output.accept(ModBlocks.END_STONE_NETHER_ORE.get());

                        output.accept(ModBlocks.DRAGON_ROAR_BLOCK.get());

                        output.accept(ModBlocks.NETHER_STAIRS.get());
                        output.accept(ModBlocks.NETHER_SLAB.get());
                        output.accept(ModBlocks.NETHER_BUTTON.get());
                        output.accept(ModBlocks.NETHER_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.NETHER_FENCE.get());
                        output.accept(ModBlocks.NETHER_FENCE_GATE.get());
                        output.accept(ModBlocks.NETHER_WALL.get());

                        output.accept(ModBlocks.NETHER_DOOR.get());
                        output.accept(ModBlocks.NETHER_TRAPDOOR.get());

                        output.accept(ModBlocks.GEM_POLISHING_STATION.get());

                        output.accept(ModBlocks.NETHER_LOG.get());
                        output.accept(ModBlocks.NETHER_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_NETHER_LOG.get());
                        output.accept(ModBlocks.STRIPPED_NETHER_WOOD.get());

                        output.accept(ModBlocks.NETHER_PLANKS.get());
                        output.accept(ModBlocks.NETHER_LEAVES.get());

                        output.accept(ModBlocks.NETHER_SAPLING.get());
                        output.accept(ModBlocks.NEITHER_PORTAL.get());

                    })
                    .build());

    public static void  register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
