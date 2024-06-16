package com.yukku.allcompressedblock.item;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CompressedItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AllCompressedBlock.MOD_ID);

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_BLOCK_ITEMS = new RegistryObject[100];
    public static final String COMPRESSED_DIAMOND_BLOCK_ITEM = "compressed_diamond_block_item_";

    static {
        for (int i = 0; i < 100; i++) {
            final int index = i;
            COMPRESSED_BLOCK_ITEMS[i] = ITEMS.register(COMPRESSED_DIAMOND_BLOCK_ITEM + (index + 1),
                    () -> new BlockItem(CompressedBlock.COMPRESSED_DIAMOND_BLOCKS[index].get(), new Item.Properties()));
        }
    }
}
