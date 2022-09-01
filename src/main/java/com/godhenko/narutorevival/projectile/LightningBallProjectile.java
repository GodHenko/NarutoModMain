package com.godhenko.narutorevival.projectile;

import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public class LightningBallProjectile extends JutsuProjectile  {
    public LightningBallProjectile(EntityType<LightningBallProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public LightningBallProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends JutsuProjectile>) ModRegistry.LIGHTNING_BALL_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public LightningBallProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        this.setRot(owner.getXRot(), owner.getYRot());
    }

    public LightningBallProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (this.level.isClientSide()) return;

        JutsuHelper.spawnParticles(level, ParticleTypes.CRIT, getX(), getY()+1, getZ(), 0, 0, 0, 0.5, 16);
        JutsuHelper.spawnCircleParticles(level, ParticleTypes.CRIT, Direction.Axis.Y, getX(), getY()+1, getZ(), 2, 0, 2, 0.5, 3, 64);
        JutsuHelper.spawnCircleParticles(level, ParticleTypes.CRIT, Direction.Axis.X, getX(), getY()+1, getZ(), 2, 0, 2, 0.5, 3, 64);
        JutsuHelper.spawnCircleParticles(level, ParticleTypes.CRIT, Direction.Axis.Z, getX(), getY()+1, getZ(), 2, 0, 2, 0.5, 3, 64);

        List<Entity> entities = level.getEntities(getOwner(), new AABB(getX()-6, getY()-6, getZ()-6, getX()+6, getY()+6, getZ()+6));
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity living) {
                living.hurt(ModRegistry.stunSource(getOwner()), 2);
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 255));
            }
        }

        this.discard();
    }

    @Override
    public void tick() {
        super.tick();

        decreaseSpeed(120);
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.ELECTRIC_SPARK;
    }
}
