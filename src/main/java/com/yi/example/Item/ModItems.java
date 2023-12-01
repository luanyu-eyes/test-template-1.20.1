package com.yi.example.Item;

import com.yi.example.ExampleMod;
import com.yi.example.Item.custom.MetalDetectorItem;
import com.yi.example.Item.custom.ModArmorItem;
import com.yi.example.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxCount(64)));
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COAL_REPLACE = registerItem("coal_replace",
            new Item(new FabricItemSettings()));
    public static final Item RUBY_STAFF = registerItem("ruby_staff",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY,2,2f,new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(ModToolMaterial.RUBY,3,1f,new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY,0,0f,new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterial.RUBY,5,3f,new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(ModToolMaterial.TEST,0,0f,new FabricItemSettings()));
    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.BOOTS,new FabricItemSettings()));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));
    public static final Item CRON = registerItem("corn",
            new Item(new FabricItemSettings()));
    public static final Item CRON_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP,new FabricItemSettings()));
    public static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,new Identifier(ExampleMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        ExampleMod.LOGGER.info("Register Mod Items for " + ExampleMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
