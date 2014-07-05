package gaiamod.blocks;

import gaiamod.lib.Registrar;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block gaiaAltarBlock;
	
	public static void init()
    {
		gaiaAltarBlock = new GaiaAltarBlock();
		Registrar.registerBlock(gaiaAltarBlock);
		
		
    }
}
