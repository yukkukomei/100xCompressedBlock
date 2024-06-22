package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CompressedBlockStateProvider extends BlockStateProvider {
    public CompressedBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen.getPackOutput(), AllCompressedBlock.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_IRON_BLOCKS);
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_DIAMOND_BLOCKS);
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_COPPER_BLOCKS);
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_GOLD_BLOCKS);
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_EMERALD_BLOCKS);
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_LAPIS_BLOCKS);
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_REDSTONE_BLOCKS);
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_COAL_BLOCKS);
        registerCompressedBlockStates(CompressedBlock.COMPRESSED_NETHERITE_BLOCKS);
    }

    private void registerCompressedBlockStates(RegistryObject<Block>[] blocks) {
        for (int i = 0; i < 100; i++) {
            simpleBlock(blocks[i].get());
        }
    }
}