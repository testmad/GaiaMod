package gaiamod.tileentities;

import gaiamod.util.Strings;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static void init()
    {
		
		GameRegistry.registerTileEntity(TileEntityGaiaAltarBlock.class, Strings.GaiaAltarBlockName);
		
    }

}
