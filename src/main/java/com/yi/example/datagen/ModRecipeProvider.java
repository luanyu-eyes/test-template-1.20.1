package com.yi.example.datagen;

import com.yi.example.Item.ModItems;
import com.yi.example.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f,200,"ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.RUBY,RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.METAL_DETECTOR,1)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('C', ModItems.RUBY)
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));
    }
}
