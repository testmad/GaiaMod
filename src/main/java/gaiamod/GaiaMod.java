package gaiamod;

import gaiamod.amulets.ModAmulets;
import gaiamod.armor.ModArmor;
import gaiamod.blocks.ModBlocks;
import gaiamod.creativetab.GaiaModTab;
import gaiamod.essence.ModEssence;
import gaiamod.gui.ModGui;
import gaiamod.handlers.GaiaModEventHandler;
import gaiamod.handlers.GuiHandler;
import gaiamod.handlers.RecipeHandler;
import gaiamod.proxy.CommonProxy;
import gaiamod.stones.ModStones;
import gaiamod.tileentities.ModTileEntities;
import gaiamod.util.References;
import gaiamod.weapons.ModWeapons;
import gaiamod.worldgen.GaiaModWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
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
