package net.cvrse.creepbud.entity.client;

import net.cvrse.creepbud.CreeperBud;
import net.cvrse.creepbud.entity.custom.CreeperBudEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;



public class CreeperBudModel<T extends CreeperBudEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BUD = new EntityModelLayer(Identifier.of(CreeperBud.MOD_ID, "creeperbud"), "main");
    private final ModelPart Creeper_Bud;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leg_back_right;
    private final ModelPart leg_front_right;
    private final ModelPart leg_back_left;
    private final ModelPart leg_front_left;

    public CreeperBudModel(ModelPart root) {
        this.Creeper_Bud = root.getChild("Creeper_Bud");
        this.body = this.Creeper_Bud.getChild("body");
        this.head = this.body.getChild("head");
        this.leg_back_right = this.Creeper_Bud.getChild("leg_back_right");
        this.leg_front_right = this.Creeper_Bud.getChild("leg_front_right");
        this.leg_back_left = this.Creeper_Bud.getChild("leg_back_left");
        this.leg_front_left = this.Creeper_Bud.getChild("leg_front_left");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Creeper_Bud = modelPartData.addChild("Creeper_Bud", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

        ModelPartData body = Creeper_Bud.addChild("body", ModelPartBuilder.create().uv(14, 16).cuboid(-3.0F, -11.0F, -2.0F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -11.0F, 0.0F));

        ModelPartData whisker2_r1 = head.addChild("whisker2_r1", ModelPartBuilder.create().uv(24, 3).mirrored().cuboid(-1.8907F, -0.181F, 0.1176F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.9366F, -3.3715F, -4.0292F, 1.8737F, 0.0801F, 1.567F));

        ModelPartData whisker1_r1 = head.addChild("whisker1_r1", ModelPartBuilder.create().uv(24, 3).cuboid(-1.1093F, -0.181F, 0.1176F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.9366F, -3.3715F, -4.0292F, 1.8737F, -0.0801F, -1.567F));

        ModelPartData whisker0_r1 = head.addChild("whisker0_r1", ModelPartBuilder.create().uv(24, 0).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.2497F, -3.7187F, 1.4399F, 0.0F, 3.1416F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(32, 4).cuboid(-3.0F, -7.0685F, -1.4312F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData head_r2 = head.addChild("head_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.8942F, -4.4236F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData leg_back_right = Creeper_Bud.addChild("leg_back_right", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 12.0F, 2.0F));

        ModelPartData leg_back_right_r1 = leg_back_right.addChild("leg_back_right_r1", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, -4.0F, 2.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 4.0F, 4.0F, 0.0F, 2.8798F, 0.0F));

        ModelPartData leg_front_right = Creeper_Bud.addChild("leg_front_right", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 12.0F, -2.0F));

        ModelPartData leg_front_right_r1 = leg_front_right.addChild("leg_front_right_r1", ModelPartBuilder.create().uv(0, 24).cuboid(-4.0F, -4.0F, -6.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 4.0F, 3.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_back_left = Creeper_Bud.addChild("leg_back_left", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, 12.0F, 2.0F));

        ModelPartData leg_back_left_r1 = leg_back_left.addChild("leg_back_left_r1", ModelPartBuilder.create().uv(0, 16).cuboid(1.0F, -4.0F, 2.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 4.0F, 4.0F, 0.0F, -2.8798F, 0.0F));

        ModelPartData leg_front_left = Creeper_Bud.addChild("leg_front_left", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, 12.0F, -2.0F));

        ModelPartData leg_front_left_r1 = leg_front_left.addChild("leg_front_left_r1", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -4.0F, -6.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 4.0F, 3.0F, 0.0F, -0.2618F, 0.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }
    @Override
    public void setAngles(CreeperBudEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Reset transforms first
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        // Head rotation
        head.yaw = netHeadYaw * ((float)Math.PI/180F);
        head.pitch = headPitch * ((float)Math.PI/180F);

        // walking animation
        this.animateMovement(CreeperBudAnimations.ANIM_BUD_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, CreeperBudAnimations.ANIM_BUD_IDLE, ageInTicks, 1f);
    }

//    private void setHeadAngles(float headYaw, float headPitch){
//        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
//        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);
//
//        head.yaw = MathHelper.lerp(0.1F, head.yaw, headYaw * 0.017453292F);
//        head.pitch = MathHelper.lerp(0.1F, head.pitch, headPitch * 0.017453292F);
//    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Creeper_Bud.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return Creeper_Bud;
    }
}
