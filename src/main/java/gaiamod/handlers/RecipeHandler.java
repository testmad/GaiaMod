package gaiamod.handlers;

import gaiamod.blocks.ModBlocks;
import gaiamod.stones.ModStones;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipeHandler {
	
	public static void init()
    {
        registerRecipes();
    }
 
    public static void registerRecipes()
    {
 
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModBlocks.gaiaAltarBlockIdle, 1),
    						"sss",
    						"cec",
    						"sss",

    						's', Blocks.stone,
    						'c', Items.cauldron,
    						'e', Items.ender_pearl);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModBlocks.essenceAltarBlockIdle, 1),
				"psp",
				"cac",
				"sss",

				'p', Blocks.piston,
				's', Blocks.stone,
				'c', Items.cauldron,
				'a', ModBlocks.gaiaAltarBlockIdle,
				's', Blocks.stone);


    }

}
