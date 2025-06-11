package net.jinx.netherspace.sound;

import net.jinx.netherspace.NetherSpace;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NetherSpace.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");

    public static final RegistryObject<SoundEvent> DRAGON_ROAR_BLOCK_BREAK = registerSoundEvents("dragon_roar_block_break");
    public static final RegistryObject<SoundEvent> DRAGON_ROAR_BLOCK_STEP = registerSoundEvents("dragon_roar_block_step");
    public static final RegistryObject<SoundEvent> DRAGON_ROAR_BLOCK_FALL = registerSoundEvents("dragon_roar_block_fall");
    public static final RegistryObject<SoundEvent> DRAGON_ROAR_BLOCK_PLACE = registerSoundEvents("dragon_roar_block_place");
    public static final RegistryObject<SoundEvent> DRAGON_ROAR_BLOCK_HIT = registerSoundEvents("dragon_roar_block_hit");

    public static final RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvents("bar_brawl");

    public static final RegistryObject<SoundEvent> EERIE_EXPERIMENT = registerSoundEvents("eerie_experiment");
    public static final RegistryObject<SoundEvent> NEITHER_AMBIENT = registerSoundEvents("neither_ambient");
    public static final RegistryObject<SoundEvent> RANDOM_SOUND = registerSoundEvents("random_sound");

    public static final ForgeSoundType DRAGON_ROAR_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.DRAGON_ROAR_BLOCK_BREAK,
            ModSounds.DRAGON_ROAR_BLOCK_STEP,
            ModSounds.DRAGON_ROAR_BLOCK_FALL,
            ModSounds.DRAGON_ROAR_BLOCK_PLACE,
            ModSounds.DRAGON_ROAR_BLOCK_HIT);


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(NetherSpace.MOD_ID, name)));
    }


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
