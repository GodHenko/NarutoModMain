package com.godhenko.narutorevival.inits;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.custom.customitems.jutsuitems.*;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.EarthArmorJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.EarthWallJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.earthrelease.SandTrapJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireStagesJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.RunningFireJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.firereleasemoves.FireballJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.LariatJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.LightningBallJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.lightningrelease.StaticForceJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves.WaterNeedlesJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves.WaterSharkJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.waterreleasemoves.WaterWallJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.GaleBurstJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.RasenshurikenJutsu;
import com.godhenko.narutorevival.custom.customitems.natureitems.windrelease.WindModeJutsu;
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
    public static final RegistryObject<JutsuItem> FIRE_BALL_JUTSU = ITEMS.register("fire_ball_jutsu", () -> new JutsuItem(new FireballJutsu().init()));
    public static final RegistryObject<JutsuItem> RUNNING_FIRE_JUTSU = ITEMS.register("running_fire_jutsu", () -> new JutsuItem(new RunningFireJutsu().init()));
    public static final RegistryObject<JutsuItem> FIRE_STAGES_JUTSU = ITEMS.register("fire_stages_jutsu", () -> new FireThreeBookItem(new FireStagesJutsu().init()));
    //EARTH
    public static final RegistryObject<JutsuItem> EARTH_WALL_JUTSU = ITEMS.register("earth_wall_jutsu", () -> new JutsuItem(new EarthWallJutsu().init()));
    public static final RegistryObject<JutsuItem> SAND_TRAP_JUTSU = ITEMS.register("sand_trap_jutsu", () -> new JutsuItem(new SandTrapJutsu().init()));
    public static final RegistryObject<JutsuItem> EARTH_ARMOR_JUTSU = ITEMS.register("earth_armor_jutsu", () -> new JutsuItem(new EarthArmorJutsu().init()));
    //WATER
    public static final RegistryObject<JutsuItem> WATER_WALL_JUTSU = ITEMS.register("water_wall_jutsu", () -> new JutsuItem(new WaterWallJutsu().init()));
    public static final RegistryObject<JutsuItem> WATER_SHARK_JUTSU = ITEMS.register("water_shark_jutsu", () -> new JutsuItem(new WaterSharkJutsu().init()));
    public static final RegistryObject<JutsuItem> WATER_NEEDLES_JUTSU = ITEMS.register("water_needles_jutsu", () -> new JutsuItem(new WaterNeedlesJutsu().init()));
    //Wind
    public static final RegistryObject<JutsuItem> WIND_MODE_JUTSU = ITEMS.register("wind_mode_jutsu", () -> new JutsuItem(new WindModeJutsu().init()));
    public static final RegistryObject<JutsuItem> GALE_BURST_JUTSU = ITEMS.register("gale_burst_jutsu", () -> new JutsuItem(new GaleBurstJutsu().init()));
    public static final RegistryObject<JutsuItem> RASENSHURIKEN_JUTSU = ITEMS.register("rasenshuriken_jutsu", () -> new JutsuItem(new RasenshurikenJutsu().init()));
    //Lightning
    public static final RegistryObject<JutsuItem> STATIC_FORCE_JUTSU = ITEMS.register("static_force_jutsu", () -> new JutsuItem(new StaticForceJutsu().init()));
    public static final RegistryObject<JutsuItem> LIGHTNING_BALL_JUTSU = ITEMS.register("lightning_ball_jutsu", () -> new JutsuItem(new LightningBallJutsu().init()));
    public static final RegistryObject<JutsuItem> LARIAT_JUTSU = ITEMS.register("lariat_jutsu", () -> new JutsuCooldownItem(new LariatJutsu().init(),1));

    //Learners
    public static final RegistryObject<Item> SKILL_LEARNER_FIRE = ITEMS.register("skill_learner_fire", () -> new SkillLearnerItem(JutsuType.FIRE, FIRE_BALL_JUTSU, RUNNING_FIRE_JUTSU,FIRE_STAGES_JUTSU));
    public static final RegistryObject<Item> SKILL_LEARNER_EARTH = ITEMS.register("skill_learner_earth", () -> new SkillLearnerItem(JutsuType.EARTH, EARTH_WALL_JUTSU, SAND_TRAP_JUTSU,EARTH_ARMOR_JUTSU));
    public static final RegistryObject<Item> SKILL_LEARNER_WATER = ITEMS.register("skill_learner_water", () -> new SkillLearnerItem(JutsuType.WATER, WATER_WALL_JUTSU, WATER_SHARK_JUTSU,WATER_NEEDLES_JUTSU));
    public static final RegistryObject<Item> SKILL_LEARNER_WIND = ITEMS.register("skill_learner_wind", () -> new SkillLearnerItem(JutsuType.WIND, WIND_MODE_JUTSU, GALE_BURST_JUTSU,RASENSHURIKEN_JUTSU));
    public static final RegistryObject<Item> SKILL_LEARNER_LIGHTNING = ITEMS.register("skill_learner_lightning", () -> new SkillLearnerItem(JutsuType.LIGHTNING, STATIC_FORCE_JUTSU, LIGHTNING_BALL_JUTSU,LARIAT_JUTSU));



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

    public static final RegistryObject<EntityType<IceNeedlesProjectile>> ICE_NEEDLES_PROJECTILE = ENTITIES.register("ice_needles", () ->
            EntityType.Builder.<IceNeedlesProjectile>of(IceNeedlesProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .setTrackingRange(10)
                    .build("ice_needles")
    );

    public static final RegistryObject<EntityType<OverloadProjectile>> OVERLOAD_PROJECTILE = ENTITIES.register("overload", () ->
            EntityType.Builder.<OverloadProjectile>of(OverloadProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .setTrackingRange(10)
                    .build("overload")
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
