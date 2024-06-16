package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.item.CompressedItem;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CompressedBlockRecipeProvider extends RecipeProvider {
    public CompressedBlockRecipeProvider(DataGenerator gen) {
        super(gen.getPackOutput());
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // 圧縮レシピ
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CompressedBlock.COMPRESSED_BLOCKS[0].get())
                .define('#', Blocks.DIAMOND_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_diamond_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.DIAMOND_BLOCK).build()))
                .save(consumer);

        for (int i = 0; i < 99; i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CompressedBlock.COMPRESSED_BLOCKS[i + 1].get())
                    .define('#', CompressedBlock.COMPRESSED_BLOCKS[i].get())
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .unlockedBy("has_compressed_block_" + (i + 1), inventoryTrigger(ItemPredicate.Builder.item()
                            .of(CompressedBlock.COMPRESSED_BLOCKS[i].get()).build()))
                    .save(consumer);
        }

        // 解体レシピ
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.DIAMOND_BLOCK, 9)
                .requires(CompressedItem.COMPRESSED_BLOCK_ITEMS[0].get())
                .unlockedBy("has_compressed_block_1", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(CompressedItem.COMPRESSED_BLOCK_ITEMS[0].get()).build()))
                .save(consumer, "allcompressedblock:disassembly_compressed_block_1");

        for (int i = 1; i < 100; i++) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CompressedItem.COMPRESSED_BLOCK_ITEMS[i - 1].get(), 9)
                    .requires(CompressedItem.COMPRESSED_BLOCK_ITEMS[i].get())
                    .unlockedBy("has_compressed_block_" + (i + 1), inventoryTrigger(ItemPredicate.Builder.item()
                            .of(CompressedItem.COMPRESSED_BLOCK_ITEMS[i].get()).build()))
                    .save(consumer, "allcompressedblock:disassembly_compressed_block_" + (i + 1));
        }
    }
}