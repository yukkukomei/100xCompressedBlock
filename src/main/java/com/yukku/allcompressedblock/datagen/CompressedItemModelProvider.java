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
        registerItemModels(CompressedItem.COMPRESSED_IRON_BLOCK_ITEM, CompressedBlock.COMPRESSED_IRON_BLOCK);
        registerItemModels(CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEM, CompressedBlock.COMPRESSED_DIAMOND_BLOCK);
        registerItemModels(CompressedItem.COMPRESSED_COPPER_BLOCK_ITEM, CompressedBlock.COMPRESSED_COPPER_BLOCK);
        registerItemModels(CompressedItem.COMPRESSED_GOLD_BLOCK_ITEM, CompressedBlock.COMPRESSED_GOLD_BLOCK);
        registerItemModels(CompressedItem.COMPRESSED_EMERALD_BLOCK_ITEM, CompressedBlock.COMPRESSED_EMERALD_BLOCK);
        registerItemModels(CompressedItem.COMPRESSED_LAPIS_BLOCK_ITEM, CompressedBlock.COMPRESSED_LAPIS_BLOCK);
        registerItemModels(CompressedItem.COMPRESSED_REDSTONE_BLOCK_ITEM, CompressedBlock.COMPRESSED_REDSTONE_BLOCK);
        registerItemModels(CompressedItem.COMPRESSED_COAL_BLOCK_ITEM, CompressedBlock.COMPRESSED_COAL_BLOCK);
        registerItemModels(CompressedItem.COMPRESSED_NETHERITE_BLOCK_ITEM, CompressedBlock.COMPRESSED_NETHERITE_BLOCK);
    }

    private void registerItemModels(String itemPrefix, String blockPrefix) {
        for (int i = 0; i < 100; i++) {
            withExistingParent(itemPrefix + (i + 1), modLoc("block/" + blockPrefix + (i + 1)));
        }
    }
}