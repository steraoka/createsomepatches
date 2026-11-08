package com.syuseigame.CreateSomePatches.item;

import com.syuseigame.CreateSomePatches.block.ModBlocks;
import com.syuseigame.CreateSomePatches.createsomepatches;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, createsomepatches.MOD_ID);

    public static final Supplier<CreativeModeTab>
            TUTORIAL_ITEM_TAB = CREATIVE_MODE_TAB.register("create_some_patches", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.ENRICHED_QUARTZ.get()))
            .title(Component.translatable("creativetabs.tutrial_tab"))
            .displayItems(((itemDisplayParameters, output) -> {
                //---ここからタブ追加アイテムを記述---
                output.accept(ModItems.ENRICHED_QUARTZ);
                output.accept(ModBlocks.RAINBOW_DIAMOND_BLOCK);
                output.accept(ModItems.HEATED_LAVA_BUCKET);
            }))
            .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
