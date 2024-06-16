package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.item.CompressedItem;
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
            withExistingParent(CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEM + (i + 1), modLoc("block/" + CompressedBlock.COMPRESSED_DIAMOND_BLOCK + (i + 1)));
        }
    }
}