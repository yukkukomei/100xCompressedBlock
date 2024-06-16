package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class CompressedBlockJapanLanguageProvider extends LanguageProvider {

    public CompressedBlockJapanLanguageProvider(DataGenerator gen, String locale) {
        super(gen.getPackOutput(), AllCompressedBlock.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemgroup.compressed_block", "Compressed Block");

        for (int i = 1; i <= 100; i++) {
            if (i == 1) {
                add("block.allcompressedblock.compressed_block_" + i, "圧縮ダイヤモンドブロック");
            } else {
                add("block.allcompressedblock.compressed_block_" + i, i + "倍圧縮ダイヤモンドブロック");
            }
        }
    }
}
