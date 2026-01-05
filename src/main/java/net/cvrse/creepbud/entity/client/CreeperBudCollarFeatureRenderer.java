package net.cvrse.creepbud.entity.client;

import net.cvrse.creepbud.CreeperBud;
import net.cvrse.creepbud.entity.custom.CreeperBudEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CreeperBudCollarFeatureRenderer extends FeatureRenderer<CreeperBudEntity, CreeperBudModel<CreeperBudEntity>> {
    private static final Identifier SKIN = Identifier.of(CreeperBud.MOD_ID, "textures/entity/creeperbud/creeper_bud_collar.png");

    public CreeperBudCollarFeatureRenderer(FeatureRendererContext<CreeperBudEntity, CreeperBudModel<CreeperBudEntity>> featureRendererContext) {
        super(featureRendererContext);
    }

    public void render(
            MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CreeperBudEntity budEntity, float f, float g, float h, float j, float k, float l
    ) {
        if (budEntity.isTamed() && !budEntity.isInvisible()) {
            int m = budEntity.getCollarColor().getEntityColor();
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityCutoutNoCull(SKIN));
            this.getContextModel().render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, m);
        }
    }
}
