package gaiamod.blocks;

import gaiamod.GaiaMod;
import gaiamod.util.Registrar;
import gaiamod.util.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block gaiaAltarBlockIdleFull;
	public static Block gaiaAltarBlockIdleEmpty;
	public static Block gaiaAltarBlockActive;
	
	public static void init()
    {

		gaiaAltarBlockIdleFull = new GaiaAltarBlock(false,false).setBlockName(Strings.GaiaAltarBlockName + "IdleFull").setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdleFull);
		
		gaiaAltarBlockIdleEmpty = new GaiaAltarBlock(false,true).setBlockName(Strings.GaiaAltarBlockName + "IdleEmpty").setCreativeTab(GaiaMod.getcreativeTab()).setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdleEmpty);
		
		gaiaAltarBlockActive = new GaiaAltarBlock(true,true).setBlockName(Strings.GaiaAltarBlockName + "Active").setHardness(3.5F).setLightLevel(0.875F);
		Registrar.registerBlock(gaiaAltarBlockActive);
		
    }
}
