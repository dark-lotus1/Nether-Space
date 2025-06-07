package net.jinx.netherspace.worldgen.tree;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.worldgen.tree.custom.NetherTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, NetherSpace.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<NetherTrunkPlacer>> NETHER_TRUNK_PLACER =
            TRUNK_PLACER.register("nether_trunk_placer", () -> new TrunkPlacerType<>(NetherTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
