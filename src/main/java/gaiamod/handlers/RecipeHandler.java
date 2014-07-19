package gaiamod.handlers;

import gaiamod.blocks.ModBlocks;
import gaiamod.essence.ModEssence;
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
 
    	//Blocks//
    	
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
    	
    	
    	//Essence//
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.essenceItem, 1),
				" g ",
				"gog",
				"ggg",

				'g', Blocks.glass,
				'o', Blocks.obsidian);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyEarthEssenceItem, 1),
				"ddd",
				"dvd",
				"ddd",

				'd', Blocks.dirt,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyFireEssenceItem, 1),
				"bbb",
				"bvb",
				"bbb",

				'b', Items.lava_bucket,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyWindEssenceItem, 1),
				"fff",
				"fvf",
				"fff",

				'f', Items.feather,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyWaterEssenceItem, 1),
				"bbb",
				"bvb",
				"bbb",

				'b', Items.water_bucket,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyHeartEssenceItem, 1),
				"ppp",
				"pvp",
				"ppp",

				'p', Items.porkchop,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyStormEssenceItem, 1),
				"e f",
				" v ",
				"w x",

				'e', ModEssence.emptyEarthEssenceItem,
				'f', ModEssence.emptyFireEssenceItem,
				'w', ModEssence.emptyWindEssenceItem,
				'x', ModEssence.emptyWaterEssenceItem,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyChaosEssenceItem, 1),
				"ebf",
				"svs",
				"wbx",

				'e', ModEssence.emptyEarthEssenceItem,
				'b', Items.diamond,
				'f', ModEssence.emptyFireEssenceItem,
				'c', ModEssence.emptyChaosEssenceItem,
				'w', ModEssence.emptyWindEssenceItem,
				'x', ModEssence.emptyWaterEssenceItem,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyOrderEssenceItem, 1),
				"ebf",
				"cvc",
				"wbx",

				'e', ModEssence.emptyEarthEssenceItem,
				'b', Items.emerald,
				'f', ModEssence.emptyFireEssenceItem,
				'c', ModEssence.emptyChaosEssenceItem,
				'w', ModEssence.emptyWindEssenceItem,
				'x', ModEssence.emptyWaterEssenceItem,
				'v', ModEssence.essenceItem);


    }

}
