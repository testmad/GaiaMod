package com.testmad.gaiamod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registrar {

	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, References.MODID + "_"
				+ block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, References.MODID + "_"
				+ item.getUnlocalizedName().substring(5));
	}
}
