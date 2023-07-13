package dev.enjarai.svfe;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmartVillagersFollowEmeralds implements ModInitializer {
    public static final String MOD_ID = "smart-villagers-follow-emeralds";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSensorTypes.init();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}