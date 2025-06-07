package net.jinx.netherspace.worldgen.biome;

import net.jinx.netherspace.NetherSpace;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(NetherSpace.MOD_ID, "overworld"), 5));
    }
}
