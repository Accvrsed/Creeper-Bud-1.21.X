package net.cvrse.creepbud.entity.client;

import net.cvrse.creepbud.CreeperBud;
import net.cvrse.creepbud.entity.custom.CreeperBudEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.WolfCollarFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CreeperBudRenderer extends MobEntityRenderer<CreeperBudEntity, CreeperBudModel<CreeperBudEntity>> {
    public CreeperBudRenderer(EntityRendererFactory.Context context) {
        super(context, new CreeperBudModel<>(context.getPart(CreeperBudModel.BUD)), 0.5f);
        this.addFeature(new CreeperBudCollarFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(CreeperBudEntity entity) {
        return Identifier.of(CreeperBud.MOD_ID, "textures/entity/creeperbud/creeper_bud.png");
    }

    @Override
    public void render(CreeperBudEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);

    }
}
