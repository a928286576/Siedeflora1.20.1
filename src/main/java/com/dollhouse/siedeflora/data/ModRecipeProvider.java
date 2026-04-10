package com.dollhouse.siedeflora.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        /*
        // 示例：简单的工作台合成配方
        // 将4个橡木木板合成成一个工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
                .pattern("##")
                .pattern("##")
                .define('#', Items.OAK_PLANKS)
                .unlockedBy("has_oak_planks", has(Items.OAK_PLANKS))
                .save(consumer, Siedeflora.MODID + ":crafting_table_from_planks");

        // 示例：无序合成配方
        // 将1个钻石和1个金锭合成2个钻石金锭
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND, 2)
                .requires(Items.DIAMOND)
                .requires(Items.GOLD_INGOT)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(consumer, Siedeflora.MODID + ":diamond_from_diamond_and_gold");

        // 示例：熔炉烧炼配方
        // 将1个铁矿石烧炼成1个铁锭
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.IRON_ORE),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.7f,
                        200)
                .unlockedBy("has_iron_ore", has(Items.IRON_ORE))
                .save(consumer, Siedeflora.MODID + ":iron_ingot_from_smelting");

        // 示例：使用你的mod物品的配方
        // 将9个土壤方块物品合成1个土壤方块
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOIL_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SOIL_BLOCK_ITEM.get())
                .unlockedBy("has_soil_item", has(ModItems.SOIL_BLOCK_ITEM.get()))
                .save(consumer);
        */
    }
}
