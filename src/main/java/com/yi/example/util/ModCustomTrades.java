package com.yi.example.util;

import com.yi.example.Item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD,2),
                    new ItemStack(ModItems.TOMATO,7),
                    6,5,0.05f));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD,7),
                    new ItemStack(ModItems.TOMATO_SEEDS,1),
                    2,7,0.75f));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,2,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.GOLD_INGOT,16),
                        new ItemStack(Items.DIAMOND,12),
                        new ItemStack(ModItems.TOMATO,7),
                        2,6,0.75f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN,1,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(ModItems.RUBY,32),
                        EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.PIERCING,2)),
                        2,6,0.75f)));
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(ModItems.RUBY,16),
                        new ItemStack(ModItems.METAL_DETECTOR,1),
                        1,12,0.075f)));
        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(ModItems.RUBY,1),
                        new ItemStack(ModItems.COAL_REPLACE,1),
                        1,12,0.075f)));
    }
}
