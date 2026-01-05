package net.cvrse.creepbud.block.custom;
import net.cvrse.creepbud.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BoomflowerCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = IntProperty.of("age", 0, 3);

    public BoomflowerCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BOOMFLOWER_SEEDS;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int AGE = this.getAge(state);

        if (AGE >= 2 && random.nextFloat() < 0.4f) {
            spawnSmoke(world, pos, random);
        }
        if (AGE == 3 && random.nextFloat() < 0.25f) {
            spawnFlame(world, pos, random);
        }
    }
    private void spawnSmoke(World world, BlockPos pos, Random random){
        world.addParticle(
                ParticleTypes.SMOKE,
                pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.2,
                pos.getY() + 0.7,
                pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.2,
                0.0, 0.05, 0.0
        );
    }
    private void spawnFlame(World world, BlockPos pos, Random random){
        world.addParticle(
                ParticleTypes.SMALL_FLAME,
                pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.2,
                pos.getY() + 0.85,
                pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.2,
                0.0, 0.02, 0.0
        );
    }
}

