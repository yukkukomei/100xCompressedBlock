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
        // configの値をチェックする
        if (configKey.equals("General." + CompressedBlockConfig.REGISTER_DIAMOND_NAME)) {
            //TODO: ここでconfigの値を取得して、expectedValueと比較する
            return true;
        }
        if (configKey.equals("General." + CompressedBlockConfig.REGISTER_IRON_NAME)) {
            //TODO: ここでconfigの値を取得して、expectedValueと比較する
            return true;
        }
        return false;
    }
}