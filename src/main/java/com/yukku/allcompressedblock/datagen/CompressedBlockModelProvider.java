package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CompressedBlockModelProvider extends BlockModelProvider {
    public CompressedBlockModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen.getPackOutput(), AllCompressedBlock.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        for (int i = 0; i < 100; i++) {
            getBuilder("compressed_block_" + (i + 1))
                    .parent(getExistingFile(mcLoc("block/cube_all")))
                    .texture("all", modLoc("block/compressed_block_" + (i + 1)));
        }
    }
}