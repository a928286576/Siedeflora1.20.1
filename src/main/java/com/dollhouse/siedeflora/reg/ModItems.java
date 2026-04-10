package com.dollhouse.siedeflora.reg;

import com.dollhouse.siedeflora.Siedeflora;
import com.dollhouse.siedeflora.item.RakeItem;
import com.dollhouse.siedeflora.item.TomatoSeedsItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Siedeflora.MODID);

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    // 示例方块物品注册
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register(
            "example_block",
            () -> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(), new Item.Properties())
    );

    // 示例物品注册
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register(
            "example_item",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder()
                            .alwaysEat()
                            .nutrition(1)
                            .saturationMod(2f)
                            .build()
            ))
    );

    // 耙
    public static final RegistryObject<Item> RAKE = ITEMS.register(
            "rake",
            () -> new RakeItem(new Item.Properties()
                    .durability(128) // 设置耐久度
                    .rarity(Rarity.COMMON))
    );

    public static final RegistryObject<Item> SOIL_BLOCK_ITEM = ITEMS.register(
            "soil_block",
            () -> new BlockItem(ModBlocks.SOIL_BLOCK.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register(
            "tomato_seeds",
            TomatoSeedsItem::new
    );

    public static final RegistryObject<Item> TOMATO = ITEMS.register(
            "tomato",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6f)
                            .build()
                    )
            )
    );
}
