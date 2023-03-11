package com.godhenko.narutorevival.jutsus.jutsus;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;

public class JutsuHelper {
    private static final HashMap<String, Double> doOverTime = new HashMap<>();

    public static void spawnParticles(Level world, ParticleOptions particle, double x, double y, double z, double xd, double yd, double zd, double speed, int count) {
        if (world.isClientSide()) {
            return;
        }

        for (Player player : world.getServer().getPlayerList().getPlayers()) {
            for (int i = 0; i <= count; i++) {
                ((ServerLevel) world).sendParticles((ServerPlayer) player, particle, false, x, y, z, count, xd, yd, zd, speed);
            }
        }
    }

    public static void spawnCircleParticles(Level world, ParticleOptions particle, Direction.Axis axis, double x, double y, double z, double xd, double yd, double zd, double speed, double radius, int count) {
        switch (axis) {
            case X -> {
                for (double i = 0; i < (2 * Math.PI); i += ((2 * Math.PI) / count)) {
                    double pz = z + radius * Math.cos(i);
                    double py = y + radius * Math.sin(i);
                    spawnParticles(world, particle, x, py, pz, xd, yd, zd, speed, 1);
                }
            }
            case Y -> {
                for (double i = 0; i < (2 * Math.PI); i += ((2 * Math.PI) / count)) {
                    double px = x + radius * Math.cos(i);
                    double pz = z + radius * Math.sin(i);
                    spawnParticles(world, particle, px, y, pz, xd, yd, zd, speed, 1);
                }
            }
            case Z -> {
                for (double i = 0; i < (2 * Math.PI); i += ((2 * Math.PI) / count)) {
                    double px = x + radius * Math.cos(i);
                    double py = y + radius * Math.sin(i);
                    spawnParticles(world, particle, px, py, z, xd, yd, zd, speed, 1);
                }
            }
        }
    }

    public static void spawnCircleParticles(Level world, ParticleOptions particle, float pitch, float yaw, double x, double y, double z, double xd, double yd, double zd, double speed, double radius, float distance, int count) {
        Vec3 lookVector = Vec3.directionFromRotation(pitch, yaw);

        if (lookVector.z == 0) {
            lookVector = lookVector.add(0, 0, 0.01);
        }

        if (distance != 0) {
            lookVector = lookVector.scale(distance);
        }

        Vec3 perpendicularVector = new Vec3(1, 1, (-lookVector.x-lookVector.y)/lookVector.z).normalize().scale(radius);
        Vec3 sumVector = lookVector.add(perpendicularVector);

        yaw = (float) Math.toRadians(yaw);
        pitch = (float) Math.toRadians(pitch);

        for (float i = 0; i < (2 * Math.PI); i += ((2 * Math.PI) / count)) {
            Vec3 particleVector = sumVector;

            particleVector = particleVector.yRot(yaw);
            particleVector = particleVector.xRot(pitch);
            particleVector = particleVector.zRot(i);
            particleVector = particleVector.xRot(-pitch);
            particleVector = particleVector.yRot(-yaw);

            spawnParticles(world, particle, particleVector.x+x, particleVector.y+y, particleVector.z+z, xd, yd, zd, speed, 1);
        }
    }

    public static BlockHitResult raycast(Level world, Player player, int rayLength) {
        Vec3 eyePos = new Vec3(player.getX(), player.getY()+player.getEyeHeight(), player.getZ());
        Vec3 lookVec = player.getLookAngle();
        Vec3 rayVec = eyePos.add(lookVec.scale(rayLength));

        ClipContext clipContext = new ClipContext(eyePos, rayVec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, null);

        return world.clip(clipContext);
    }

    public static EntityHitResult raycastEntity(Level world, Player player, int rayLength) {
        Vec3 eyePos = new Vec3(player.getX(), player.getY()+player.getEyeHeight(), player.getZ());
        Vec3 lookVec = player.getLookAngle();
        Vec3 rayVec = eyePos.add(lookVec.scale(rayLength));

        EntityHitResult result = ProjectileUtil.getEntityHitResult(world, player, eyePos, rayVec, new AABB(eyePos, rayVec), (entity) -> true);

        return result;
    }

    public static boolean doOverTime(Player player, double seconds) {
        String name = player.getName().getString();

        if (!doOverTime.containsKey(name)) {
            doOverTime.put(name, 0.0d);
            return false;
        }

        double current = doOverTime.get(name);
        current += 0.05d / seconds;

        if (current >= 1d) {
            doOverTime.put(name, 0.0d);
            return true;
        } else {
            doOverTime.put(name, current);
            return false;
        }
    }
}
