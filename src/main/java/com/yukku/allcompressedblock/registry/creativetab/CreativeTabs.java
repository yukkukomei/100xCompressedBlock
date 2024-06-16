package com.yukku.allcompressedblock.registry.creativetab;

import com.yukku.allcompressedblock.block.CompressedBlock;
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
                    .icon(() -> new ItemStack(CompressedBlock.COMPRESSED_DIAMOND_BLOCKS[99].get()))
                    .title(Component.translatable("itemgroup.compressed_block"))
                    .displayItems((param, output) -> {
                        for (RegistryObject<Item> item : CompressedItem.COMPRESSED_IRON_BLOCK_ITEMS) {
                            output.accept(item.get());
                        }
                        for (RegistryObject<Item> item : CompressedItem.COMPRESSED_DIAMOND_BLOCK_ITEMS) {
                            output.accept(item.get());
                        }
                    })
                    .build());
}