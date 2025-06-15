package net.jinx.netherspace.worldgen.biome;

import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.worldgen.biome.custom.ModOverworldRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerraBlenderAPI {
    public static void registerRegions() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(NetherSpace.MOD_ID, "overworld"), 1));
    }
}
