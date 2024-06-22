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
        addBlockTranslations(CompressedBlock.COMPRESSED_GOLD_BLOCK, "Compressed Gold Block", "x Compressed Gold Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_EMERALD_BLOCK, "Compressed Emerald Block", "x Compressed Emerald Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_LAPIS_BLOCK, "Compressed Lapis Lazuli Block", "x Compressed Lapis Lazuli Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_REDSTONE_BLOCK, "Compressed Redstone Block", "x Compressed Redstone Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_COAL_BLOCK, "Compressed Coal Block", "x Compressed Coal Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_NETHERITE_BLOCK, "Compressed Netherite Block", "x Compressed Netherite Block");
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
