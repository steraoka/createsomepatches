package com.syuseigame.CreateSomePatches.Client;

import com.syuseigame.CreateSomePatches.block.ModBlocks;
import com.syuseigame.CreateSomePatches.createsomepatches;
import com.syuseigame.CreateSomePatches.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Locale;

public class ModJAJPLanguageProvider extends LanguageProvider {
    public ModJAJPLanguageProvider(PackOutput output)
    {
        super(output,createsomepatches.MOD_ID,Locale.JAPAN.toString().toLowerCase());
    }
    @Override
    protected void addTranslations(){
        addItem(ModItems.ENRICHED_QUARTZ,"濃縮されたクォーツ");
        addBlock(ModBlocks.RAINBOW_DIAMOND_BLOCK,"レインボーダイヤモンドブロック");
        add("creativetabs.tutrial_tab","練習");
    }
}

