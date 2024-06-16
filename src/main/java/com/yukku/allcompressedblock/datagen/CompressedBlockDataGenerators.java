package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AllCompressedBlock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CompressedBlockDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new CompressedBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new CompressedBlockModelProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new CompressedItemModelProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new CompressedBlockLanguageProvider(generator, "en_us"));
        generator.addProvider(event.includeClient(), new CompressedBlockJapanLanguageProvider(generator, "ja_jp"));
        generator.addProvider(event.includeServer(), new CompressedBlockLootTableProvider(generator, existingFileHelper));
        generator.addProvider(event.includeServer(), new CompressedBlockTagProvider(generator, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new CompressedBlockRecipeProvider(generator));
    }
}