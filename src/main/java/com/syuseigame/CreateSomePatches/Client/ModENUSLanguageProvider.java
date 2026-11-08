package com.syuseigame.CreateSomePatches.Client;

import com.syuseigame.CreateSomePatches.block.ModBlocks;
import com.syuseigame.CreateSomePatches.createsomepatches;
import com.syuseigame.CreateSomePatches.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Locale;

public class ModENUSLanguageProvider extends LanguageProvider {
    public ModENUSLanguageProvider(PackOutput output)
    {
        super(output,createsomepatches.MOD_ID,"en_us");
    }
    @Override
    protected void addTranslations(){
        addItem(ModItems.ENRICHED_QUARTZ,"enriched_quartz");
        addBlock(ModBlocks.RAINBOW_DIAMOND_BLOCK,"rainbow_diamond_block");
        add("creativetabs.tutrial_tab","Practice");
    }
}

