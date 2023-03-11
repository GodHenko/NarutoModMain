package com.godhenko.narutorevival.projectile;

import com.godhenko.narutorevival.inits.ModRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class IceNeedlesProjectile extends SpellProjectile {
    private Float oXrot = null;
    private Float oYrot = null;

    public IceNeedlesProjectile(EntityType<IceNeedlesProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public IceNeedlesProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends SpellProjectile>) ModRegistry.ICE_NEEDLES_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public IceNeedlesProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        oXrot = owner.getXRot();
        oYrot = owner.getYRot();
        this.setRot(oXrot, oYrot);
    }

    public IceNeedlesProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.level.isClientSide()) return;

        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity living) {
            living.hurt(DamageSource.GENERIC, 6);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!level.getBlockState(pResult.getBlockPos()).is(Blocks.WATER)) {
            this.xPower /= 1.5;
            this.yPower /= 1.5;
            this.zPower /= 1.5;
        }
    }

    @Override
    public void tick() {
        super.tick();

        decreaseSpeed(24);
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.BUBBLE;
    }

    @Override
    public float getXRot() {
        return (oXrot == null) ? super.getXRot() : oXrot;
    }

    @Override
    public float getYRot() {
        return (oYrot == null) ? super.getYRot() : oYrot;
    }
}
