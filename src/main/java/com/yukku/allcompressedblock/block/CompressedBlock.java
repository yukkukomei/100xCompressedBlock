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
    public static final String COMPRESSED_DIAMOND_BLOCK = "compressed_diamond_block_";

    static {
        for (int i = 0; i < 100; i++) {
            COMPRESSED_DIAMOND_BLOCKS[i] = BLOCKS.register(COMPRESSED_DIAMOND_BLOCK + (i + 1),
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
        }
    }
}
