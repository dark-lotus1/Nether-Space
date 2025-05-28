package net.jinx.netherspace.block;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.custom.DragonRoarBlock;
import net.jinx.netherspace.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NetherSpace.MOD_ID);

    public static final RegistryObject<Block> NETHER_BLOCK = registerBlock("nether_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_NETHER_BLOCK = registerBlock("raw_nether_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> NETHER_NETHER_ORE = registerBlock("nether_nether_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(10).requiresCorrectToolForDrops(), UniformInt.of(100,300)));
    public static final RegistryObject<Block> END_STONE_NETHER_ORE = registerBlock("end_stone_nether_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(10).requiresCorrectToolForDrops(), UniformInt.of(300,500)));

    public static final RegistryObject<Block> DRAGON_ROAR_BLOCK = registerBlock("dragon_roar_block",
            () -> new DragonRoarBlock(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);
    }

}
