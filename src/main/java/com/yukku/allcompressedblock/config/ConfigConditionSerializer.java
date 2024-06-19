package com.yukku.allcompressedblock.config;

import com.google.gson.JsonObject;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConfigConditionSerializer implements IConditionSerializer<ConfigCondition> {
    @Override
    public void write(JsonObject json, ConfigCondition value) {
        json.addProperty("configKey", value.configKey);
        json.addProperty("expectedValue", value.expectedValue);
    }

    @Override
    public ConfigCondition read(JsonObject json) {
        String configKey = GsonHelper.getAsString(json, "configKey");
        boolean expectedValue = GsonHelper.getAsBoolean(json, "expectedValue");
        return new ConfigCondition(configKey, expectedValue);
    }

    @Override
    public ResourceLocation getID() {
        return new ResourceLocation(AllCompressedBlock.MOD_ID, "config_condition");
    }
}
