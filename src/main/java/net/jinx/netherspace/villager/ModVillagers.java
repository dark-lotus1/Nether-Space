package net.jinx.netherspace.villager;

import com.google.common.collect.ImmutableSet;
import net.jinx.netherspace.NetherSpace;
import net.jinx.netherspace.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, NetherSpace.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, NetherSpace.MOD_ID);

    public static final RegistryObject<PoiType> DRAGON_ROAR_POI = POI_TYPES.register("dragon_roar_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.DRAGON_ROAR_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> DRAGONMANCER =
            VILLAGER_PROFESSIONS.register("dragonmancer", () -> new VillagerProfession("dragonmancer",
                    holder -> holder.get() == DRAGON_ROAR_POI.get(), holder -> holder.get() == DRAGON_ROAR_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
