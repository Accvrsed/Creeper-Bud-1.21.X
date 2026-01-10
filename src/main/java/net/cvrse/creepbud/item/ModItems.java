package net.cvrse.creepbud.item;

import net.cvrse.creepbud.CreeperBud;
import net.cvrse.creepbud.block.ModBlocks;
import net.cvrse.creepbud.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item BLASTCAP_SPORE = registerItem("blastcap_spore",
            new AliasedBlockItem(ModBlocks.BLASTCAP_CROP, new Item.Settings()));

    public static final Item CREEPERBUD_SPAWN_EGG  = registerItem("creeperbud_spawn_egg",
            new SpawnEggItem(ModEntities.CREEPERBUD, 0x9dc783, 0xbfaf5f, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CreeperBud.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreeperBud.LOGGER.info("Registering Mod Items for " + CreeperBud.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(BLASTCAP_SPORE);

        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(CREEPERBUD_SPAWN_EGG);

        });
    }
}
