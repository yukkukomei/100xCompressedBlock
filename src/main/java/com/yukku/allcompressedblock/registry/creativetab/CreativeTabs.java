package com.yukku.allcompressedblock.registry.creativetab;

import com.yukku.allcompressedblock.item.CompressedItem;
import com.yukku.allcompressedblock.main.AllCompressedBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AllCompressedBlock.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COMPRESSED_BLOCK = MOD_TABS.register("compressed_block",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Blocks.DIAMOND_BLOCK))
                    .title(Component.translatable("itemgroup.compressed_block"))
                    .displayItems((param, output) -> {
                        for (RegistryObject<Item> item : CompressedItem.COMPRESSED_BLOCK_ITEMS) {
                            output.accept(item.get());
                        }
                    })
                    .build());
}