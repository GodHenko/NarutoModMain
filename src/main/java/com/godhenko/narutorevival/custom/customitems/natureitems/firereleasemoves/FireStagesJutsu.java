package com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves;

import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import com.godhenko.narutorevival.network.extra.Stats;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class FireStagesJutsu implements Jutsu {
    private static final HashMap<Player, Integer> stages = new HashMap<>();
    private static final HashMap<Integer, HashMap<MobEffect, Integer>> stageEffects = new HashMap<>();

    @Override
    public int jutsuLevel() {
        return 3;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.FIRE;
    }

    @Override
    public InteractionResult cast(Player player, Level world, int level) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        int stage = -1;
        if (stages.containsKey(player)) {
            stage = stages.get(player);
        }

        if (player.isShiftKeyDown() && stage >= 0) {
            stopSpellUse(player);
            return InteractionResult.PASS;
        }

        if (++stage == stageEffects.size()) {
            return InteractionResult.PASS;
        }

        if (!player.isCreative() && ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new NarutoRevivalModVariables.PlayerVariables())).Lvl) < (stage + 1) * 10) {
            player.displayClientMessage(new TranslatableComponent("other.Narutorevival.fire_iii.not_level_ten", (stage + 1) * 10), true);
            return InteractionResult.PASS;
        }

        if (!Stats.CHAKRA.get().getManager().decreaseIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        player.displayClientMessage(new TranslatableComponent("other.Narutorevival.fire_iii.activated"), true);

        stopSpellUse(player);

        player.hurt(DamageSource.MAGIC, 1.0f);
        stages.put(player, stage);

        for (Map.Entry<MobEffect, Integer> effect : stageEffects.get(stage).entrySet()) {
            player.addEffect(new MobEffectInstance(effect.getKey(), 1000000, effect.getValue()));
        }

        JutsuTicker.startTicking(this, player);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void tick(Player player, Level world) {
        int stage = stages.get(player);

        if (JutsuHelper.doOverTime(player, ( 10 - (stage*3) ))) {
            player.hurt(DamageSource.MAGIC, 2f);
            if (player.isDeadOrDying()) {
                stopSpellUse(player);
            }
        }
    }

    private void stopSpellUse(Player player) {
        if (!stages.containsKey(player)) {
            return;
        }

        int stage = stages.get(player);

        HashMap<MobEffect, Integer> effects = stageEffects.get(stage);
        for (MobEffect effect : effects.keySet()) {
            player.removeEffect(effect);
        }

        JutsuTicker.stopTicking(this, player);
        stages.remove(player);
    }

    @Override
    public Jutsu init() {
        HashMap<MobEffect, Integer> levelOneEffects = new HashMap<>();
        levelOneEffects.put(MobEffects.DAMAGE_BOOST, 0);

        HashMap<MobEffect, Integer> levelTwoEffects = new HashMap<>();
        levelTwoEffects.put(MobEffects.DAMAGE_BOOST, 0);
        levelTwoEffects.put(MobEffects.MOVEMENT_SPEED, 0);

        HashMap<MobEffect, Integer> levelThreeEffects = new HashMap<>();
        levelThreeEffects.put(MobEffects.DAMAGE_BOOST, 0);
        levelThreeEffects.put(MobEffects.MOVEMENT_SPEED, 1);

        HashMap<MobEffect, Integer> levelFourEffects = new HashMap<>();
        levelFourEffects.put(MobEffects.DAMAGE_BOOST, 2);
        levelFourEffects.put(MobEffects.MOVEMENT_SPEED, 2);

        stageEffects.put(0, levelOneEffects);
        stageEffects.put(1, levelTwoEffects);
        stageEffects.put(2, levelThreeEffects);
        stageEffects.put(3, levelFourEffects);

        JutsuTicker.registerPlayerTicker(this);

        return this;
    }

}
