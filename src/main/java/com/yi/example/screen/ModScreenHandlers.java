package com.yi.example.screen;

import com.yi.example.ExampleMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GemPolishingScreenHandler> GEM_POLISHING_SCREEN_HANDLEER =
            Registry.register(Registries.SCREEN_HANDLER,new Identifier(ExampleMod.MOD_ID,"gem_polishing"),
                    new ExtendedScreenHandlerType<>(GemPolishingScreenHandler::new));

    public static void registerScreenHandlers(){
        ExampleMod.LOGGER.info("Registering Screen Handlers for " + ExampleMod.MOD_ID);
    }
}
