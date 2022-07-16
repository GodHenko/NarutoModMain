package com.godhenko.narutomod.api.attribute;
import java.util.UUID;
import com.godhenko.narutomod.api.Limit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public class IPlayerAttribute{

    /**
     * These are used to define the behaviour of the attribute. See docs for detailed information.
     */
    public enum Type {
        GAME, DATA, ALL;
    }

    /**
     * @return The attributes data behaviour; can also be used to differentiate between loot attributes and data attributes.
     */
    public Type type();

    /**
     * @return The attributes UUID, used to define it.
     */
    public UUID uuid();

    /**
     * @return The attributes Limit instance, available for external use by modders.
     */
    Limit limit();

    /**
     * @return Should be in the format of (YourMod.MODID, "name_of_attribute"). Example: {@link PlayerAttributes#CONSTITUTION} is (ExAPI.MODID, "constitution").
     */
    public ResourceLocation registryName();

    /**
     * @return The attribute object based on {@link #type()}. This should be a get() method from a Supplier.
     */
    public Attribute get();
}