package net.cvrse.creepbud.entity.custom;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.util.math.MathHelper;

public class CreeperBudEntity extends TameableEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public float headYaw;
    public float headPitch;
    public CreeperBudEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this)); //can swim
        this.goalSelector.add(1, new TameableEntity.TameableEscapeDangerGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new FollowOwnerGoal(this, 1D, 5.0F, 2.0F));
        this.goalSelector.add(4, new TemptGoal(this, 1.25D, Ingredient.ofItems(Items.GUNPOWDER), false)); //follow when holding Gunpowder

        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F)); //Look at player
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (this.getWorld().isClient()) {
            return ActionResult.SUCCESS;
        }

        if (!this.isTamed() && stack.isOf(Items.GUNPOWDER)) {
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }

            if (this.random.nextInt(3) == 0) { // 1 in 3 chance
                this.setOwner(player);
                this.setTamed(true, true);
                this.getNavigation().stop();
                this.setSitting(true);

                this.getWorld().sendEntityStatus(this, (byte) 7); // hearts
            } else {
                this.getWorld().sendEntityStatus(this, (byte) 6); // smoke
            }

            return ActionResult.SUCCESS;
        }

        if (this.isTamed() && this.isOwner(player)) {
            this.setSitting(!this.isSitting());
            this.getNavigation().stop();
            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return TameableEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0D);
    }
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.GUNPOWDER);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }


    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.setupAnimationStates();

        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        // Wolf-style head tracking
        if (this.isTamed() && this.getOwner() != null) {
            LivingEntity owner = this.getOwner();
            double dx = owner.getX() - this.getX();
            double dz = owner.getZ() - this.getZ();
            double dy = owner.getEyeY() - this.getEyeY();

            float yaw = (float) MathHelper.wrapDegrees(MathHelper.atan2(dz, dx) * 57.295776F - this.getYaw());
            float pitch = (float) MathHelper.clamp(dy * 10, -45.0F, 45.0F);

            this.headYaw = yaw;
            this.headPitch = pitch;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PARROT_IMITATE_CREEPER;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
