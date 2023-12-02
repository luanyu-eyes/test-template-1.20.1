package com.yi.example.entity;

import com.yi.example.ExampleMod;
import com.yi.example.entity.custom.PorcupineEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(ExampleMod.MOD_ID,"porcupine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,PorcupineEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());
}
