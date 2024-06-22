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

        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_DIAMOND.get(), CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEMS);
        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_IRON.get(), CompressedItem.COMPRESSED_IRON_BLOCK_ITEMS);
        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_COPPER.get(), CompressedItem.COMPRESSED_COPPER_BLOCK_ITEMS);
        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_GOLD.get(), CompressedItem.COMPRESSED_GOLD_BLOCK_ITEMS);
        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_EMERALD.get(), CompressedItem.COMPRESSED_EMERALD_BLOCK_ITEMS);
        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_LAPIS.get(), CompressedItem.COMPRESSED_LAPISLAZULI_BLOCK_ITEMS);
        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_REDSTONE.get(), CompressedItem.COMPRESSED_REDSTONE_BLOCK_ITEMS);
        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_COAL.get(), CompressedItem.COMPRESSED_COAL_BLOCK_ITEMS);
        hideItems(ingredientManager, CompressedBlockConfig.REGISTER_NETHERITE.get(), CompressedItem.COMPRESSED_NETHERITE_BLOCK_ITEMS);
    }

    private void hideItems(IIngredientManager ingredientManager, boolean isDisplay, RegistryObject<Item>[] items) {
        if (!isDisplay) {
            List<ItemStack> itemsToHide = new ArrayList<>();
            for (RegistryObject<Item> item : items) {
                itemsToHide.add(new ItemStack(item.get()));
            }
            ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, itemsToHide);
        }
    }
}
