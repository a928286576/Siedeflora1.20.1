// src/main/java/com/dollhouse/siedeflora/data/ModItemModelProvider.java
package com.dollhouse.siedeflora.data;

import com.dollhouse.siedeflora.Siedeflora;
import com.dollhouse.siedeflora.reg.ModBlocks;
import com.dollhouse.siedeflora.reg.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Siedeflora.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // 方块物品模型
//        withExistingParent(ModBlocks.EXAMPLE_BLOCK.getId().getPath(),
//            modLoc("block/" + ModBlocks.EXAMPLE_BLOCK.getId().getPath()));

        // 普通物品模型
        basicItem(ModItems.EXAMPLE_ITEM.get());
        basicItem(ModItems.RAKE.get());
        //simpleItem(ModItems.EXAMPLE_BLOCK_ITEM);
    }
}
