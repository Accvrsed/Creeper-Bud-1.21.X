package net.cvrse.creepbud.datagen;


import net.cvrse.creepbud.block.ModBlocks;
import net.cvrse.creepbud.block.custom.BlastcapCropBlock;
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

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.BLASTCAP_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BlastcapCropBlock.AGE, 3));
        this.addDrop(ModBlocks.BLASTCAP_CROP, this.cropDrops(ModBlocks.BLASTCAP_CROP, Items.GUNPOWDER, ModItems.BLASTCAP_SPORE, builder2));

    }
}
