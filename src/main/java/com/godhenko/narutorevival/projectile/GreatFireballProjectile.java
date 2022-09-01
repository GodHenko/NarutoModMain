package com.godhenko.narutorevival.projectile;

import com.godhenko.narutorevival.inits.ModRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.ForgeEventFactory;

public class GreatFireballProjectile extends JutsuProjectile {
    public GreatFireballProjectile(EntityType<GreatFireballProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public GreatFireballProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends JutsuProjectile>) ModRegistry.GREAT_FIREBALL_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public GreatFireballProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        this.setRot(owner.getXRot(), owner.getYRot());
    }

    public GreatFireballProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (this.level.isClientSide()) return;

        boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
        this.level.explode(getOwner(), getX(), getY(), getZ(), 10, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();

        decreaseSpeed(100);
    }
}
