package com.yi.example.entity.client;

import com.yi.example.ExampleMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(ExampleMod.MOD_ID,"porcupine"),"main");
}
