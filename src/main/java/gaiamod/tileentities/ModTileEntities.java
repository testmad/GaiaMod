package gaiamod.tileentities;

import net.minecraft.util.StatCollector;
import gaiamod.util.Strings;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static void init()
    {
		
		GameRegistry.registerTileEntity(TileEntityGaiaAltar.class, StatCollector.translateToLocal(Strings.GaiaAltarBlockName));
		
    }

}
