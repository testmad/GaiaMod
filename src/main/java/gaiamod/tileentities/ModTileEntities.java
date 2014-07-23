package gaiamod.tileentities;

import gaiamod.util.Strings;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static void init()
    {
		
		GameRegistry.registerTileEntity(TileEntityGaiaAltar.class, StatCollector.translateToLocal(Strings.GaiaAltarBlockName));
		
		GameRegistry.registerTileEntity(TileEntityEssenceAltar.class, StatCollector.translateToLocal(Strings.EssenceAltarBlockName));
		
		GameRegistry.registerTileEntity(TileEntityOrderShrine.class, StatCollector.translateToLocal(Strings.OrderShrineBlockName));
		
    }

}
