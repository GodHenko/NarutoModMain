package com.godhenko.narutorevival.entity.jutsuprojectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;

public class FireBallJutsuEntity extends AbstractHurtingProjectile {

    public int time;
    public int lifespan = 70;
    public float explosionpower = 2;
    public static final float INITIAL_SCALE = 0.1f;
    public static final float GROW_SCALE = 1 - INITIAL_SCALE;
    public static final float GROW_TIME = 2 * 20;
    public static final float ENTITY_SIZE = 1.5f;


    public FireBallJutsuEntity(EntityType<? extends AbstractHurtingProjectile> p_36817_, double v, double v1, double v2, double v3, double v4, double v5, Level level) {
        super(p_36817_, level);
        this.moveTo(v, v1, v2, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        double d0 = Math.sqrt(v3 * v3 + v4 * v4 + v5 * v5);
        if (d0 != 0.0D) {
            this.xPower = v3 / d0 * 0.2D;
            this.yPower = v4 / d0 * 0.2D;
            this.zPower = v5 / d0 * 0.2D;
        }

    }
}
