package com.dollhouse.siedeflora.data;

import com.dollhouse.siedeflora.Siedeflora;
import com.dollhouse.siedeflora.reg.ModBlocks;
import com.dollhouse.siedeflora.reg.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, Siedeflora.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        // 方块名称
        add(ModBlocks.SOIL_BLOCK.get(), "Soil Block");

        // 物品名称
        // add(ModItems.SOIL_BLOCK_ITEM.get(), "Soil Block");
        add(ModItems.RAKE.get(), "Rake");

        // 物品组
        add("itemGroup." + Siedeflora.MODID, "Siedeflora");

        // 其他文本
        add("tooltip.siedeflora.rake_usage", "Right-click on dirt or grass to convert to soil");
    }
}
