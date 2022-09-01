package com.godhenko.narutorevival.projectile;

import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class AirBurstProjectile extends JutsuProjectile {
    private Float circleXrot = null;
    private Float circleYrot = null;

    public AirBurstProjectile(EntityType<AirBurstProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public AirBurstProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends JutsuProjectile>) ModRegistry.AIR_BURST_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public AirBurstProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        circleXrot = owner.getXRot();
        circleYrot = owner.getYRot();
        this.setRot(circleXrot, circleYrot);
    }

    public AirBurstProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.level.isClientSide()) return;

        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity living) {
            living.knockback(2, -this.xPower, -this.zPower);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.xPower /= 1.5;
        this.yPower /= 1.5;
        this.zPower /= 1.5;
    }

    @Override
    public void tick() {
        super.tick();

        JutsuHelper.spawnCircleParticles(level, ParticleTypes.CLOUD, getCircleXrot(), getCircleYrot(), getX(), getY()+getBbHeight()/2, getZ(), 0, 0, 0, 0, 2, 0, 16);

        decreaseSpeed(300);
    }

    private float getCircleXrot() {
        return (circleXrot == null) ? getXRot() : circleXrot;
    }

    private float getCircleYrot() {
        return (circleYrot == null) ? getYRot() : circleYrot;
    }
}
