package gaiamod.altars;

import gaiamod.lib.Registrar;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModAltars {
	
	public static Block gaiaAltarBlock;
	
	public static void init()
    {
		gaiaAltarBlock = new GaiaAltarBlock();
		Registrar.registerBlock(gaiaAltarBlock);
		
		
    }
}
