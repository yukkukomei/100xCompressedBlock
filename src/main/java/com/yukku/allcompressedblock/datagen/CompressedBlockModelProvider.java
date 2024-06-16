package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
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
            getBuilder(CompressedBlock.COMPRESSED_DIAMOND_BLOCK + (i + 1))
                    .parent(getExistingFile(mcLoc("block/cube_all")))
                    .texture("all", modLoc("block/" + CompressedBlock.COMPRESSED_DIAMOND_BLOCK + (i + 1)));
        }
        for (int i = 0; i < 100; i++) {
            getBuilder(CompressedBlock.COMPRESSED_IRON_BLOCK + (i + 1))
                    .parent(getExistingFile(mcLoc("block/cube_all")))
                    .texture("all", modLoc("block/" + CompressedBlock.COMPRESSED_IRON_BLOCK + (i + 1)));
        }
    }
}