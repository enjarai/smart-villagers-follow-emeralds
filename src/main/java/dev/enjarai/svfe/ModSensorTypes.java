package dev.enjarai.svfe;

import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.sensor.TemptationsSensor;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModSensorTypes {
    public static final SensorType<TemptationsSensor> VILLAGER_TEMPTATIONS =
            new SensorType<>(() -> new TemptationsSensor(Ingredient.fromTag(
                    TagKey.of(RegistryKeys.ITEM, SmartVillagersFollowEmeralds.id("villager_temptations")))));

    public static void init() {
        Registry.register(Registries.SENSOR_TYPE, SmartVillagersFollowEmeralds.id("villager_temptations"), VILLAGER_TEMPTATIONS);
    }
}
