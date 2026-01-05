package net.cvrse.creepbud.datagen;


import net.cvrse.creepbud.block.ModBlocks;
import net.cvrse.creepbud.block.custom.BoomflowerCropBlock;
import net.cvrse.creepbud.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.BOOMFLOWER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BoomflowerCropBlock.AGE, 3));
        this.addDrop(ModBlocks.BOOMFLOWER_CROP, this.cropDrops(ModBlocks.BOOMFLOWER_CROP, Items.GUNPOWDER, ModItems.BOOMFLOWER_SEEDS, builder2));

    }
}
