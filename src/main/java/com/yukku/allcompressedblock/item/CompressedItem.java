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

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_COPPER_BLOCK_ITEMS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_GOLD_BLOCK_ITEMS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_EMERALD_BLOCK_ITEMS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_LAPISLAZULI_BLOCK_ITEMS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_REDSTONE_BLOCK_ITEMS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_COAL_BLOCK_ITEMS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Item>[] COMPRESSED_NETHERITE_BLOCK_ITEMS = new RegistryObject[100];

    public static final String COMPRESSED_DIAMOND_BLOCK_ITEM = "compressed_diamond_block_item_";
    public static final String COMPRESSED_IRON_BLOCK_ITEM = "compressed_iron_block_item_";
    public static final String COMPRESSED_COPPER_BLOCK_ITEM = "compressed_copper_block_item_";
    public static final String COMPRESSED_GOLD_BLOCK_ITEM = "compressed_gold_block_item_";
    public static final String COMPRESSED_EMERALD_BLOCK_ITEM = "compressed_emerald_block_item_";
    public static final String COMPRESSED_LAPIS_BLOCK_ITEM = "compressed_lapis_block_item_";
    public static final String COMPRESSED_REDSTONE_BLOCK_ITEM = "compressed_redstone_block_item_";
    public static final String COMPRESSED_COAL_BLOCK_ITEM = "compressed_coal_block_item_";
    public static final String COMPRESSED_NETHERITE_BLOCK_ITEM = "compressed_netherite_block_item_";

    static {
        registerBlockItems(CompressedBlock.COMPRESSED_DIAMOND_BLOCKS, COMPRESSED_DIAMOND_BLOCK_ITEMS, COMPRESSED_DIAMOND_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_IRON_BLOCKS, COMPRESSED_IRON_BLOCK_ITEMS, COMPRESSED_IRON_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_COPPER_BLOCKS, COMPRESSED_COPPER_BLOCK_ITEMS, COMPRESSED_COPPER_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_GOLD_BLOCKS, COMPRESSED_GOLD_BLOCK_ITEMS, COMPRESSED_GOLD_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_EMERALD_BLOCKS, COMPRESSED_EMERALD_BLOCK_ITEMS, COMPRESSED_EMERALD_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_LAPIS_BLOCKS, COMPRESSED_LAPISLAZULI_BLOCK_ITEMS, COMPRESSED_LAPIS_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_REDSTONE_BLOCKS, COMPRESSED_REDSTONE_BLOCK_ITEMS, COMPRESSED_REDSTONE_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_COAL_BLOCKS, COMPRESSED_COAL_BLOCK_ITEMS, COMPRESSED_COAL_BLOCK_ITEM);
        registerBlockItems(CompressedBlock.COMPRESSED_NETHERITE_BLOCKS, COMPRESSED_NETHERITE_BLOCK_ITEMS, COMPRESSED_NETHERITE_BLOCK_ITEM);
    }

    private static void registerBlockItems(RegistryObject<Block>[] blockArray, RegistryObject<Item>[] itemArray, String itemName) {
        for (int i = 0; i < itemArray.length; i++) {
            final int index = i;
            itemArray[i] = ITEMS.register(itemName + (index + 1),
                    () -> new BlockItem(blockArray[index].get(), new Item.Properties()));
        }
    }
}
