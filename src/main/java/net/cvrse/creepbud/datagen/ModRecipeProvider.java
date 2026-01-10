package net.cvrse.creepbud.datagen;

import net.cvrse.creepbud.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> BLASTCAP = List.of(ModItems.BLASTCAP_SPORE);

        offerSmelting(exporter, BLASTCAP, RecipeCategory.MISC, Items.GUNPOWDER, 1.0f, 200, "creepbud");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LIME_DYE, 1)
                .input(ModItems.BLASTCAP_SPORE)
                .criterion(hasItem(ModItems.BLASTCAP_SPORE), conditionsFromItem(ModItems.BLASTCAP_SPORE))
                .offerTo(exporter);
    }
}
