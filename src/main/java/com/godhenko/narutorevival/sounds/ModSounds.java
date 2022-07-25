package com.godhenko.narutorevival.sounds;

import com.godhenko.narutorevival.NarutoRevival;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NarutoRevival.MOD_ID);

    public static RegistryObject<SoundEvent> NINJA_HURT_SFX = registerSoundEvents("ninja_hurt_sfx");
    public static RegistryObject<SoundEvent> NINJA_DEATH_SFX = registerSoundEvents("ninja_death_sfx");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(NarutoRevival.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
