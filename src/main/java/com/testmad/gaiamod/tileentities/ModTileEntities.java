package com.testmad.gaiamod.tileentities;

import net.minecraft.util.StatCollector;

import com.testmad.gaiamod.util.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(TileEntityGaiaAltar.class,
				StatCollector.translateToLocal(Strings.GaiaAltarBlockName));

		GameRegistry.registerTileEntity(TileEntityEssenceAltar.class,
				StatCollector.translateToLocal(Strings.EssenceAltarBlockName));

		GameRegistry.registerTileEntity(TileEntityOrderShrine.class,
				StatCollector.translateToLocal(Strings.OrderShrineBlockName));
	}
}
