package com.godhenko.narutorevival.projectile;

import com.godhenko.narutorevival.inits.ModRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.ForgeEventFactory;

public class FireDragonProjectile extends JutsuProjectile {
    private Float oXrot = null;
    private Float oYrot = null;

    public FireDragonProjectile(EntityType<FireDragonProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public FireDragonProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends JutsuProjectile>) ModRegistry.FIRE_DRAGON_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public FireDragonProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        oXrot = owner.getXRot();
        oYrot = owner.getYRot();
        this.setRot(oXrot, oYrot);
    }

    public FireDragonProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.level.isClientSide()) return;

        boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
        this.level.explode(getOwner(), getX(), getY(), getZ(), 4, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();
        decreaseSpeed(150);
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
