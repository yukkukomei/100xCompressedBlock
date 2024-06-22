package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.item.CompressedItem;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
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
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public class CompressedBlockLootTableProvider extends LootTableProvider {
    public CompressedBlockLootTableProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen.getPackOutput(), Set.of(), List.of(new SubProviderEntry(CompressedBlockLootSubProvider::new, LootContextParamSets.BLOCK)));
    }

    private static class CompressedBlockLootSubProvider implements LootTableSubProvider {
        public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> writer) {
            registerLootTables(writer, CompressedBlock.COMPRESSED_DIAMOND_BLOCKS, CompressedBlock.COMPRESSED_DIAMOND_BLOCK, CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEM);
            registerLootTables(writer, CompressedBlock.COMPRESSED_IRON_BLOCKS, CompressedBlock.COMPRESSED_IRON_BLOCK, CompressedItem.COMPRESSED_IRON_BLOCK_ITEM);
            registerLootTables(writer, CompressedBlock.COMPRESSED_COPPER_BLOCKS, CompressedBlock.COMPRESSED_COPPER_BLOCK, CompressedItem.COMPRESSED_COPPER_BLOCK_ITEM);
            registerLootTables(writer, CompressedBlock.COMPRESSED_GOLD_BLOCKS, CompressedBlock.COMPRESSED_GOLD_BLOCK, CompressedItem.COMPRESSED_GOLD_BLOCK_ITEM);
            registerLootTables(writer, CompressedBlock.COMPRESSED_EMERALD_BLOCKS, CompressedBlock.COMPRESSED_EMERALD_BLOCK, CompressedItem.COMPRESSED_EMERALD_BLOCK_ITEM);
            registerLootTables(writer, CompressedBlock.COMPRESSED_LAPIS_BLOCKS, CompressedBlock.COMPRESSED_LAPIS_BLOCK, CompressedItem.COMPRESSED_LAPIS_BLOCK_ITEM);
            registerLootTables(writer, CompressedBlock.COMPRESSED_REDSTONE_BLOCKS, CompressedBlock.COMPRESSED_REDSTONE_BLOCK, CompressedItem.COMPRESSED_REDSTONE_BLOCK_ITEM);
            registerLootTables(writer, CompressedBlock.COMPRESSED_COAL_BLOCKS, CompressedBlock.COMPRESSED_COAL_BLOCK, CompressedItem.COMPRESSED_COAL_BLOCK_ITEM);
            registerLootTables(writer, CompressedBlock.COMPRESSED_NETHERITE_BLOCKS, CompressedBlock.COMPRESSED_NETHERITE_BLOCK, CompressedItem.COMPRESSED_NETHERITE_BLOCK_ITEM);
        }

        private void registerLootTables(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> writer, RegistryObject<Block>[] blocks, String blockNamePrefix, String itemNamePrefix) {
            for (int i = 0; i < 100; i++) {
                Block block = blocks[i].get();
                writer.accept(new ResourceLocation(AllCompressedBlock.MOD_ID, "blocks/" + blockNamePrefix + (i + 1)),
                        createCompressedBlockLootTable(block, itemNamePrefix + (i + 1)));
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