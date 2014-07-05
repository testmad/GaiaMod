package gaiamod.blocks;

import gaiamod.lib.Registrar;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block livingStone;
	
	public static void init()
    {
		livingStone = new LivingStone();
		Registrar.registerBlock(livingStone);
    }
}
