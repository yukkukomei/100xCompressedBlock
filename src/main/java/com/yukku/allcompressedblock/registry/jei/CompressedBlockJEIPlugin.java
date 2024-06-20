package com.yukku.allcompressedblock.registry.jei;

import com.yukku.allcompressedblock.config.CompressedBlockConfig;
import com.yukku.allcompressedblock.item.CompressedItem;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class CompressedBlockJEIPlugin implements IModPlugin {
    private static final ResourceLocation UID = new ResourceLocation(AllCompressedBlock.MOD_ID, "jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        IIngredientManager ingredientManager = jeiRuntime.getIngredientManager();

        if (!CompressedBlockConfig.REGISTER_DIAMOND.get()) {
            // ダイヤ圧縮ブロックの登録が無効の場合は非表示
            List<ItemStack> itemsToHide = new ArrayList<>();
            for (RegistryObject<Item> item : CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEMS) {
                itemsToHide.add(new ItemStack(item.get()));
            }
            ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, itemsToHide);
        }

        if (!CompressedBlockConfig.REGISTER_IRON.get()) {
            // 鉄圧縮ブロックの登録が無効の場合は非表示
            List<ItemStack> itemsToHide = new ArrayList<>();
            for (RegistryObject<Item> item : CompressedItem.COMPRESSED_IRON_BLOCK_ITEMS) {
                itemsToHide.add(new ItemStack(item.get()));
            }
            ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, itemsToHide);
        }
    }
}
