package com.yukku.allcompressedblock.item;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CompressedItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AllCompressedBlock.MOD_ID);

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_DIAMOND_BLOCK_ITEMS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_IRON_BLOCK_ITEMS = new RegistryObject[100];

    public static final String COMPRESSED_DIAMOND_BLOCK_ITEM = "compressed_diamond_block_item_";
    public static final String COMPRESSED_IRON_BLOCK_ITEM = "compressed_iron_block_item_";

    static {
        registerBlockItems(CompressedBlock.COMPRESSED_DIAMOND_BLOCKS, COMPRESSED_DIAMOND_BLOCK_ITEMS, COMPRESSED_DIAMOND_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_IRON_BLOCKS, COMPRESSED_IRON_BLOCK_ITEMS, COMPRESSED_IRON_BLOCK_ITEM);
    }

    private static void registerBlockItems(RegistryObject<Block>[] blockArray, RegistryObject<Item>[] itemArray, String itemName) {
        for (int i = 0; i < itemArray.length; i++) {
            final int index = i;
            itemArray[i] = ITEMS.register(itemName + (index + 1),
                    () -> new BlockItem(blockArray[index].get(), new Item.Properties()));
        }
    }
}
