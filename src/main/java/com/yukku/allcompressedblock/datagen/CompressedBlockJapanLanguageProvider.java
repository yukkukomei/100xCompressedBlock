package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class CompressedBlockJapanLanguageProvider extends LanguageProvider {

    public CompressedBlockJapanLanguageProvider(DataGenerator gen, String locale) {
        super(gen.getPackOutput(), AllCompressedBlock.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemgroup.compressed_block", "100x Compressed Block");
        addBlockTranslations(CompressedBlock.COMPRESSED_DIAMOND_BLOCK, "圧縮ダイヤモンドブロック", "倍圧縮ダイヤモンドブロック");
        addBlockTranslations(CompressedBlock.COMPRESSED_IRON_BLOCK, "圧縮鉄ブロック", "倍圧縮鉄ブロック");
        addBlockTranslations(CompressedBlock.COMPRESSED_COPPER_BLOCK, "圧縮銅ブロック", "倍圧縮銅ブロック");
        addBlockTranslations(CompressedBlock.COMPRESSED_GOLD_BLOCK, "圧縮金ブロック", "倍圧縮金ブロック");
        addBlockTranslations(CompressedBlock.COMPRESSED_EMERALD_BLOCK, "圧縮エメラルドブロック", "倍圧縮エメラルドブロック");
        addBlockTranslations(CompressedBlock.COMPRESSED_LAPIS_BLOCK, "圧縮ラピスラズリブロック", "倍圧縮ラピスラズリブロック");
        addBlockTranslations(CompressedBlock.COMPRESSED_REDSTONE_BLOCK, "圧縮レッドストーンブロック", "倍圧縮レッドストーンブロック");
        addBlockTranslations(CompressedBlock.COMPRESSED_COAL_BLOCK, "圧縮石炭ブロック", "倍圧縮石炭ブロック");
        addBlockTranslations(CompressedBlock.COMPRESSED_NETHERITE_BLOCK, "圧縮ネザライトブロック", "倍圧縮ネザライトブロック");
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
