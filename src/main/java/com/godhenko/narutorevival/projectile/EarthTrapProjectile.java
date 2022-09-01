package com.godhenko.narutorevival.projectile;

import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.jutsus.jutsus.FreezeTimer;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuHelper;
import com.godhenko.narutorevival.jutsus.jutsus.JutsuTicker;
import com.mojang.math.Vector3f;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class EarthTrapProjectile extends JutsuProjectile {
    private Float circleXrot = null;
    private Float circleYrot = null;
    private static final ParticleOptions DUST_PARTICLE = new DustParticleOptions(new Vector3f(227/255f, 220/255f, 175/255f), 1);

    public EarthTrapProjectile(EntityType<EarthTrapProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public EarthTrapProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends JutsuProjectile>) ModRegistry.EARTH_TRAP_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public EarthTrapProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        circleXrot = owner.getXRot();
        circleYrot = owner.getYRot();
        this.setRot(circleXrot, circleYrot);
    }

    public EarthTrapProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.level.isClientSide()) return;

        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255));
            level.addFreshEntity(new EvokerFangs(level, living.getX(), living.getY(), living.getZ(), living.getYRot(), 2, null));

            if (living instanceof Player player) {
                FreezeTimer timer = new FreezeTimer(player.getLevel(), player.getUUID(), player.getX(), player.getY(), player.getZ(), 100);
                JutsuTicker.freeze(timer);
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.xPower /= 2;
        this.yPower /= 2;
        this.zPower /= 2;
    }

    @Override
    public void tick() {
        super.tick();

        JutsuHelper.spawnCircleParticles(level, DUST_PARTICLE, getCircleXrot(), getCircleYrot(), getX(), getY()+getBbHeight()/2, getZ(), 0, 0, 0, 0, 1, 0, 16);

        decreaseSpeed(150);
    }

    private float getCircleXrot() {
        return (circleXrot == null) ? getXRot() : circleXrot;
    }

    private float getCircleYrot() {
        return (circleYrot == null) ? getYRot() : circleYrot;
    }
}
