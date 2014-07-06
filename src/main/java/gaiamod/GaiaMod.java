package gaiamod;

import gaiamod.armor.ModArmor;
import gaiamod.blocks.ModBlocks;
import gaiamod.core.handlers.GuiHandler;
import gaiamod.core.handlers.RecipeHandler;
import gaiamod.core.proxy.CommonProxy;
import gaiamod.creativetab.GaiaModTab;
import gaiamod.lib.References;
import gaiamod.stones.ModStones;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION)
public class GaiaMod {

	private static CreativeTabs gaiaModTab = new GaiaModTab(CreativeTabs.getNextID(), References.MODID);

	public static CreativeTabs getcreativeTab() {
		return gaiaModTab;
	}
	
	@Mod.Instance(References.MODID)
	public static GaiaMod instance;
	
	@SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		
		FMLCommonHandler.instance().bus().register(handler);
		MinecraftForge.EVENT_BUS.register(handler);
		

		ModBlocks.init();
		ModStones.init();
		ModArmor.init();


		RecipeHandler.init();
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}
}
