package com.godhenko.narutorevival.projectile;

import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.List;

public class FireBulletProjectile extends JutsuProjectile {
    private Float circleXrot = null;
    private Float circleYrot = null;

    public FireBulletProjectile(EntityType<FireBulletProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public FireBulletProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends JutsuProjectile>) ModRegistry.FIRE_BULLET_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public FireBulletProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        circleXrot = owner.getXRot();
        circleYrot = owner.getYRot();
        this.setRot(circleXrot, circleYrot);
    }

    public FireBulletProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (this.level.isClientSide()) return;

        boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
        this.level.explode(getOwner(), getX(), getY(), getZ(), 1, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
        List<Entity> entities = level.getEntities(getOwner(), new AABB(getX()-6, getY()-6, getZ()-6, getX()+6, getY()+6, getZ()+6));
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity living) {
                living.hurt(ModRegistry.fireSource(getOwner()), 3);
            }
        }
        this.discard();
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

        JutsuHelper.spawnCircleParticles(level, ParticleTypes.FLAME, getCircleXrot(), getCircleYrot(), getX(), getY()+getBbHeight()/2, getZ(), 0, 0, 0, 0.1, 0.25, 0, 30);

        decreaseSpeed(1000);
    }

    private float getCircleXrot() {
        return (circleXrot == null) ? getXRot() : circleXrot;
    }

    private float getCircleYrot() {
        return (circleYrot == null) ? getYRot() : circleYrot;
    }
}
