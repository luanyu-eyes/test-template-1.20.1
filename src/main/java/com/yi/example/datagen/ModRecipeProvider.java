package com.yi.example.datagen;

import com.yi.example.Item.ModItems;
import com.yi.example.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RUBY,ModItems.METAL_DETECTOR);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f,200,"ruby");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.RUBY,RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);

        offerSlabRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.RUBY_SLAB,ModItems.RUBY);
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.RUBY_WALL,ModItems.RUBY);
        offerPressurePlateRecipe(exporter,ModBlocks.RUBY_PRESSURE_PLATE,ModItems.RUBY);
        offerSingleOutputShapelessRecipe(exporter,ModBlocks.RUBY_BUTTON,ModItems.RUBY,"ruby");
        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.RUBY_TRAPDOOR,Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY)).offerTo(exporter);
        createFenceRecipe(ModBlocks.RUBY_FENCE,Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY)).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.RUBY_GATE_FENCE,Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY)).offerTo(exporter);
        createStairsRecipe(ModBlocks.RUBY_STAIRS,Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.METAL_DETECTOR,1)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('C', ModItems.RUBY)
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.RUBY_PICKAXE,1)
                .pattern("SSS")
                .pattern(" C ")
                .pattern(" C ")
                .input('C', Items.STICK)
                .input('S', ModItems.RUBY)
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.RUBY_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.RUBY_AXE,1)
                .pattern("SS ")
                .pattern("SC ")
                .pattern(" C ")
                .input('C', Items.STICK)
                .input('S', ModItems.RUBY)
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.RUBY_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.RUBY_SHOVEL,1)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" C ")
                .input('C', Items.STICK)
                .input('S', ModItems.RUBY)
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.RUBY_SHOVEL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.RUBY_SWORD,1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" C ")
                .input('C', Items.STICK)
                .input('S', ModItems.RUBY)
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.RUBY_SWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.RUBY_HOE,1)
                .pattern("SS ")
                .pattern(" C ")
                .pattern(" C ")
                .input('C', Items.STICK)
                .input('S', ModItems.RUBY)
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.RUBY_HOE)));
    }
}
