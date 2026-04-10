package com.dollhouse.siedeflora.reg;

import com.dollhouse.siedeflora.Siedeflora;
import com.dollhouse.siedeflora.block.SoilBlock;
import com.dollhouse.siedeflora.block.TomatoCropBlock;
import com.dollhouse.siedeflora.block.entity.SoilBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Siedeflora.MODID);

    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    // 示例方块注册
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register(
            "example_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE))
    );

    public static final RegistryObject<Block> SOIL_BLOCK = BLOCKS.register(
            "soil_block",
            () -> new SoilBlock(BlockBehaviour.Properties.of()
                    .strength(0.5f)
                    .sound(SoundType.GRAVEL))
    );

    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register(
            "tomato_crop",
            () -> new TomatoCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHEAT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
            )
    );
}
