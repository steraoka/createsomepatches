package com.syuseigame.CreateSomePatches.Client;

import com.syuseigame.CreateSomePatches.createsomepatches;
import com.syuseigame.CreateSomePatches.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider{
    public ModBlockStateProvider(PackOutput output,ExistingFileHelper exFileHelper) {
        super(output,createsomepatches.MOD_ID,exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlockWithItem(ModBlocks.RAINBOW_DIAMOND_BLOCK);
    }
    private void simpleBlockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
}