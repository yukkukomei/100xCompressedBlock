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

    public static final String COMPRESSED_DIAMOND_BLOCK = "compressed_diamond_block_";
    public static final String COMPRESSED_IRON_BLOCK = "compressed_iron_block_";

    static {
        registerBlocks(COMPRESSED_DIAMOND_BLOCKS, COMPRESSED_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK);
        registerBlocks(COMPRESSED_IRON_BLOCKS, COMPRESSED_IRON_BLOCK, Blocks.IRON_BLOCK);
    }

    private static void registerBlocks(RegistryObject<Block>[] blockArray, String blockName, Block baseBlock) {
        for (int i = 0; i < blockArray.length; i++) {
            blockArray[i] = BLOCKS.register(blockName + (i + 1),
                    () -> new Block(BlockBehaviour.Properties.copy(baseBlock)));
        }
    }
}
