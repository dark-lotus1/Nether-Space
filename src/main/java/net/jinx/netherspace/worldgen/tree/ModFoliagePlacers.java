package net.jinx.netherspace.worldgen.tree;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.worldgen.tree.custom.NetherFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, NetherSpace.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<NetherFoliagePlacer>> NETHER_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("nether_foliage_placer", () -> new FoliagePlacerType<>(NetherFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }

}
