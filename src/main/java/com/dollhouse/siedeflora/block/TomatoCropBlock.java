package com.dollhouse.siedeflora.block;


import com.dollhouse.siedeflora.reg.ModItems;
import net.minecraft.world.level.ItemLike;

public class TomatoCropBlock extends ModCropBlock {
    public TomatoCropBlock(Properties properties) {
        super(properties, ModItems.TOMATO_SEEDS.get());
    }
}
