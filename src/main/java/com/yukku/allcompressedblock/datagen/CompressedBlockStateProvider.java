package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CompressedBlockStateProvider extends BlockStateProvider {
    public CompressedBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen.getPackOutput(), AllCompressedBlock.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (int i = 0; i < 100; i++) {
            simpleBlock(CompressedBlock.COMPRESSED_DIAMOND_BLOCKS[i].get());
        }
    }
}