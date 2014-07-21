package gaiamod.handlers;

import gaiamod.amulets.ModAmulets;
import gaiamod.armor.ModArmor;
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
				"ebf",
				"rvr",
				"wbx",

				'e', ModEssence.emptyEarthEssenceItem,
				'b', Items.water_bucket,
				'f', ModEssence.emptyFireEssenceItem,
				'r', Items.redstone,
				'w', ModEssence.emptyWindEssenceItem,
				'x', ModEssence.emptyWaterEssenceItem,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyChaosEssenceItem, 1),
				"ehf",
				"svs",
				"wdx",

				'e', ModEssence.emptyEarthEssenceItem,
				'h', ModEssence.emptyHeartEssenceItem,
				'd', Items.diamond,
				'f', ModEssence.emptyFireEssenceItem,
				'c', ModEssence.emptyChaosEssenceItem,
				'w', ModEssence.emptyWindEssenceItem,
				'x', ModEssence.emptyWaterEssenceItem,
				'v', ModEssence.essenceItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.emptyOrderEssenceItem, 1),
				"ehf",
				"cvc",
				"wdx",

				'e', ModEssence.emptyEarthEssenceItem,
				'h', ModEssence.emptyHeartEssenceItem,
				'd', Items.emerald,
				'f', ModEssence.emptyFireEssenceItem,
				'c', ModEssence.emptyChaosEssenceItem,
				'w', ModEssence.emptyWindEssenceItem,
				'x', ModEssence.emptyWaterEssenceItem,
				'v', ModEssence.essenceItem);

    	CraftingManager.getInstance().addRecipe(new ItemStack(ModStones.stoneItem, 1),
				"sss",
				"scs",
				"sss",

				's', Blocks.stone,
				's', Blocks.cobblestone);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModAmulets.amuletItem, 1),
				" g ",
				"gbg",
				" g ",

				'g', Items.gold_ingot,
				'g', ModStones.stoneItem);
    	
    	//Armors
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.earthHelmet, 1),
				"sss",
				"s s",
				" a ",

				's', ModStones.earthStoneItem,
				'a', ModAmulets.earthAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.earthChest, 1),
				"sas",
				"sss",
				"sss",

				's', ModStones.earthStoneItem,
				'a', ModAmulets.earthAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.earthLeggings, 1),
				"sss",
				"sas",
				"s s",

				's', ModStones.earthStoneItem,
				'a', ModAmulets.earthAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.earthBoots, 1),
				"s s",
				"s s",
				" a ",

				's', ModStones.earthStoneItem,
				'a', ModAmulets.earthAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.fireHelmet, 1),
				"sss",
				"s s",
				" a ",

				's', ModStones.fireStoneItem,
				'a', ModAmulets.fireAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.fireChest, 1),
				"sas",
				"sss",
				"sss",

				's', ModStones.fireStoneItem,
				'a', ModAmulets.fireAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.fireLeggings, 1),
				"sss",
				"sas",
				"s s",

				's', ModStones.fireStoneItem,
				'a', ModAmulets.fireAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.fireBoots, 1),
				"s s",
				"s s",
				" a ",

				's', ModStones.fireStoneItem,
				'a', ModAmulets.fireAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.windHelmet, 1),
				"sss",
				"s s",
				" a ",

				's', ModStones.windStoneItem,
				'a', ModAmulets.windAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.windChest, 1),
				"sas",
				"sss",
				"sss",

				's', ModStones.windStoneItem,
				'a', ModAmulets.windAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.windLeggings, 1),
				"sss",
				"sas",
				"s s",

				's', ModStones.windStoneItem,
				'a', ModAmulets.windAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.windBoots, 1),
				"s s",
				"s s",
				" a ",

				's', ModStones.windStoneItem,
				'a', ModAmulets.windAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.waterHelmet, 1),
				"sss",
				"s s",
				" a ",

				's', ModStones.waterStoneItem,
				'a', ModAmulets.waterAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.waterChest, 1),
				"sas",
				"sss",
				"sss",

				's', ModStones.waterStoneItem,
				'a', ModAmulets.waterAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.waterLeggings, 1),
				"sss",
				"sas",
				"s s",

				's', ModStones.waterStoneItem,
				'a', ModAmulets.waterAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.waterBoots, 1),
				"s s",
				"s s",
				" a ",

				's', ModStones.waterStoneItem,
				'a', ModAmulets.waterAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.heartHelmet, 1),
				"sss",
				"s s",
				" a ",

				's', ModStones.heartStoneItem,
				'a', ModAmulets.heartAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.heartChest, 1),
				"sas",
				"sss",
				"sss",

				's', ModStones.heartStoneItem,
				'a', ModAmulets.heartAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.heartLeggings, 1),
				"sss",
				"sas",
				"s s",

				's', ModStones.heartStoneItem,
				'a', ModAmulets.heartAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.heartBoots, 1),
				"s s",
				"s s",
				" a ",

				's', ModStones.heartStoneItem,
				'a', ModAmulets.heartAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.stormHelmet, 1),
				"sss",
				"s s",
				" a ",

				's', ModStones.stormStoneItem,
				'a', ModAmulets.stormAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.stormChest, 1),
				"sas",
				"sss",
				"sss",

				's', ModStones.heartStoneItem,
				'a', ModAmulets.heartAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.stormLeggings, 1),
				"sss",
				"sas",
				"s s",

				's', ModStones.stormStoneItem,
				'a', ModAmulets.stormAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.stormBoots, 1),
				"s s",
				"s s",
				" a ",

				's', ModStones.stormStoneItem,
				'a', ModAmulets.stormAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.chaosHelmet, 1),
				"sss",
				"s s",
				" a ",

				's', ModStones.chaosStoneItem,
				'a', ModAmulets.chaosAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.chaosChest, 1),
				"sas",
				"sss",
				"sss",

				's', ModStones.chaosStoneItem,
				'a', ModAmulets.chaosAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.chaosLeggings, 1),
				"sss",
				"sas",
				"s s",

				's', ModStones.chaosStoneItem,
				'a', ModAmulets.chaosAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.chaosBoots, 1),
				"s s",
				"s s",
				" a ",

				's', ModStones.chaosStoneItem,
				'a', ModAmulets.chaosAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.orderHelmet, 1),
				"sss",
				"s s",
				" a ",

				's', ModStones.orderStoneItem,
				'a', ModAmulets.orderAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.orderChest, 1),
				"sas",
				"sss",
				"sss",

				's', ModStones.orderStoneItem,
				'a', ModAmulets.orderAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.orderLeggings, 1),
				"sss",
				"sas",
				"s s",

				's', ModStones.orderStoneItem,
				'a', ModAmulets.orderAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.orderBoots, 1),
				"s s",
				"s s",
				" a ",

				's', ModStones.orderStoneItem,
				'a', ModAmulets.orderAmuletItem);

    }

}
