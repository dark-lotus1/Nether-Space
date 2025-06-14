package net.jinx.netherspace.entity.client;

import net.jinx.netherspace.NetherSpace;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation RHINO_LAYER = new ModelLayerLocation(
            new ResourceLocation(NetherSpace.MOD_ID, "rhino_layer"), "main");

    public static final ModelLayerLocation NETHER_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(NetherSpace.MOD_ID, "boat/nether"), "main");
    public static final ModelLayerLocation NETHER_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(NetherSpace.MOD_ID, "chest_boat/nether"), "main");
}
