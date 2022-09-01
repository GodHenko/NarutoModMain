package com.godhenko.narutorevival.inits;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuItem;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.EarthOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.EarthTwoJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireTwoJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.LightningOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.LightningTwoJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves.WaterOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.WindOneJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.WindTwoJutsu;
import com.godhenko.narutorevival.projectile.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, NarutoRevival.NAMESPACE);

    public static final RegistryObject<EntityType<?>> AIR_BURST_PROJECTILE = ENTITIES.register("air_burst", () ->
            EntityType.Builder.<AirBurstProjectile>of(AirBurstProjectile::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .setTrackingRange(10)
                    .build("air_burst")
    );
    public static final RegistryObject<EntityType<?>> FIRE_BULLET_PROJECTILE = ENTITIES.register("fire_bullet", () ->
            EntityType.Builder.<FireBulletProjectile>of(FireBulletProjectile::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .setTrackingRange(10)
                    .build("fire_bullet")
    );

    public static final RegistryObject<EntityType<?>> EARTH_TRAP_PROJECTILE = ENTITIES.register("earth_trap", () ->
            EntityType.Builder.<EarthTrapProjectile>of(EarthTrapProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .setTrackingRange(10)
                    .build("earth_trap")
    );

    public static final RegistryObject<EntityType<FireballProjectile>> FIREBALL_PROJECTILE = ENTITIES.register("fireball", () ->
            EntityType.Builder.<FireballProjectile>of(FireballProjectile::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .setTrackingRange(10)
                    .build("fireball")
    );
    public static final RegistryObject<EntityType<GreatFireballProjectile>> GREAT_FIREBALL_PROJECTILE = ENTITIES.register("greatfireball", () ->
            EntityType.Builder.<GreatFireballProjectile>of(GreatFireballProjectile::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .setTrackingRange(10)
                    .build("greatfireball")
    );

    public static final RegistryObject<EntityType<LightningBallProjectile>> LIGHTNING_BALL_PROJECTILE = ENTITIES.register("lightning_ball", () ->
            EntityType.Builder.<LightningBallProjectile>of(LightningBallProjectile::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .setTrackingRange(10)
                    .build("lightning_ball")
    );

    public static final RegistryObject<EntityType<SharkProjectile>> SHARK_PROJECTILE = ENTITIES.register("shark", () ->
            EntityType.Builder.<SharkProjectile>of(SharkProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .setTrackingRange(10)
                    .build("shark")
    );

    public static DamageSource stunSource(Entity entity) {
        return new EntityDamageSource("stun_jutsu", entity).setMagic().bypassArmor();
    }

    public static DamageSource sharkSource(Entity entity) {
        return new EntityDamageSource("shark_jutsu", entity).setMagic().bypassArmor();
    }

    public static DamageSource fireSource(Entity entity) {
        return new EntityDamageSource("fire_jutsu", entity).setMagic().bypassArmor();
    }
}
