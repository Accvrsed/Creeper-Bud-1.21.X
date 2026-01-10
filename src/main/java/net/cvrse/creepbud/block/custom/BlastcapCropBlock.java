package net.cvrse.creepbud.block.custom;
import net.cvrse.creepbud.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BlastcapCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = IntProperty.of("age", 0, 3);

    public BlastcapCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BLASTCAP_SPORE;
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

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        int age = this.getAge(state);

        // Only spawn particles if fully grown
        if (age == MAX_AGE) {
            if (world.isClient) { // client-side only
                for (int i = 0; i < 5; i++) {
                    world.addParticle(
                            ParticleTypes.POOF,
                            pos.getX() + 0.5 + (world.random.nextDouble() - 0.5) * 0.3,
                            pos.getY() + 0.5,
                            pos.getZ() + 0.5 + (world.random.nextDouble() - 0.5) * 0.3,
                            0.0, 0.05, 0.0
                    );
                }
            }
        }

        // Always call super to handle vanilla drops
        return super.onBreak(world, pos, state, player);
    }
}

