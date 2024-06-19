package com.yukku.allcompressedblock.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CompressedBlockConfig {
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final ForgeConfigSpec.BooleanValue REGISTER_DIAMOND;
    public static final ForgeConfigSpec.BooleanValue REGISTER_IRON;

    public static final String REGISTER_DIAMOND_NAME = "registerDiamond";
    public static final String REGISTER_IRON_NAME = "registerIron";

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("General");
        REGISTER_DIAMOND = builder
                .define(REGISTER_DIAMOND_NAME, true);
        REGISTER_IRON = builder
                .define(REGISTER_IRON_NAME, true);
        builder.pop();

        COMMON_SPEC = builder.build();
    }
}