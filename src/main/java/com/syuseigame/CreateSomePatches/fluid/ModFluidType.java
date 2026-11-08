package com.syuseigame.CreateSomePatches.fluid;

import com.syuseigame.CreateSomePatches.block.ModBlocks;
import com.syuseigame.CreateSomePatches.createsomepatches;
import com.syuseigame.CreateSomePatches.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluidType {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, createsomepatches.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, createsomepatches.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> HEATED_LAVA_TYPE = FLUID_TYPES.register("heated_lava",
            () -> new FluidType(FluidType.Properties.create().density(1400).viscosity(2000)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SOURCE = FLUIDS.register("heated_lava",
            () -> new BaseFlowingFluid.Source(createProperties()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING = FLUIDS.register("heated_lava_flowing",
            () -> new BaseFlowingFluid.Flowing(createProperties()));

    private static BaseFlowingFluid.Properties createProperties() {
        return new BaseFlowingFluid.Properties(HEATED_LAVA_TYPE, SOURCE, FLOWING)
                .levelDecreasePerBlock(2)
                .tickRate(2)
                .explosionResistance(10f)
                .slopeFindDistance(2)
                .block(ModBlocks.HEATED_LAVA_BLOCK)
                .bucket(ModItems.HEATED_LAVA_BUCKET);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
    }
}
