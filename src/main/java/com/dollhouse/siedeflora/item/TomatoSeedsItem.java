package com.dollhouse.siedeflora.item;


import com.dollhouse.siedeflora.reg.ModBlocks;
import com.dollhouse.siedeflora.reg.ModCreativeTabs;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Item;

public class TomatoSeedsItem extends ItemNameBlockItem {
    public TomatoSeedsItem() {
        super(ModBlocks.TOMATO_CROP.get(),
              new Item.Properties()
                .tab(ModCreativeTabs.SIEDEFLORA_TAB) // 添加到你的创造模式标签页
        );
    }
}
