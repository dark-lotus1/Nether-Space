package net.jinx.netherspace.block.entity;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NetherSpace.MOD_ID);

public static final RegistryObject<BlockEntityType<GemPolishingStationBlockEntity>> GEM_POLISHING_BE =
        BLOCK_ENTITIES.register("gem_polishing_be", () ->
                BlockEntityType.Builder.of(GemPolishingStationBlockEntity::new,
                        ModBlocks.GEM_POLISHING_STATION.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.NETHER_SIGN.get(), ModBlocks.NETHER_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.NETHER_HANGING_SIGN.get(), ModBlocks.NETHER_WALL_HANGING_SIGN.get()).build(null));


    public static void  register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
