package com.syuseigame.CreateSomePatches.Client;

import com.syuseigame.CreateSomePatches.createsomepatches;
import com.syuseigame.CreateSomePatches.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider{
    public ModBlockStateProvider(PackOutput output,ExistingFileHelper exFileHelper) {
        super(output,createsomepatches.MOD_ID,exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        ModelFile model = models().getBuilder("heated_lava_block")
                .texture("particle", ResourceLocation.withDefaultNamespace("block/lava_still"));
        getVariantBuilder(ModBlocks.HEATED_LAVA_BLOCK.get())
                .partialState().setModels(new ConfiguredModel(model));
        simpleBlockWithItem(ModBlocks.RAINBOW_DIAMOND_BLOCK);
    }
    private void simpleBlockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
}