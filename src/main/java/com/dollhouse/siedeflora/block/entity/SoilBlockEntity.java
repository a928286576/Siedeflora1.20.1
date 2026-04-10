package com.dollhouse.siedeflora.block.entity;

import com.dollhouse.siedeflora.reg.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SoilBlockEntity extends BlockEntity {
    // 定义营养等级的常量
    public static final int VERY_LOW = 0;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;
    public static final int VERY_HIGH = 4;
    private static final int MIN_LEVEL = VERY_LOW;
    private static final int MAX_LEVEL = VERY_HIGH;

    // 氮 (0-4)
    private int nitrogen = LOW;
    // 磷 (0-4)
    private int phosphorus = LOW;
    // 钾 (0-4)
    private int potassium = LOW;
    // 水分 (0-4)
    private int moisture = LOW;

    public SoilBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SOIL_BLOCK_ENTITY.get(), pos, state);
    }

    public void tick() {
        // 这里可以添加土壤属性的自然变化逻辑
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("nitrogen", nitrogen);
        tag.putInt("phosphorus", phosphorus);
        tag.putInt("potassium", potassium);
        tag.putInt("moisture", moisture);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        nitrogen = clampLevel(tag.getInt("nitrogen"));
        phosphorus = clampLevel(tag.getInt("phosphorus"));
        potassium = clampLevel(tag.getInt("potassium"));
        moisture = clampLevel(tag.getInt("moisture"));
    }

    // 确保等级在有效范围内
    private int clampLevel(int level) {
        return Math.min(MAX_LEVEL, Math.max(MIN_LEVEL, level));
    }

    // Getters and setters
    public int getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(int nitrogen) {
        this.nitrogen = clampLevel(nitrogen);
        setChanged();
    }

    public int getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(int phosphorus) {
        this.phosphorus = clampLevel(phosphorus);
        setChanged();
    }

    public int getPotassium() {
        return potassium;
    }

    public void setPotassium(int potassium) {
        this.potassium = clampLevel(potassium);
        setChanged();
    }

    public int getMoisture() {
        return moisture;
    }

    public void setMoisture(int moisture) {
        this.moisture = clampLevel(moisture);
        setChanged();
    }
}
