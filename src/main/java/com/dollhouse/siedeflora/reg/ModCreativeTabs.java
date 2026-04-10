package com.dollhouse.siedeflora.reg;

import com.dollhouse.siedeflora.Siedeflora;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Siedeflora.MODID);

    public static void init(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    // 示例创造模式标签页
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register(
            "example_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.EXAMPLE_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.EXAMPLE_ITEM.get());
                        output.accept(ModItems.EXAMPLE_BLOCK_ITEM.get());
                        output.accept(ModBlocks.EXAMPLE_BLOCK.get());
                        output.accept(ModItems.RAKE.get());
                        output.accept(ModItems.SOIL_BLOCK_ITEM.get());
                        output.accept(ModItems.TOMATO_SEEDS.get());
                        output.accept(ModItems.TOMATO.get());
                    })
                    .build()
    );
}
