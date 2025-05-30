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
                        output.accept(ModItems.LUMIX_INGOT.get());
                        output.accept(ModItems.HORI_INGOT.get());
                        output.accept(ModItems.RAW_NETHER.get());

                        output.accept(ModItems.METAL_DETECTOR.get());

                        output.accept(ModItems.AMERICAS_FRIES.get());
                        output.accept(ModItems.SKITTLE.get());

                        output.accept(ModItems.NETHERCONE.get());

                        output.accept(ModItems.NETHER_SWORD.get());
                        output.accept(ModItems.NETHER_AXE.get());
                        output.accept(ModItems.NETHER_PICKAXE.get());
                        output.accept(ModItems.NETHER_SHOVEL.get());
                        output.accept(ModItems.NETHER_HOE.get());

                        output.accept(ModItems.LUMIX_GREAT_SWORD.get());

                        output.accept(ModItems.NETHER_HELMET.get());
                        output.accept(ModItems.NETHER_CHESTPLATE.get());
                        output.accept(ModItems.NETHER_LEGGINGS.get());
                        output.accept(ModItems.NETHER_BOOTS.get());

                        output.accept(ModItems.HORI_BOOTS.get());

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

                    })
                    .build());

    public static void  register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
