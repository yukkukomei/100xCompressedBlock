package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public class CompressedBlockLootTableProvider extends LootTableProvider {
    public CompressedBlockLootTableProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen.getPackOutput(), Set.of(), List.of(new SubProviderEntry(CompressedBlockLootSubProvider::new, LootContextParamSets.BLOCK)));
    }

    private static class CompressedBlockLootSubProvider implements LootTableSubProvider {
        @Override
        public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> writer) {
            for (int i = 0; i < 100; i++) {
                Block block = CompressedBlock.COMPRESSED_BLOCKS[i].get();
                writer.accept(new ResourceLocation("allcompressedblock", "blocks/compressed_block_" + (i + 1)),
                        createCompressedBlockLootTable(block, "compressed_block_item_" + (i + 1)));
            }
        }

        private LootTable.Builder createCompressedBlockLootTable(Block block, String itemName) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(block)
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                            .when(ExplosionCondition.survivesExplosion()));

            return LootTable.lootTable().withPool(poolBuilder);
        }
    }
}