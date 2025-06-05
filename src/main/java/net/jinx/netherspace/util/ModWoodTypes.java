package net.jinx.netherspace.util;

import net.jinx.netherspace.NetherSpace;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType NETHERW = WoodType.register(new WoodType(NetherSpace.MOD_ID + "netherw", BlockSetType.OAK));
}
