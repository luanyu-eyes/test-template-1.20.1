package com.yi.example.block.entity;

import com.yi.example.ExampleMod;
import com.yi.example.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<GemPolishingStationBlockEntity> GEM_POLISHING_STATION_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(ExampleMod.MOD_ID,"gem_polishing_be"),
                    FabricBlockEntityTypeBuilder.create(GemPolishingStationBlockEntity::new,
                            ModBlocks.GEN_POLISHING_STATION).build());

    public static void registerBlockEntities(){
        ExampleMod.LOGGER.info("Registering Block Entities for " + ExampleMod.MOD_ID);
    }
}
