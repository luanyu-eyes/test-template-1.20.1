package com.yi.example;

import com.yi.example.block.ModBlocks;
import com.yi.example.entity.ModEntities;
import com.yi.example.entity.client.ModModelLayers;
import com.yi.example.entity.client.PorcupineModel;
import com.yi.example.entity.client.PorcupineRender;
import com.yi.example.screen.GemPolishingScreen;
import com.yi.example.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP,RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAHLIA,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_DAHLIA,RenderLayer.getTranslucent());

        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRender::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE,PorcupineModel::getTexturedModelData);

        HandledScreens.register(ModScreenHandlers.GEM_POLISHING_SCREEN_HANDLEER, GemPolishingScreen::new);
    }
}
