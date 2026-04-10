package com.dollhouse.siedeflora.block;

import com.dollhouse.siedeflora.block.entity.SoilBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModCropBlock extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    private final ItemLike seedItem;

    public ModCropBlock(Properties properties, ItemLike seedItem) {
        super(properties);
        this.seedItem = seedItem;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return seedItem;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos soilPos = pos.below();
        BlockState soilState = world.getBlockState(soilPos);

        // 检查下方是否是土壤方块且有方块实体
        if (soilState.getBlock() instanceof SoilBlock) {
            BlockEntity blockEntity = world.getBlockEntity(soilPos);
            if (blockEntity instanceof SoilBlockEntity soilEntity) {
                // 增加土壤的磷含量
                soilEntity.setPhosphorus(soilEntity.getPhosphorus() + 1);
                return; // 不催熟作物，直接返回
            }
        }

        // 如果不是土壤方块，则执行默认的催熟逻辑
        int age = this.getAge(state);
        int growth = random.nextInt(2) + 1;
        world.setBlock(pos, this.getStateForAge(Math.min(age + growth, getMaxAge())), 2);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
