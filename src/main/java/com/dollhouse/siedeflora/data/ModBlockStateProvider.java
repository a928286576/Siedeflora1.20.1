// src/main/java/com/dollhouse/siedeflora/data/ModBlockStateProvider.java
package com.dollhouse.siedeflora.data;

import com.dollhouse.siedeflora.Siedeflora;
import com.dollhouse.siedeflora.reg.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Siedeflora.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockWithItem(ModBlocks.EXAMPLE_BLOCK.get());
    }

    private void BlockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
}
