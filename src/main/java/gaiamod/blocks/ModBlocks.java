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
	
	public static Block shrineBlock;
	
	public static Block marbleBlock;
	public static Block marbleBrickBlock;
	
	
	
	public static void init()
    {

		gaiaAltarBlockIdle = new GaiaAltarBlock(false, false).setBlockName(Strings.GaiaAltarBlockName + "Idle").setCreativeTab(GaiaMod.getcreativeTab()).setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdle);
		
		gaiaAltarBlockIdlePower = new GaiaAltarBlock(false, true).setBlockName(Strings.GaiaAltarBlockName + "IdlePower").setHardness(3.5F);
		Registrar.registerBlock(gaiaAltarBlockIdlePower);
		
		gaiaAltarBlockActive = new GaiaAltarBlock(true, true).setBlockName(Strings.GaiaAltarBlockName + "Active").setHardness(3.5F).setLightLevel(0.875F);
		Registrar.registerBlock(gaiaAltarBlockActive);
		
		
		essenceAltarBlockIdle = new EssenceAltarBlock(false, false).setBlockName(Strings.EssenceAltarBlockName + "Idle").setCreativeTab(GaiaMod.getcreativeTab()).setHardness(3.5F);
		Registrar.registerBlock(essenceAltarBlockIdle);
		
		essenceAltarBlockIdlePower = new EssenceAltarBlock(false, true).setBlockName(Strings.EssenceAltarBlockName + "IdlePower").setHardness(3.5F);
		Registrar.registerBlock(essenceAltarBlockIdlePower);
		
		essenceAltarBlockActive = new EssenceAltarBlock(true, true).setBlockName(Strings.EssenceAltarBlockName + "Active").setHardness(3.5F).setLightLevel(0.875F);
		Registrar.registerBlock(essenceAltarBlockActive);
		
		
		shrineBlock = new ShrineBlock().setBlockName(Strings.ShrineBlockName).setHardness(3.5F);
		Registrar.registerBlock(shrineBlock);
		
		
		marbleBlock = new MarbleBlock().setBlockName(Strings.MarbleBlockName).setHardness(1.25F);
		Registrar.registerBlock(marbleBlock);
		
		marbleBrickBlock = new MarbleBrickBlock().setBlockName(Strings.MarbleBrickBlockName).setHardness(1.25F);
		Registrar.registerBlock(marbleBrickBlock);
		
    }
}
