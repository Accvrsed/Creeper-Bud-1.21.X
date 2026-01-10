package net.cvrse.creepbud.item;

import net.cvrse.creepbud.CreeperBud;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CREEPER_BUD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CreeperBud.MOD_ID, "creeper_bud_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CREEPERBUD_SPAWN_EGG))
                    .displayName(Text.translatable("itemgroup.creepbud.creeperbud_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLASTCAP_SPORE);
                        entries.add(ModItems.CREEPERBUD_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        CreeperBud.LOGGER.info("Registers item groups for " + CreeperBud.MOD_ID);
    }
}
