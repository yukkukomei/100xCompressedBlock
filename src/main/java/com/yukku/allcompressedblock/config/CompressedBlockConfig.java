package com.yukku.allcompressedblock.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CompressedBlockConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final ForgeConfigSpec.BooleanValue REGISTER_DIAMOND;
    public static final ForgeConfigSpec.BooleanValue REGISTER_IRON;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("General");
        REGISTER_DIAMOND = builder
                .define("registerDiamond", true);
        REGISTER_IRON = builder
                .define("registerIron", true);
        builder.pop();

        COMMON_SPEC = builder.build();
    }
}
