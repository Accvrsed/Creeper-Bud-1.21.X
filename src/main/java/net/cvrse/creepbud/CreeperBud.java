package net.cvrse.creepbud;

import net.cvrse.creepbud.block.ModBlocks;
import net.cvrse.creepbud.entity.ModEntities;
import net.cvrse.creepbud.entity.custom.CreeperBudEntity;
import net.cvrse.creepbud.item.ModItemGroups;
import net.cvrse.creepbud.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreeperBud implements ModInitializer {
	public static final String MOD_ID = "creepbud";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();

		CompostingChanceRegistry.INSTANCE.add(ModItems.BOOMFLOWER_SEEDS, 0.25f);
		FabricDefaultAttributeRegistry.register(ModEntities.CREEPERBUD, CreeperBudEntity.createAttributes());
	}
}