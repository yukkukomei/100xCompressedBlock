package com.yukku.allcompressedblock.main;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.config.CompressedBlockConfig;
import com.yukku.allcompressedblock.config.ConfigConditionSerializer;
import com.yukku.allcompressedblock.item.CompressedItem;
import com.yukku.allcompressedblock.registry.creativetab.CreativeTabs;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AllCompressedBlock.MOD_ID)
public class AllCompressedBlock {

    public static final String MOD_ID = "allcompressedblock";

    public AllCompressedBlock() {
        // イベントバスの取得
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // 登録処理
        registerBlocks(bus);
        registerItems(bus);
        registerCreativeTabs(bus);
        registerCraftingHelper();
        registerConfig();
    }

    // ブロックの登録
    private void registerBlocks(IEventBus bus) {
        CompressedBlock.BLOCKS.register(bus);
    }

    // アイテムの登録
    private void registerItems(IEventBus bus) {
        CompressedItem.ITEMS.register(bus);
    }

    // クリエイティブタブの登録
    private void registerCreativeTabs(IEventBus bus) {
        CreativeTabs.MOD_TABS.register(bus);
    }

    // カスタム条件の登録
    private void registerCraftingHelper() {
        CraftingHelper.register(new ConfigConditionSerializer());
    }

    // コンフィグの登録
    private void registerConfig() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CompressedBlockConfig.COMMON_SPEC, "100xCompressedBlock-common.toml");
    }
}
