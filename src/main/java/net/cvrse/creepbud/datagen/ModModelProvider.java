package net.cvrse.creepbud.datagen;

import net.cvrse.creepbud.block.ModBlocks;
import net.cvrse.creepbud.block.custom.BoomflowerCropBlock;
import net.cvrse.creepbud.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider  extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

//        blockStateModelGenerator.registerCrop(ModBlocks.BOOMFLOWER_CROP, BoomflowerCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BOOMFLOWER_CROP,BlockStateModelGenerator.TintType.NOT_TINTED, BoomflowerCropBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CREEPERBUD_SPAWN_EGG, Models.GENERATED);
    }
}
