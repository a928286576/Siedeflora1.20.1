package com.dollhouse.siedeflora.reg;

import com.dollhouse.siedeflora.Siedeflora;
import com.dollhouse.siedeflora.block.entity.SoilBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Siedeflora.MODID);

    public static final RegistryObject<BlockEntityType<SoilBlockEntity>> SOIL_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "soil_block",
            () -> BlockEntityType.Builder.of(SoilBlockEntity::new, ModBlocks.SOIL_BLOCK.get()).build(null)
    );
    public static void init(IEventBus modEventBus) {
        BLOCK_ENTITIES.register(modEventBus);
    }
}
