package com.yukku.allcompressedblock.main;

import com.yukku.allcompressedblock.block.CompressedBlock;
import com.yukku.allcompressedblock.item.CompressedItem;
import com.yukku.allcompressedblock.registry.creativetab.CreativeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AllCompressedBlock.MOD_ID)
public class AllCompressedBlock {

    public static final String MOD_ID = "allcompressedblock";

    public AllCompressedBlock() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        CompressedBlock.BLOCKS.register(bus);
        CompressedItem.ITEMS.register(bus);
        CreativeTabs.MOD_TABS.register(bus);
    }
}
