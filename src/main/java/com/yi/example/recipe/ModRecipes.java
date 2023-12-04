package com.yi.example.recipe;

import com.yi.example.ExampleMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipe(){
        Registry.register(Registries.RECIPE_SERIALIZER,new Identifier(ExampleMod.MOD_ID,GemPolishingRecipe.Serializer.ID),
                GemPolishingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE,new Identifier(ExampleMod.MOD_ID,GemPolishingRecipe.Type.ID),
                GemPolishingRecipe.Type.INSTANC);
    }
}
