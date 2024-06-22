package com.yukku.allcompressedblock.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CompressedBlockConfig {
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final ForgeConfigSpec.BooleanValue REGISTER_DIAMOND;
    public static final ForgeConfigSpec.BooleanValue REGISTER_IRON;
    public static final ForgeConfigSpec.BooleanValue REGISTER_COPPER;
    public static final ForgeConfigSpec.BooleanValue REGISTER_GOLD;
    public static final ForgeConfigSpec.BooleanValue REGISTER_EMERALD;
    public static final ForgeConfigSpec.BooleanValue REGISTER_LAPIS;
    public static final ForgeConfigSpec.BooleanValue REGISTER_REDSTONE;
    public static final ForgeConfigSpec.BooleanValue REGISTER_COAL;
    public static final ForgeConfigSpec.BooleanValue REGISTER_NETHERITE;

    public static final String REGISTER_DIAMOND_NAME = "registerDiamond";
    public static final String REGISTER_IRON_NAME = "registerIron";
    public static final String REGISTER_COPPER_NAME = "registerCopper";
    public static final String REGISTER_GOLD_NAME = "registerGold";
    public static final String REGISTER_EMERALD_NAME = "registerEmerald";
    public static final String REGISTER_LAPIS_NAME = "registerLapis";
    public static final String REGISTER_REDSTONE_NAME = "registerRedstone";
    public static final String REGISTER_COAL_NAME = "registerCoal";
    public static final String REGISTER_NETHERITE_NAME = "registerNetherite";

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("General");
        REGISTER_DIAMOND = builder
                .define(REGISTER_DIAMOND_NAME, true);
        REGISTER_IRON = builder
                .define(REGISTER_IRON_NAME, true);
        REGISTER_COPPER = builder
                .define(REGISTER_COPPER_NAME, true);
        REGISTER_GOLD = builder
                .define(REGISTER_GOLD_NAME, true);
        REGISTER_EMERALD = builder
                .define(REGISTER_EMERALD_NAME, true);
        REGISTER_LAPIS = builder
                .define(REGISTER_LAPIS_NAME, true);
        REGISTER_REDSTONE = builder
                .define(REGISTER_REDSTONE_NAME, true);
        REGISTER_COAL = builder
                .define(REGISTER_COAL_NAME, true);
        REGISTER_NETHERITE = builder
                .define(REGISTER_NETHERITE_NAME, true);
        builder.pop();

        COMMON_SPEC = builder.build();
    }
}
