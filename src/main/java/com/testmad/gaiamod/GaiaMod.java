package com.testmad.gaiamod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import com.testmad.gaiamod.amulets.ModAmulets;
import com.testmad.gaiamod.armor.ModArmor;
import com.testmad.gaiamod.blocks.ModBlocks;
import com.testmad.gaiamod.creativetab.GaiaModTab;
import com.testmad.gaiamod.essence.ModEssence;
import com.testmad.gaiamod.gui.ModGui;
import com.testmad.gaiamod.handlers.GaiaModEventHandler;
import com.testmad.gaiamod.handlers.GuiHandler;
import com.testmad.gaiamod.handlers.RecipeHandler;
import com.testmad.gaiamod.proxy.CommonProxy;
import com.testmad.gaiamod.stones.ModStones;
import com.testmad.gaiamod.tileentities.ModTileEntities;
import com.testmad.gaiamod.util.References;
import com.testmad.gaiamod.weapons.ModWeapons;
import com.testmad.gaiamod.worldgen.GaiaModWorldGen;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION)
public class GaiaMod {

	public static CreativeTabs gaiaModTab;

	GaiaModWorldGen eventWorldGen = new GaiaModWorldGen();
	GaiaModEventHandler handler = new GaiaModEventHandler();

	@Mod.Instance(References.MODID)
	public static GaiaMod instance;

	@SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		FMLCommonHandler.instance().bus().register(handler);
		MinecraftForge.EVENT_BUS.register(handler);

		gaiaModTab = new GaiaModTab(CreativeTabs.getNextID(), References.MODID);

		ModGui.init();
		ModTileEntities.init();

		ModBlocks.init();

		ModEssence.init();
		ModStones.init();
		ModAmulets.init();

		ModWeapons.init();
		ModArmor.init();

		RecipeHandler.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	public static CreativeTabs getcreativeTab() {
		return gaiaModTab;
	}

}
