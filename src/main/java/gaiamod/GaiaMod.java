package gaiamod;

import gaiamod.armor.ModArmor;
import gaiamod.blocks.ModBlocks;
import gaiamod.containers.ModContainers;
import gaiamod.creativetab.GaiaModTab;
import gaiamod.gui.ModGui;
import gaiamod.handlers.GuiHandler;
import gaiamod.handlers.ModHandlers;
import gaiamod.handlers.RecipeHandler;
import gaiamod.items.ModItems;
import gaiamod.proxy.CommonProxy;
import gaiamod.shrines.ModShrines;
import gaiamod.stones.ModStones;
import gaiamod.tileentities.ModTileEntities;
import gaiamod.tools.ModTools;
import gaiamod.util.References;
import gaiamod.weapons.ModWeapons;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION)
public class GaiaMod {

	public static CreativeTabs gaiaModTab;
	
	@Mod.Instance(References.MODID)
	public static GaiaMod instance;
	
	@SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		gaiaModTab = new GaiaModTab(CreativeTabs.getNextID(), References.MODID);
		
		ModHandlers.init();
		ModTileEntities.init();
		ModContainers.init();
		
		ModBlocks.init();
		ModItems.init();
		ModStones.init();
		ModShrines.init();
		ModTools.init();
		ModWeapons.init();
		ModArmor.init();
		
		ModGui.init();

		RecipeHandler.init();
		
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
	
	public static CreativeTabs getcreativeTab() {
		return gaiaModTab;
	}
}
