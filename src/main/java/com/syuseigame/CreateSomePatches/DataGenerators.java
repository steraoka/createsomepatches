package com.syuseigame.CreateSomePatches;

import com.syuseigame.CreateSomePatches.Client.ModBlockStateProvider;
import com.syuseigame.CreateSomePatches.Client.ModENUSLanguageProvider;
import com.syuseigame.CreateSomePatches.Client.ModItemModelProvider;
import com.syuseigame.CreateSomePatches.Client.ModJAJPLanguageProvider;
import com.syuseigame.CreateSomePatches.server.ModBlockLootTableProvider;
import com.syuseigame.CreateSomePatches.server.ModBlockTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = createsomepatches.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new LootTableProvider(
                packOutput,
                java.util.Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        ));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModJAJPLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new ModENUSLanguageProvider(packOutput));
    }
}
