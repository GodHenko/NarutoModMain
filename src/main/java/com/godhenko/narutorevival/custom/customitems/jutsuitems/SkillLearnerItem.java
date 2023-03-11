package com.godhenko.narutorevival.custom.customitems.jutsuitems;

import com.godhenko.narutorevival.network.extra.Stats;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SkillLearnerItem extends Item {
    private final JutsuType jutsuType;
    private final ArrayList<JutsuItem> items = new ArrayList<>();

    @SafeVarargs
    public SkillLearnerItem(JutsuType spellType, Supplier<JutsuItem>... items) {
        super(new Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC));
        this.jutsuType = spellType;

        for (Supplier<JutsuItem> supplier : items) {
            this.items.add(supplier.get());
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        String owner = nbtGetOwner(stack);
        int lastUse = nbtGetLastUse(stack);

        if (lastUse >= items.size() - 1 || owner == null || !owner.equals(player.getName().getString()) || world.isClientSide()) {
            return InteractionResultHolder.pass(stack);
        }

        JutsuItem item = items.get(++lastUse);
        ItemStack itemStack = new ItemStack(item, 1);

        int skillPointCost = item.getJutsu().skillPointCost();
        System.out.println(item.getJutsu().getClass().getName());
        if (!Stats.JP.get().getManager().decreaseIfEnough(player, skillPointCost)) {
            return InteractionResultHolder.pass(stack);
        }

        if (!player.getInventory().add(itemStack)) {
            return InteractionResultHolder.pass(stack);
        }

        nbtSetLastUse(stack, lastUse);

        return InteractionResultHolder.success(stack);
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        float lastUse = (float) nbtGetLastUse(stack);
        float usePercentage = (lastUse + 1) / items.size();
        float barWidth = (1 - usePercentage) * 13;

        return Math.round(barWidth);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        float lastUse = (float) nbtGetLastUse(stack);
        return lastUse >= 0;
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return jutsuType.getColor().getColor();
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

    private static int nbtGetLastUse(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains("lastUse")) {
            return tag.getInt("lastUse");
        } else return -1;
    }

    private static void nbtSetLastUse(ItemStack stack, Integer lastuse) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("lastUse", lastuse);
        stack.setTag(tag);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int p_41407_, boolean p_41408_) {
        if (nbtGetOwner(stack) == null && entity instanceof Player player) {
            nbtSetOwner(stack, player.getName().getString());
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        // Owner: Player
        String owner = nbtGetOwner(stack);
        if (owner != null) {
            tooltip.add(new TranslatableComponent("other.narutorevival.owner")
                    .setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA))
                    .append(owner));
        }

        // Next Move:
        int uses = nbtGetLastUse(stack) + 1;
        if (uses < items.size()) {
            int skillPointCost = items.get(uses).getJutsu().skillPointCost();
            String id = items.get(uses).getDescriptionId();
            tooltip.add(new TranslatableComponent("other.narutorevival.nextjutsu")
                    .append(new TranslatableComponent(id))
                    .append(new TextComponent(" (" + skillPointCost + " SP)").setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA)))
            );
        }

        // Uses:
        if (uses > 0) {
            MutableComponent usesText = new TextComponent(uses + "/" + items.size())
                    .setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA));
            tooltip.add(new TranslatableComponent("other.narutorevival.uses").append(usesText));
        }

        // Type: SpellType
        MutableComponent typeText = new TranslatableComponent("jutsu.narutorevival." + jutsuType.getName())
                .setStyle(Style.EMPTY.withColor(jutsuType.getColor()));
        tooltip.add(new TranslatableComponent("other.narutorevival.type").append(typeText));
    }
}
