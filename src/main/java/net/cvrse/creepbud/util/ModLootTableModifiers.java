package net.cvrse.creepbud.util;

import net.cvrse.creepbud.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;


public class ModLootTableModifiers {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {

            //EXAMPLE NON-DROP LOOT POOL (Chests, ETC.)
            if(LootTables.IGLOO_CHEST_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.BLASTCAP_SPORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
        //Replace Sniffer digging to allow Boomflower seeds to be found
        LootTableEvents.REPLACE.register((key, original, source, registries) -> {
            if (LootTables.SNIFFER_DIGGING_GAMEPLAY.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.TORCHFLOWER_SEEDS))
                        .with(ItemEntry.builder(Items.PITCHER_POD))
                        .with(ItemEntry.builder(ModItems.BLASTCAP_SPORE));

                return LootTable.builder().pool(poolBuilder.build()).build();
            }
            return null;
        });
    }
}
