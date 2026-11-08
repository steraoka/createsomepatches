package com.syuseigame.CreateSomePatches.Client;

import com.syuseigame.CreateSomePatches.createsomepatches;
import com.syuseigame.CreateSomePatches.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output,ExistingFileHelper existingFileHelper){
        super(output,createsomepatches.MOD_ID,existingFileHelper);
    }

    @Override
    protected void registerModels(){
        basicItem(ModItems.ENRICHED_QUARTZ.get());
        basicItem(ModItems.HEATED_LAVA_BUCKET.get());

    }
}
