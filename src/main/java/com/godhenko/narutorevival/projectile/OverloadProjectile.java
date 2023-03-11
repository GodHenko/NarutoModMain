package com.godhenko.narutorevival.projectile;


import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class OverloadProjectile extends SpellProjectile {
    private Float circleXrot = null;
    private Float circleYrot = null;

    public OverloadProjectile(EntityType<OverloadProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public OverloadProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends SpellProjectile>) ModRegistry.OVERLOAD_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public OverloadProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        circleXrot = owner.getXRot();
        circleYrot = owner.getYRot();
        this.setRot(circleXrot, circleYrot);
    }

    public OverloadProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.level.isClientSide()) return;

        Entity entity = pResult.getEntity();
        if (this.getPassengers().isEmpty() && entity.startRiding(this)) {
            this.yPower = 0.065f;
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        explode();
    }

    private void explode() {
        JutsuHelper.spawnParticles(level, ParticleTypes.EXPLOSION, getX(), getY()+getEyeHeight(), getZ(), 0, 0, 0, 1, 16);

        for (Entity entity : this.getPassengers()) {
            if (entity instanceof LivingEntity living) {
                //todo
                living.hurt(DamageSource.GENERIC, 10f);
            }
        }

        this.ejectPassengers();

        this.discard();
    }

    @Override
    public void tick() {
        super.tick();

        decreaseSpeed(14);
    }

    @Override
    protected void discardLowSpeed() {
        explode();
    }

    private float getCircleXrot() {
        return (circleXrot == null) ? getXRot() : circleXrot;
    }

    private float getCircleYrot() {
        return (circleYrot == null) ? getYRot() : circleYrot;
    }
}
