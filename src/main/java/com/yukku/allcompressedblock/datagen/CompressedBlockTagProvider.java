package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class CompressedBlockTagProvider extends BlockTagsProvider {
    public CompressedBlockTagProvider(DataGenerator gen, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(gen.getPackOutput(), lookupProvider, AllCompressedBlock.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        addCompressedBlockTags(BlockTags.MINEABLE_WITH_PICKAXE);
        addCompressedBlockTags(BlockTags.NEEDS_DIAMOND_TOOL);
    }

    private void addCompressedBlockTags(TagKey<Block> tagKey) {
        for (int i = 1; i <= 100; i++) {
            tag(tagKey)
                    .add(TagEntry.element(new ResourceLocation(AllCompressedBlock.MOD_ID + ":" + CompressedBlock.COMPRESSED_DIAMOND_BLOCK + i)))
                    .add(TagEntry.element(new ResourceLocation(AllCompressedBlock.MOD_ID + ":" + CompressedBlock.COMPRESSED_IRON_BLOCK + i)));
        }
    }
}