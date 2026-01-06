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
    public void animateModel(CreeperBudEntity entity, float limbAngle, float limbDistance, float tickDelta) {
        if (entity.isInSittingPose()) {
            // === SITTING POSE (NO ANIMATIONS) ===
            this.getPart().traverse().forEach(ModelPart::resetTransform);
            // Body (this is the main anchor)
            this.body.setPivot(0.0F, 18.25F, 0.0F);
            this.body.pitch = 0.0873F;

            this.head.setPivot(0.0F, -10.75F, -1.0F);
            // Back right leg
            this.leg_back_right.setPivot(-2.5F, 14.2F, 2.0F);
            this.leg_back_right.pitch = -0.7854F;
            this.leg_back_right.yaw   =  0.1571F;
            this.leg_back_right.roll  =  1.3439F;

            // Front right leg
            this.leg_front_right.setPivot(-2.5F, 14.0F, -2.0F);
            this.leg_front_right.pitch = -1.5184F;
            this.leg_front_right.yaw   = -0.0007F;
            this.leg_front_right.roll  =  0.2618F;

            // Back left leg
            this.leg_back_left.setPivot(2.5F, 14.2F, 2.0F);
            this.leg_back_left.pitch = -0.7854F;
            this.leg_back_left.yaw   = -0.1571F;
            this.leg_back_left.roll  = -1.3439F;

            // Front left leg
            this.leg_front_left.setPivot(2.5F, 14.3F, -2.0F);
            this.leg_front_left.pitch = -1.5359F;
            this.leg_front_left.yaw   = -0.0007F;
            this.leg_front_left.roll  = -0.2618F;
        } else {
            this.getPart().traverse().forEach(ModelPart::resetTransform);
        }
    }

    @Override
    public void setAngles(CreeperBudEntity entity, float f, float g, float h, float i, float j) {
//        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.head.pitch = j * (float) (Math.PI / 180.0);
        this.head.yaw = i * (float) (Math.PI / 180.0);

        this.animateMovement(CreeperBudAnimations.ANIM_BUD_WALK, f, g, 2f, 2.5f);
        if (entity.isInSittingPose()) {
            this.updateAnimation(entity.idleAnimationState, CreeperBudAnimations.ANIM_BUD_SIT_IDLE, h, 1f);
        } else {
            this.updateAnimation(entity.idleAnimationState, CreeperBudAnimations.ANIM_BUD_IDLE, h, 1f);
        }


    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Creeper_Bud.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return Creeper_Bud;
    }
}
