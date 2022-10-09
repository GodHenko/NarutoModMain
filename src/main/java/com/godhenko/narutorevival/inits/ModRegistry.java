package com.godhenko.narutorevival.inits;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuItem;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.JutsuType;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.SkillLearnerItem;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.EarthWallJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.SandTrapJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireBallJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireBulletJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.RunningFireJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.LightningBallJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.StaticForceJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves.SharkBulletJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves.WaterWallJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.AirBurstJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.WindForceJutsu;
import com.godhenko.narutorevival.projectile.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, NarutoRevival.NAMESPACE);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NarutoRevival.NAMESPACE);

    //Fire Jutsus
    public static final RegistryObject<Item> FIRE_BALL_JUTSU = ITEMS.register("fire_ball_jutsu", () -> new JutsuItem(new FireBallJutsu().init()));
    public static final RegistryObject<Item> RUNNING_FIRE_JUTSU = ITEMS.register("running_fire_jutsu", () -> new JutsuItem(new RunningFireJutsu().init()));
    public static final RegistryObject<Item> FIRE_BULLET_JUTSU = ITEMS.register("fire_bullet_jutsu", () -> new JutsuItem(new FireBulletJutsu().init()));

    //Earth Jutsus
    public static final RegistryObject<Item> EARTH_WALL_JUTSU = ITEMS.register("earth_wall_jutsu", () -> new JutsuItem(new EarthWallJutsu().init()));
    public static final RegistryObject<Item> SAND_TRAP_JUTSU = ITEMS.register("sand_trap_jutsu", () -> new JutsuItem(new SandTrapJutsu().init()));
    //Lightning
    public static final RegistryObject<Item> LIGHTNING_BALL_JUTSU = ITEMS.register("lightning_ball_jutsu", () -> new JutsuItem(new LightningBallJutsu().init()));
    public static final RegistryObject<Item> STATIC_FORCE_JUTSU = ITEMS.register("static_force_jutsu", () -> new JutsuItem(new StaticForceJutsu().init()));
    //Water
    public static final RegistryObject<Item> SHARK_BULLET_JUTSU = ITEMS.register("shark_bullet_jutsu", () -> new JutsuItem(new SharkBulletJutsu().init()));
    public static final RegistryObject<Item> WATER_WALL_JUTSU = ITEMS.register("water_wall_jutsu", () -> new JutsuItem(new WaterWallJutsu().init()));
    //Wind
    public static final RegistryObject<Item> GALE_STRIKE_JUTSU = ITEMS.register("gale_strike_jutsu", () -> new JutsuItem(new AirBurstJutsu().init()));
    public static final RegistryObject<Item> WIND_FORCE_JUTSU = ITEMS.register("wind_force_jutsu", () -> new JutsuItem(new WindForceJutsu().init()));


    //Learners
    public static final RegistryObject<Item> SKILL_LEARNER_EARTH = ITEMS.register("skill_learner_earth", () -> new SkillLearnerItem(JutsuType.EARTH,3, EARTH_WALL_JUTSU, SAND_TRAP_JUTSU));
    public static final RegistryObject<Item> SKILL_LEARNER_FIRE = ITEMS.register("skill_learner_fire", () -> new SkillLearnerItem(JutsuType.FIRE,3, FIRE_BALL_JUTSU, RUNNING_FIRE_JUTSU));
    public static final RegistryObject<Item> SKILL_LEARNER_LIGHTNING = ITEMS.register("skill_learner_lightning", () -> new SkillLearnerItem(JutsuType.LIGHTNING,3, STATIC_FORCE_JUTSU, LIGHTNING_BALL_JUTSU));
    public static final RegistryObject<Item> SKILL_LEARNER_WATER = ITEMS.register("skill_learner_water", () -> new SkillLearnerItem(JutsuType.WATER,3, WATER_WALL_JUTSU, SHARK_BULLET_JUTSU));
    public static final RegistryObject<Item> SKILL_LEARNER_WIND = ITEMS.register("skill_learner_wind", () -> new SkillLearnerItem(JutsuType.WIND,3, GALE_STRIKE_JUTSU, WIND_FORCE_JUTSU));





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
    public static final RegistryObject<EntityType<?>> PHOENIX_FIRE_PROJECTILE = ENTITIES.register("phoenix_fire", () ->
            EntityType.Builder.<PhoenixFireProjectile>of(PhoenixFireProjectile::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .setTrackingRange(10)
                    .build("phoenix_fire")
    );
    public static final RegistryObject<EntityType<FireDragonProjectile>> FIRE_DRAGON_PROJECTILE = ENTITIES.register("fire_dragon", () ->
            EntityType.Builder.<FireDragonProjectile>of(FireDragonProjectile::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .setTrackingRange(10)
                    .build("fire_dragon")
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
