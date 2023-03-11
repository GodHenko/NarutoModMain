package com.godhenko.narutorevival.custom.customitems.jutsuitems;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.network.extra.util.LevelingHelper;
import com.godhenko.narutorevival.network.extra.util.Range;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JutsuItem extends Item {
    private final JutsuType jutsuType;
    private final int jutsuLevel;
    private final Jutsu jutsu;

    public JutsuItem(Jutsu jutsu) {
        super(new Item.Properties().tab(NarutoRevival.JUTSU_TAB).stacksTo(1).rarity(Rarity.EPIC));

        this.jutsuType = jutsu.jutsuType();
        this.jutsuLevel = jutsu.jutsuLevel();
        this.jutsu = jutsu;
    }

    public Jutsu getJutsu() {
        return jutsu;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return getSpellLevel(stack) > 0;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        String owner = nbtGetOwner(stack);

        if (owner == null || !owner.equals(player.getName().getString()) || jutsu == null) {
            return InteractionResultHolder.pass(stack);
        }

        int jutsuLevel = getSpellLevel(stack);
        InteractionResult result = jutsu.cast(player, world, jutsuLevel + 1);

        if (result.shouldAwardStats()) {
            int exp = nbtGetExp(stack);
            nbtSetExp(stack, ++exp);
        }

        return new InteractionResultHolder<>(result, stack);
    }

    public static int getSpellLevel(ItemStack stack) {
        int exp = nbtGetExp(stack);
        return LevelingHelper.byRanges(NarutoRevival.JUTSU_LEVEL_RANGES, exp);
    }

    private static String nbtGetOwner(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains("jutsuOwner")) {
            return tag.get("jutsuOwner").getAsString();
        } else return null;
    }

    private static int nbtGetExp(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains("jutsuExp")) {
            return tag.getInt("jutsuExp");
        } else return 0;
    }

    private static void nbtSetOwner(ItemStack stack, String owner) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("jutsuOwner", owner);
        stack.setTag(tag);
    }

    private static void nbtSetExp(ItemStack stack, int level) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("jutsuExp", level);
        stack.setTag(tag);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int p_41407_, boolean p_41408_) {
        if (nbtGetOwner(stack) == null && entity instanceof Player player) {
            nbtSetOwner(stack, player.getName().getString());
        }
    }

    private float getLevelPercentage(ItemStack stack) {
        int level = getSpellLevel(stack);
        Range range = NarutoRevival.JUTSU_LEVEL_RANGES.get(level);
        float uses = (float) nbtGetExp(stack);

        return (uses - range.from()) / (range.to() - range.from());

    }

    @Override
    public int getBarWidth(ItemStack stack) {
        float levelPercentage = getLevelPercentage(stack);
        float barWidth = levelPercentage * 13;

        return Math.round(barWidth);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return getSpellLevel(stack) != NarutoRevival.JUTSU_LEVEL_RANGES.size() - 1;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return jutsuType.getColor().getColor();
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

        // Level:
        int level = getSpellLevel(stack);
        int levelPercentage = (int) Math.floor(getLevelPercentage(stack) * 100);
        MutableComponent levelText = new TranslatableComponent("jutsu.narutorevival.level." + level)
                .setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA));
        MutableComponent levelPercentageText = new TextComponent(" (" + levelPercentage + "%)");
        MutableComponent finalLevelText = new TranslatableComponent("other.narutorevival.level").append(levelText);
        if (isBarVisible(stack)) finalLevelText.append(levelPercentageText);
        tooltip.add(finalLevelText);

        // Type: SpellType
        MutableComponent typeText = new TranslatableComponent("jutsu.narutorevival." + jutsuType.getName())
                .setStyle(Style.EMPTY.withColor(jutsuType.getColor()));
        tooltip.add(new TranslatableComponent("other.narutorevival.type").append(typeText));

        // Damage:
        int damage = jutsu.attackDamage(level);
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
