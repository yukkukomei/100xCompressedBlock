package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CompressedItemModelProvider extends ItemModelProvider {
    public CompressedItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen.getPackOutput(), AllCompressedBlock.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        for (int i = 0; i < 100; i++) {
            withExistingParent("compressed_block_item_" + (i + 1), modLoc("block/compressed_block_" + (i + 1)));
        }
    }
}