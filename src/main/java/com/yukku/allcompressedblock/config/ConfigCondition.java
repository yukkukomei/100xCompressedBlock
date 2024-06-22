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
            default -> false;
        };
    }
}