package com.yukku.allcompressedblock.block;

import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CompressedBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AllCompressedBlock.MOD_ID);

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_DIAMOND_BLOCKS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_IRON_BLOCKS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_COPPER_BLOCKS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_GOLD_BLOCKS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_EMERALD_BLOCKS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_LAPIS_BLOCKS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_REDSTONE_BLOCKS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_COAL_BLOCKS = new RegistryObject[100];

    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] COMPRESSED_NETHERITE_BLOCKS = new RegistryObject[100];

    public static final String COMPRESSED_DIAMOND_BLOCK = "compressed_diamond_block_";
    public static final String COMPRESSED_IRON_BLOCK = "compressed_iron_block_";
    public static final String COMPRESSED_COPPER_BLOCK = "compressed_copper_block_";
    public static final String COMPRESSED_GOLD_BLOCK = "compressed_gold_block_";
    public static final String COMPRESSED_EMERALD_BLOCK = "compressed_emerald_block_";
    public static final String COMPRESSED_LAPIS_BLOCK = "compressed_lapis_block_";
    public static final String COMPRESSED_REDSTONE_BLOCK = "compressed_redstone_block_";
    public static final String COMPRESSED_COAL_BLOCK = "compressed_coal_block_";
    public static final String COMPRESSED_NETHERITE_BLOCK = "compressed_netherite_block_";

    static {
        registerBlocks(COMPRESSED_DIAMOND_BLOCKS, COMPRESSED_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK);
        registerBlocks(COMPRESSED_IRON_BLOCKS, COMPRESSED_IRON_BLOCK, Blocks.IRON_BLOCK);
        registerBlocks(COMPRESSED_COPPER_BLOCKS, COMPRESSED_COPPER_BLOCK, Blocks.COPPER_BLOCK);
        registerBlocks(COMPRESSED_GOLD_BLOCKS, COMPRESSED_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        registerBlocks(COMPRESSED_EMERALD_BLOCKS, COMPRESSED_EMERALD_BLOCK, Blocks.EMERALD_BLOCK);
        registerBlocks(COMPRESSED_LAPIS_BLOCKS, COMPRESSED_LAPIS_BLOCK, Blocks.LAPIS_BLOCK);
        registerBlocks(COMPRESSED_REDSTONE_BLOCKS, COMPRESSED_REDSTONE_BLOCK, Blocks.REDSTONE_BLOCK);
        registerBlocks(COMPRESSED_COAL_BLOCKS, COMPRESSED_COAL_BLOCK, Blocks.COAL_BLOCK);
        registerBlocks(COMPRESSED_NETHERITE_BLOCKS, COMPRESSED_NETHERITE_BLOCK, Blocks.NETHERITE_BLOCK);
    }

    private static void registerBlocks(RegistryObject<Block>[] blockArray, String blockName, Block baseBlock) {
        for (int i = 0; i < blockArray.length; i++) {
            blockArray[i] = BLOCKS.register(blockName + (i + 1),
                    () -> new Block(BlockBehaviour.Properties.copy(baseBlock)));
        }
    }
}
