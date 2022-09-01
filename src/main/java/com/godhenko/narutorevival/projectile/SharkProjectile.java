package com.godhenko.narutorevival.projectile;

import com.godhenko.narutorevival.inits.ModRegistry;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class SharkProjectile extends JutsuProjectile {
    private Float oXrot = null;
    private Float oYrot = null;

    public SharkProjectile(EntityType<SharkProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public SharkProjectile(double x, double y, double z, double xPower, double yPower, double zPower, Level world) {
        super((EntityType<? extends JutsuProjectile>) ModRegistry.SHARK_PROJECTILE.get(), x, y, z, xPower, yPower, zPower, world);
    }

    public SharkProjectile(LivingEntity owner, double xPower, double yPower, double zPower, Level world) {
        this(owner.getX()+owner.getLookAngle().x, owner.getY()+owner.getEyeHeight()/2+owner.getLookAngle().y, owner.getZ()+owner.getLookAngle().z, xPower, yPower, zPower, world);
        this.setOwner(owner);
        oXrot = owner.getXRot();
        oYrot = owner.getYRot();
        this.setRot(oXrot, oYrot);
    }

    public SharkProjectile(LivingEntity owner, double power, Level world) {
        this(owner, owner.getLookAngle().scale(power).x, owner.getLookAngle().scale(power).y, owner.getLookAngle().scale(power).z, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.level.isClientSide()) return;

        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity living) {
            living.hurt(ModRegistry.sharkSource(getOwner()), 10);
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
