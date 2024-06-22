package com.yukku.allcompressedblock.config;

import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;

public class ConfigCondition implements ICondition {
    final String configKey;
    final boolean expectedValue;

    public ConfigCondition(String configKey, boolean expectedValue) {
        this.configKey = configKey;
        this.expectedValue = expectedValue;
    }

    @Override
    public ResourceLocation getID() {
        return new ResourceLocation(AllCompressedBlock.MOD_ID, "config_condition");
    }

    @Override
    public boolean test(IContext iContext) {
        // コンフィグの値を取得してレシピの有効化を判定
        return switch (configKey) {
            case "General." + CompressedBlockConfig.REGISTER_DIAMOND_NAME ->
                    CompressedBlockConfig.REGISTER_DIAMOND.get() == expectedValue;
            case "General." + CompressedBlockConfig.REGISTER_IRON_NAME ->
                    CompressedBlockConfig.REGISTER_IRON.get() == expectedValue;
            case "General." + CompressedBlockConfig.REGISTER_COPPER_NAME ->
                    CompressedBlockConfig.REGISTER_COPPER.get() == expectedValue;
            case "General." + CompressedBlockConfig.REGISTER_GOLD_NAME ->
                    CompressedBlockConfig.REGISTER_GOLD.get() == expectedValue;
            case "General." + CompressedBlockConfig.REGISTER_EMERALD_NAME ->
                    CompressedBlockConfig.REGISTER_EMERALD.get() == expectedValue;
            case "General." + CompressedBlockConfig.REGISTER_LAPIS_NAME ->
                    CompressedBlockConfig.REGISTER_LAPIS.get() == expectedValue;
            case "General." + CompressedBlockConfig.REGISTER_REDSTONE_NAME ->
                    CompressedBlockConfig.REGISTER_REDSTONE.get() == expectedValue;
            case "General." + CompressedBlockConfig.REGISTER_COAL_NAME ->
                    CompressedBlockConfig.REGISTER_COAL.get() == expectedValue;
            case "General." + CompressedBlockConfig.REGISTER_NETHERITE_NAME ->
                    CompressedBlockConfig.REGISTER_NETHERITE.get() == expectedValue;
            default -> false;
        };
    }
}