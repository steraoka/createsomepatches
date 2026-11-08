package com.syuseigame.CreateSomePatches.Client;

import com.syuseigame.CreateSomePatches.block.ModBlocks;
import com.syuseigame.CreateSomePatches.createsomepatches;
import com.syuseigame.CreateSomePatches.fluid.ModFluids;
import com.syuseigame.CreateSomePatches.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.apache.logging.log4j.util.PropertiesPropertySource;

public class ModFluidsModelProvider {
    public static final DeferredRegister<FluidType> FLUID_TYPES=DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES,createsomepatches.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS=DeferredRegister.create(Registries.FLUID,createsomepatches.MOD_ID);

    public static final DeferredHolder<FluidType,FluidType> MY_TYPE = FLUID_TYPES.register("my_fluid",() -> new ModFluids(
        FluidType.Properties.create().density(1400).viscosity(2000),
            ResourceLocation.withDefaultNamespace("block/water_still"),
            ResourceLocation.withDefaultNamespace("block/water_flow"),
            0xFFEAAE2F));
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SORCE=FLUIDS.register("heated_lava",() -> new BaseFlowingFluid.Source(PROPS));
    public static final DeferredHolder<Fluid,BaseFlowingFluid.Flowing> FLOWING=FLUIDS.register("heated_lava_flowing",() -> new BaseFlowingFluid.Flowing(PROPS));
    public static final BaseFlowingFluid.Properties PROPS = new BaseFlowingFluid.Properties(MY_TYPE,SORCE,FLOWING)
            .levelDecreasePerBlock(2)
            .tickRate(2)
            .explosionResistance(10f)
            .slopeFindDistance(2)
            .block(ModBlocks.MY_FLUID_BLOCK)
            .bucket(ModItems.MY_FLUID_BUCKET);}


}
