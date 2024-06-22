package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class CompressedBlockLanguageProvider extends LanguageProvider {

    public CompressedBlockLanguageProvider (DataGenerator gen, String locale) {
        super(gen.getPackOutput(), AllCompressedBlock.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemgroup.compressed_block", "100x Compressed Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_DIAMOND_BLOCK, "Compressed Diamond Block", "x Compressed Diamond Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_IRON_BLOCK, "Compressed Iron Block", "x Compressed Iron Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_COPPER_BLOCK, "Compressed Copper Block", "x Compressed Copper Block");
    }

    private void addBlockTranslations(String blockName, String singleCompressedName, String multiCompressedName) {
        for (int i = 1; i <= 100; i++) {
            if (i == 1) {
                add("block." + AllCompressedBlock.MOD_ID + "." + blockName + i, singleCompressedName);
            } else {
                add("block." + AllCompressedBlock.MOD_ID + "." + blockName + i, i + multiCompressedName);
            }
        }
    }
}
