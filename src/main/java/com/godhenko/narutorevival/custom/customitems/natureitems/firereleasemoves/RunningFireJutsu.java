package com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves;

import com.godhenko.narutorevival.chakra.ChakraManager;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.Jutsu;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RunningFireJutsu implements Jutsu {

    @Override
    public int jutsuLevel() {
        return 1;
    }

    @Override
    public JutsuType jutsuType() {
        return JutsuType.FIRE;
    }

    @Override
    public InteractionResult cast(Player player, Level world) {
        if (world.isClientSide()) {
            return InteractionResult.PASS;
        }

        if (!ChakraManager.decreaseChakraIfEnough(player, chakraCost(player, world))) {
            return InteractionResult.PASS;
        }

        JutsuHelper.spawnCircleParticles(world, ParticleTypes.FLAME, Direction.Axis.Y, player.getX(), player.getY()+1, player.getZ(), 0.0, 0.0, 0.0, 0.0, 3.0, 64);
        JutsuHelper.spawnCircleParticles(world, ParticleTypes.FLAME, Direction.Axis.X, player.getX(), player.getY()+1, player.getZ(), 0.0, 0.0, 0.0, 0.0, 3.0, 64);
        JutsuHelper.spawnCircleParticles(world, ParticleTypes.FLAME, Direction.Axis.Z, player.getX(), player.getY()+1, player.getZ(), 0.0, 0.0, 0.0, 0.0, 3.0, 64);

        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 80));

        List<Entity> entities = world.getEntities(player, new AABB(player.getX()-6, player.getY()-5, player.getZ()-6, player.getX()+6, player.getY()+5, player.getZ()+6));
        for (Entity entity : entities) {
            if (entity.fireImmune()) continue;
            entity.setSecondsOnFire(5);
            entity.hurt(ModRegistry.fireSource(player), 4);
        }

        BlockPos playerPos = new BlockPos(player.getX(), player.getY(), player.getZ());
        Iterable<BlockPos> blockPoses = BlockPos.betweenClosed(playerPos.offset(-3, -3, -3), playerPos.offset(3, 3, 3));
        for (BlockPos pos : blockPoses) {
            if (world.getBlockState(pos).isAir() && pos.distToCenterSqr(playerPos.getX(), player.getY(), player.getZ()) > 3) {
                world.setBlockAndUpdate(pos, Blocks.FIRE.defaultBlockState());
            }
        }

        return InteractionResult.SUCCESS;
    }

    public int attackDamage() {
        return 4 ;
    }

    @Override
    public void tick(Player player, Level world) {

    }

    @Override
    public Jutsu init() {
        return this;
    }
}
