package dev.enjarai.svfe.mixin;

import com.google.common.collect.ImmutableList;
import dev.enjarai.svfe.ModSensorTypes;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin {
    // Vanilla modules and sensors:

    // MEMORY_MODULES = ImmutableList.of(
    // MemoryModuleType.HOME, MemoryModuleType.JOB_SITE,
    // MemoryModuleType.POTENTIAL_JOB_SITE, MemoryModuleType.MEETING_POINT,
    // MemoryModuleType.MOBS, MemoryModuleType.VISIBLE_MOBS,
    // MemoryModuleType.VISIBLE_VILLAGER_BABIES,
    // MemoryModuleType.NEAREST_PLAYERS,
    // MemoryModuleType.NEAREST_VISIBLE_PLAYER,
    // MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER,
    // MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM,
    // MemoryModuleType.ITEM_PICKUP_COOLDOWN_TICKS,
    // new MemoryModuleType[]{MemoryModuleType.WALK_TARGET,
    // MemoryModuleType.LOOK_TARGET, MemoryModuleType.INTERACTION_TARGET,
    // MemoryModuleType.BREED_TARGET, MemoryModuleType.PATH,
    // MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.NEAREST_BED,
    // MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY,
    // MemoryModuleType.NEAREST_HOSTILE, MemoryModuleType.SECONDARY_JOB_SITE,
    // MemoryModuleType.HIDING_PLACE, MemoryModuleType.HEARD_BELL_TIME,
    // MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
    // MemoryModuleType.LAST_SLEPT, MemoryModuleType.LAST_WOKEN,
    // MemoryModuleType.LAST_WORKED_AT_POI,
    // MemoryModuleType.GOLEM_DETECTED_RECENTLY});

    // SENSORS = ImmutableList.of(
    // SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS,
    // SensorType.NEAREST_ITEMS, SensorType.NEAREST_BED,
    // SensorType.HURT_BY, SensorType.VILLAGER_HOSTILES,
    // SensorType.VILLAGER_BABIES,
    // SensorType.SECONDARY_POIS, SensorType.GOLEM_DETECTED);

    @Mutable
    @Shadow @Final private static ImmutableList<MemoryModuleType<?>> MEMORY_MODULES;

    @Mutable
    @Shadow @Final private static ImmutableList<SensorType<? extends Sensor<? super VillagerEntity>>> SENSORS;

    @Inject(
            method = "<clinit>",
            at = @At("TAIL")
    )
    private static void addRequiredMemoryModulesAndSensors(CallbackInfo ci) {
        var newMemoryModules = new ArrayList<>(MEMORY_MODULES);
        newMemoryModules.add(MemoryModuleType.TEMPTATION_COOLDOWN_TICKS);
        newMemoryModules.add(MemoryModuleType.IS_TEMPTED);
        newMemoryModules.add(MemoryModuleType.TEMPTING_PLAYER);
        newMemoryModules.add(MemoryModuleType.IS_PANICKING);
        MEMORY_MODULES = ImmutableList.copyOf(newMemoryModules);

        var newSensors = new ArrayList<>(SENSORS);
        newSensors.add(ModSensorTypes.VILLAGER_TEMPTATIONS);
        SENSORS = ImmutableList.copyOf(newSensors);
    }
}
