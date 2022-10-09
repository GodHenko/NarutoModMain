package com.godhenko.narutorevival.custom.customitems.jutsuitems;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JutsuItem extends Item {
    private final JutsuType jutsuType;
    private final boolean isJutsuLevelTwo;
    private final int jutsuLevel;

    private final Jutsu jutsu;

    public JutsuItem(Jutsu jutsu) {
        super(new Item.Properties().tab(NarutoRevival.NATURES_TAB).stacksTo(1).rarity(Rarity.EPIC));

        this.jutsuType = jutsu.jutsuType();
        this.jutsuLevel = jutsu.jutsuLevel();
        this.isJutsuLevelTwo = this.jutsuLevel == 2;
        this.jutsu = jutsu;
    }

    public Jutsu getJutsu() {
        return jutsu;
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return isJutsuLevelTwo;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        String owner = nbtGetOwner(stack);

        if (owner == null || !owner.equals(player.getName().getString()) || jutsu == null || world.isClientSide()) {
            return InteractionResultHolder.pass(stack);
        }

        InteractionResult result = jutsu.cast(player, world);
        return new InteractionResultHolder<>(result, stack);
    }

    private static String nbtGetOwner(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains("jutsuOwner")) {
            return tag.get("jutsuOwner").getAsString();
        } else return null;
    }

    private static void nbtSetOwner(ItemStack stack, String owner) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("jutsuOwner", owner);
        stack.setTag(tag);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int p_41407_, boolean p_41408_) {
        if (nbtGetOwner(stack) == null && entity instanceof Player player) {
            nbtSetOwner(stack, player.getName().getString());
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        // Owner: Player
        String owner = nbtGetOwner(stack);
        if (owner != null) {
            tooltip.add(new TranslatableComponent("other.narutorevival.owner")
                    .setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA))
                    .append(owner));
        }

        // Type: jutsuType
        MutableComponent typeText = new TranslatableComponent("jutsu.narutorevival." + jutsuType.getName())
                .setStyle(Style.EMPTY.withColor(jutsuType.getColor()));
        tooltip.add(new TranslatableComponent("other.narutorevival.type").append(typeText));

        // Level: I/II
        MutableComponent levelText = new TextComponent(isJutsuLevelTwo ? "II" : "I")
                .setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA));
        tooltip.add(new TranslatableComponent("other.narutorevival.level").append(levelText));

        // Damage:

        int damage = jutsu.attackDamage();
        if (damage > 0) {
            MutableComponent damageText = new TextComponent(damage/2 + "❤")
                    .setStyle(Style.EMPTY.withColor(ChatFormatting.RED));
            tooltip.add(new TranslatableComponent("other.narutorevival.damage").append(damageText));
        }

        // Chakra:
        int chakra = jutsu.chakraCost(null, world);
        MutableComponent manaText = new TextComponent(String.valueOf(chakra))
                .setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA));
        tooltip.add(new TranslatableComponent("other.narutorevival.chakra").append(manaText));

        // Description
        tooltip.add(new TranslatableComponent(this.getDescriptionId() + ".desc")
                .setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
    }
}
