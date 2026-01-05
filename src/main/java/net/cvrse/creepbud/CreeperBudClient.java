package net.cvrse.creepbud;

import net.cvrse.creepbud.block.ModBlocks;
import net.cvrse.creepbud.entity.ModEntities;
import net.cvrse.creepbud.entity.client.CreeperBudModel;
import net.cvrse.creepbud.entity.client.CreeperBudRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class CreeperBudClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOOMFLOWER_CROP, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(CreeperBudModel.BUD, CreeperBudModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CREEPERBUD, CreeperBudRenderer::new);
    }
}
