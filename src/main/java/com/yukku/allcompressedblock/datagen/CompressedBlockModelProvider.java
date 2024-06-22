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
        registerBlockModels(CompressedBlock.COMPRESSED_DIAMOND_BLOCK, "block/cube_all", CompressedBlock.COMPRESSED_DIAMOND_BLOCK);
        registerBlockModels(CompressedBlock.COMPRESSED_IRON_BLOCK, "block/cube_all", CompressedBlock.COMPRESSED_IRON_BLOCK);
        registerBlockModels(CompressedBlock.COMPRESSED_COPPER_BLOCK, "block/cube_all", CompressedBlock.COMPRESSED_COPPER_BLOCK);
    }

    private void registerBlockModels(String blockPrefix, String parentModel, String texturePrefix) {
        for (int i = 0; i < 100; i++) {
            getBuilder(blockPrefix + (i + 1))
                    .parent(getExistingFile(mcLoc(parentModel)))
                    .texture("all", modLoc("block/" + texturePrefix + (i + 1)));
        }
    }
}