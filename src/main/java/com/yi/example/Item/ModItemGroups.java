package com.yi.example.Item;

import com.yi.example.ExampleMod;
import com.yi.example.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExampleMod.MOD_ID,"ruby"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.COAL_REPLACE);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(Items.DIAMOND_BLOCK);
                        entries.add(ModBlocks.SOUND_BLOCK);
                    }).build());

    public static void registerItemGroups(){

    }
}