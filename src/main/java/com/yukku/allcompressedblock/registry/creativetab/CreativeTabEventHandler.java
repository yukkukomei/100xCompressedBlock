package com.yukku.allcompressedblock.registry.creativetab;

import com.yukku.allcompressedblock.config.CompressedBlockConfig;
import com.yukku.allcompressedblock.item.CompressedItem;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = AllCompressedBlock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabEventHandler {
    @SubscribeEvent
    public static void onCreativeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == CreativeTabs.COMPRESSED_BLOCK.get()) {
            removeItems(event, CompressedBlockConfig.REGISTER_DIAMOND.get(), CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEMS);
            removeItems(event, CompressedBlockConfig.REGISTER_IRON.get(), CompressedItem.COMPRESSED_IRON_BLOCK_ITEMS);
            removeItems(event, CompressedBlockConfig.REGISTER_COPPER.get(), CompressedItem.COMPRESSED_COPPER_BLOCK_ITEMS);
            removeItems(event, CompressedBlockConfig.REGISTER_GOLD.get(), CompressedItem.COMPRESSED_GOLD_BLOCK_ITEMS);
            removeItems(event, CompressedBlockConfig.REGISTER_EMERALD.get(), CompressedItem.COMPRESSED_EMERALD_BLOCK_ITEMS);
            removeItems(event, CompressedBlockConfig.REGISTER_LAPIS.get(), CompressedItem.COMPRESSED_LAPISLAZULI_BLOCK_ITEMS);
            removeItems(event, CompressedBlockConfig.REGISTER_REDSTONE.get(), CompressedItem.COMPRESSED_REDSTONE_BLOCK_ITEMS);
            removeItems(event, CompressedBlockConfig.REGISTER_COAL.get(), CompressedItem.COMPRESSED_COAL_BLOCK_ITEMS);
            removeItems(event, CompressedBlockConfig.REGISTER_NETHERITE.get(), CompressedItem.COMPRESSED_NETHERITE_BLOCK_ITEMS);
        }
    }

    // アイテムをクリエイティブタブから削除
    private static void removeItems(BuildCreativeModeTabContentsEvent event, boolean isDisplay, RegistryObject<Item>[] items) {
        if (!isDisplay) {
            for (RegistryObject<Item> item : items) {
                event.getEntries().remove(new ItemStack(item.get()));
            }
        }
    }
}
