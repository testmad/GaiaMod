package gaiamod;

import gaiamod.armor.ModArmor;
import gaiamod.blocks.ModBlocks;
import gaiamod.core.handlers.CraftingHandler;
import gaiamod.core.proxy.CommonProxy;
import gaiamod.creativetab.GaiaModTab;
import gaiamod.lib.References;
import gaiamod.stones.ModStones;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION)
public class GaiaMod {

	@SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
	public static CommonProxy proxy;

	private static CreativeTabs gaiaModTab = new GaiaModTab(
			CreativeTabs.getNextID(), References.MODID);

	public static CreativeTabs getcreativeTab() {
		return gaiaModTab;
	}

	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event) {

		ModBlocks.init();
		ModStones.init();
		ModArmor.init();

		CraftingHandler.init();
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}
}
