package com.yukku.allcompressedblock.datagen;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.config.ConfigCondition;
import com.yukku.allcompressedblock.item.CompressedItem;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CompressedBlockRecipeProvider extends RecipeProvider {
    public CompressedBlockRecipeProvider(DataGenerator gen) {
        super(gen.getPackOutput());
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // 鉄圧縮解体レシピ
        addCompressedRecipe(consumer, CompressedBlock.COMPRESSED_IRON_BLOCKS, CompressedBlock.COMPRESSED_IRON_BLOCK, Blocks.IRON_BLOCK, "General.registerIron");
        addDisassemblyRecipe(consumer, CompressedItem.COMPRESSED_IRON_BLOCK_ITEMS, CompressedBlock.COMPRESSED_IRON_BLOCK, Blocks.IRON_BLOCK, "General.registerIron");
        // ダイヤ圧縮解体レシピ
        addCompressedRecipe(consumer, CompressedBlock.COMPRESSED_DIAMOND_BLOCKS, CompressedBlock.COMPRESSED_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK, "General.registerDiamond");
        addDisassemblyRecipe(consumer, CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEMS, CompressedBlock.COMPRESSED_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK, "General.registerDiamond");
    }

    private void addCompressedRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<Block>[] blocks, String blockPrefix, Block baseBlock, String configKey) {
        String blockId = baseBlock.getDescriptionId();
        String blockName = blockId.substring(blockId.lastIndexOf(".") + 1);

        ConditionalRecipe.builder()
                .addCondition(new ConfigCondition(configKey, true))
                .addRecipe(
                        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blocks[0].get())
                                .define('#', baseBlock)
                                .pattern("###")
                                .pattern("###")
                                .pattern("###")
                                .unlockedBy("has_" + blockName, inventoryTrigger(ItemPredicate.Builder.item().of(baseBlock).build()))
                                ::save
                )
                .build(consumer, new ResourceLocation(AllCompressedBlock.MOD_ID, "compressed_" + blockPrefix + "1"));

        for (int i = 0; i < 99; i++) {
            ConditionalRecipe.builder()
                    .addCondition(new ConfigCondition(configKey, true))
                    .addRecipe(
                            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blocks[i + 1].get())
                                    .define('#', blocks[i].get())
                                    .pattern("###")
                                    .pattern("###")
                                    .pattern("###")
                                    .unlockedBy("has_" + blockPrefix + (i + 1), inventoryTrigger(ItemPredicate.Builder.item().of(blocks[i].get()).build()))
                                    ::save
                    )
                    .build(consumer, new ResourceLocation(AllCompressedBlock.MOD_ID, "conditional_" + blockPrefix + (i + 2)));
        }
    }

    private void addDisassemblyRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<Item>[] items, String blockPrefix, Block baseBlock, String configKey) {
        ConditionalRecipe.builder()
                .addCondition(new ConfigCondition(configKey, true))
                .addRecipe(
                        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, baseBlock, 9)
                                .requires(items[0].get())
                                .unlockedBy("has_" + blockPrefix + "1", inventoryTrigger(ItemPredicate.Builder.item()
                                        .of(items[0].get()).build()))
                                ::save
                )
                .build(consumer, new ResourceLocation(AllCompressedBlock.MOD_ID, "disassembly_" + blockPrefix + "1"));

        for (int i = 1; i < 100; i++) {
            ConditionalRecipe.builder()
                    .addCondition(new ConfigCondition(configKey, true))
                    .addRecipe(
                            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, items[i - 1].get(), 9)
                                    .requires(items[i].get())
                                    .unlockedBy("has_" + blockPrefix + (i + 1), inventoryTrigger(ItemPredicate.Builder.item()
                                            .of(items[i].get()).build()))
                                    ::save
                    )
                    .build(consumer, new ResourceLocation(AllCompressedBlock.MOD_ID, "disassembly_" + blockPrefix + (i + 1)));
        }
    }
}