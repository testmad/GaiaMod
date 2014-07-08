package gaiamod.blocks;

import gaiamod.GaiaMod;
import gaiamod.util.Registrar;
import gaiamod.util.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block gaiaAltarBlockIdle;
	public static Block gaiaAltarBlockActive;
	
	public static void init()
    {

		gaiaAltarBlockIdle = new GaiaAltarBlock(false).setBlockName(Strings.GaiaAltarBlockName + "Idle").setCreativeTab(GaiaMod.getcreativeTab()).setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdle);
		
		gaiaAltarBlockActive = new GaiaAltarBlock(true).setBlockName(Strings.GaiaAltarBlockName + "Active").setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockActive);
		
    }
}
