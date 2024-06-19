package com.yukku.allcompressedblock.registry.creativetab;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.item.CompressedItem;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AllCompressedBlock.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COMPRESSED_BLOCK = MOD_TABS.register("compressed_block",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(CompressedBlock.COMPRESSED_DIAMOND_BLOCKS[99].get()))
                    .title(Component.translatable("itemgroup.compressed_block"))
                    .displayItems(CreativeTabs::displayCompressedItems)
                    .build());

    private static void displayCompressedItems(Object param, CreativeModeTab.Output output) {
        displayItemsFromRegistry(CompressedItem.COMPRESSED_IRON_BLOCK_ITEMS, output);
        displayItemsFromRegistry(CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEMS, output);
    }

    private static void displayItemsFromRegistry(RegistryObject<Item>[] items, CreativeModeTab.Output output) {
        for (RegistryObject<Item> item : items) {
            output.accept(item.get());
        }
    }
}