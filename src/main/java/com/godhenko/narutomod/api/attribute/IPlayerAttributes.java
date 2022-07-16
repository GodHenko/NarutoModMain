package com.godhenko.narutomod.api.attribute;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;

public class IPlayerAttributes{

    /**
     * @param par0 Player.
     * @return A coefficient from 0 to 1 that multiplies with experience to tell us how close we are to the next level.
     */
    public double expCoeff(Player par0);

    /**
     * @param par0 PlayerEntity instance.
     * @param par1 Input IPlayerAttribute instance.
     * @return The total value (including any modifiers) for the input IPlayerAttribute instance.
     */
    public double get(Player par0, IPlayerAttribute par1);

    /**
     * Adds/subtracts the input value to the attribute.
     * Also runs all registered adders for this attribute AFTER the addition is made - see: {@link PlayerAttributes#registerAdder(net.minecraft.util.ResourceLocation, java.util.function.BiConsumer)}
     * @param par0 PlayerEntity instance.
     * @param par1 Input IPlayerAttribute instance.
     * @param par2 Amount to add (can be negative to subtract); is not clamped.
     */
    public void add(Player par0, IPlayerAttribute par1, double par2);

    /**
     * Similar to {@link #add(PlayerEntity, IPlayerAttribute, double)}, but directly sets the IPlayerAttribute's value to the input, and does not run any registered adders.
     * @param par0 PlayerEntity instance.
     * @param par1 Input IPlayerAttribute instance.
     * @param par2 Amount to set; is not clamped.
     */
    void forceSet(Player par0, IPlayerAttribute par1, double par2);

    /**
     * Applies the input AttributeModifier to the input IPlayerAttribute. The modifier will remain active until it is removed with {@link #removeModifier(PlayerEntity, IPlayerAttribute, AttributeModifier)}.
     * If the input AttributeModifier already exists and is already applied, this does not override or reapply the currenly active one.
     * If the input AttributeModifier's value is changed; the modifier must be removed and then reapplied - attribute modifiers are not dynamic.
     * AttributeModifier's are differentiated based on their UUID's, but an effort should be made to have unique names as well.
     * @param par0 PlayerEntity instance.
     * @param par1 IPlayerAttribute instance.
     * @param par2 AttributeModifier input.
     * @return the capability instance (pass-through).
     */
    IPlayerAttributes applyModifier(Player par0, IPlayerAttribute par1, AttributeModifier par2);

    /**
     * Removes the input AttributeModifier if it exists.
     * @param par0 PlayerEntity instance.
     * @param par1 IPlayerAttribute instance.
     * @param par2 AttributeModifier input.
     * @return the capability instance (pass-through).
     */
    IPlayerAttributes removeModifier(Player par0, IPlayerAttribute par1, AttributeModifier par2);

    /**
     * @return The capabilities data. Dev's should AVOID using this.
     */
    public CompoundTag write();

    /**
     * Takes the input data and sets the capabilities data to it. Dev's should AVOID using this.
     * @param par0 Input data.
     */
    public void read(CompoundTag par0);
}