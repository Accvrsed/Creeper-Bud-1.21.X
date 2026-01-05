package net.cvrse.creepbud.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;
import java.util.List;

public class HideBehindOwnerFromCatGoal<T extends TameableEntity> extends Goal {
    private final TameableEntity mob;
    private CatEntity closestCat;
    private final double walkSpeed;
    private final double sprintSpeed;
    private final double avoidDistance;

    public HideBehindOwnerFromCatGoal(TameableEntity mob, double walkSpeed, double sprintSpeed, double avoidDistance) {
        this.mob = mob;
        this.walkSpeed = walkSpeed;
        this.sprintSpeed = sprintSpeed;
        this.avoidDistance = avoidDistance;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        //Find nearby cat
        List<CatEntity> cats = this.mob.getWorld().getEntitiesByClass(CatEntity.class,
                this.mob.getBoundingBox().expand(avoidDistance, 3.0, avoidDistance), c -> c.isAlive());
        if (cats.isEmpty()) return false;

        this.closestCat = cats.get(0);
        return true;
    }

    @Override
    public void tick() {
        if (mob.isTamed() && mob.getOwner() != null && closestCat != null) {
            LivingEntity ownerEntity = mob.getOwner();
            if (ownerEntity instanceof PlayerEntity owner) {

                Vec3d catPos = closestCat.getPos();
                Vec3d ownerPos = owner.getPos();
                Vec3d fleePos = ownerPos.subtract(catPos).normalize().multiply(2.0D).add(ownerPos);

                mob.getNavigation().startMovingTo(fleePos.x, fleePos.y, fleePos.z, sprintSpeed);
            } else if (closestCat != null) {
                //no owner near
                Vec3d direction = mob.getPos().subtract(closestCat.getPos().normalize().multiply(2.0D));
                Vec3d fleePos = mob.getPos().add(direction);
                mob.getNavigation().startMovingTo(fleePos.x, fleePos.y, fleePos.z, walkSpeed);
            }
        }
    }
}
