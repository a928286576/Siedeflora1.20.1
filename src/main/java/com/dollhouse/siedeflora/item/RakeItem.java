package com.dollhouse.siedeflora.item;

import com.dollhouse.siedeflora.reg.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class RakeItem extends Item {
    // 可转换的方块列表
    private static final Block[] CONVERTIBLE_BLOCKS = {
            Blocks.GRASS_BLOCK,
            Blocks.DIRT,
            Blocks.COARSE_DIRT,
            Blocks.PODZOL,
            Blocks.MYCELIUM
    };

    public RakeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            BlockPos pos = context.getClickedPos();
            BlockState state = context.getLevel().getBlockState(pos);

            // 检查是否是可转换的方块
            for (Block block : CONVERTIBLE_BLOCKS) {
                if (state.is(block)) {
                    // 转换为土壤方块
                    context.getLevel().setBlockAndUpdate(pos, ModBlocks.SOIL_BLOCK.get().defaultBlockState());

                    // 触发方块更新
                    context.getLevel().updateNeighborsAt(pos, ModBlocks.SOIL_BLOCK.get());

                    // 消耗耐久度
                    if (context.getItemInHand().isDamageableItem()) {
                        context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                            (player) -> player.broadcastBreakEvent(context.getHand()));
                    }

                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.useOn(context);
    }
}
