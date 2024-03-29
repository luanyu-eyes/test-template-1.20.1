package com.yi.example;

import com.yi.example.Item.ModItemGroups;
import com.yi.example.Item.ModItems;
import com.yi.example.Sound.ModSounds;
import com.yi.example.block.ModBlocks;
import com.yi.example.block.entity.ModBlockEntities;
import com.yi.example.entity.ModEntities;
import com.yi.example.entity.custom.PorcupineEntity;
import com.yi.example.recipe.ModRecipes;
import com.yi.example.screen.ModScreenHandlers;
import com.yi.example.util.ModCustomTrades;
import com.yi.example.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "test";
    public static final Logger LOGGER = LoggerFactory.getLogger("test");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
		ModSounds.registerSounds();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipe();

		FuelRegistry.INSTANCE.add(ModItems.COAL_REPLACE, 200);

		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
	}
}