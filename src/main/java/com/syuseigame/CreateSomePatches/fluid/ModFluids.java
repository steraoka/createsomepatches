package com.syuseigame.CreateSomePatches.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.Consumer;

public class ModFluids extends FluidType {
    private final ResourceLocation still, flowing;
    private final int tint;

    public ModFluids(Properties props, ResourceLocation still, ResourceLocation flowing, int tint) {
        super(props);
        this.still = still;
        this.flowing = flowing;
        this.tint = tint;
    }
    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer){
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override public ResourceLocation getStillTexture(){ return still;}
            @Override public ResourceLocation getFlowingTexture() { return flowing;}
            @Override public int getTintColor() { return tint;}
        });
    }
}
