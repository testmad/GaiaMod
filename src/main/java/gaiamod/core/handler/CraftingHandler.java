package gaiamod.core.handler;

import gaiamod.blocks.ModBlocks;
import gaiamod.stones.ModStones;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class CraftingHandler {
	
	public static void init()
    {
        registerRecipes();
    }
 
    public static void registerRecipes()
    {
 
    	//CraftingManager.getInstance().addRecipe(new ItemStack(ModItems.testItem, 2), "###","#s#","###", '#', Blocks.dirt, 's', ModBlocks.livingStone);
    	
    }

}
