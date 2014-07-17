package gaiamod.blocks;

import gaiamod.GaiaMod;
import gaiamod.util.Registrar;
import gaiamod.util.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block gaiaAltarBlockIdle;
	public static Block gaiaAltarBlockIdlePower;
	public static Block gaiaAltarBlockActive;
	
	public static Block essenceAltarBlockIdle;
	public static Block essenceAltarBlockIdlePower;
	public static Block essenceAltarBlockActive;
	
	public static Block gaiaShrine;
	
	public static void init()
    {

		gaiaAltarBlockIdle = new GaiaAltarBlock(false, false).setBlockName(Strings.GaiaAltarBlockName + "Idle").setCreativeTab(GaiaMod.getcreativeTab()).setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdle);
		
		gaiaAltarBlockIdlePower = new GaiaAltarBlock(false, true).setBlockName(Strings.GaiaAltarBlockName + "IdlePower").setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdlePower);
		
		gaiaAltarBlockActive = new GaiaAltarBlock(true, true).setBlockName(Strings.GaiaAltarBlockName + "Active").setHardness(3.5F).setLightLevel(0.875F);
		Registrar.registerBlock(gaiaAltarBlockActive);
		
		
		essenceAltarBlockIdle = new EssenceAltarBlock(false, false).setBlockName(Strings.EssenceAltarBlockName + "Idle").setCreativeTab(GaiaMod.getcreativeTab()).setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdle);
		
		essenceAltarBlockIdlePower = new EssenceAltarBlock(false, true).setBlockName(Strings.EssenceAltarBlockName + "IdlePower").setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdlePower);
		
		essenceAltarBlockActive = new EssenceAltarBlock(true, true).setBlockName(Strings.EssenceAltarBlockName + "Active").setHardness(3.5F).setLightLevel(0.875F);
		Registrar.registerBlock(gaiaAltarBlockActive);
		
		
		gaiaShrine = new GaiaShrineBlock();
		Registrar.registerBlock(gaiaShrine);
		
    }
}
