package com.testmad.gaiamod.handlers;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

import com.testmad.gaiamod.amulets.ModAmulets;
import com.testmad.gaiamod.armor.ModArmor;
import com.testmad.gaiamod.blocks.ModBlocks;
import com.testmad.gaiamod.essence.ModEssence;
import com.testmad.gaiamod.stones.ModStones;
import com.testmad.gaiamod.weapons.ModWeapons;

public class RecipeHandler {
	
	public static void init()
    {
        registerRecipes();
    }
 
    public static void registerRecipes()
    {
 
    	//Blocks//
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModBlocks.marbleBrickBlock, 4),
    			"ss ",
				"ss ",
				"   ",

				's', ModBlocks.marbleBlock);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModBlocks.gaiaAltarBlockIdle, 1),
    			"sss",
				"cec",
				"sss",

				's', ModBlocks.marbleBlock,
				'c', Items.cauldron,
				'e', Items.ender_pearl);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModBlocks.essenceAltarBlockIdle, 1),
				"psp",
				"cac",
				"sss",

				'p', Blocks.piston,
				's', ModBlocks.marbleBlock,
				'c', Items.cauldron,
				'a', ModBlocks.gaiaAltarBlockIdle);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModBlocks.orderShrineBlockIdle, 1),
				"sas",
				"geg",
				"sas",

				's', ModBlocks.marbleBlock,
				'g', ModBlocks.essenceAltarBlockIdle,
				'e', Items.emerald,
				'a', Blocks.anvil);
    	
    	
    	//Essence//
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModEssence.essenceItem, 4),
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
				'h', ModEssence.emptyStormEssenceItem,
				'd', Items.diamond,
				'f', ModEssence.emptyFireEssenceItem,
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
				"esf",
				"w x",
				" a ",

				's', ModStones.heartStoneItem,
				'e', ModArmor.earthHelmet,
				'f', ModArmor.fireHelmet,
				'w', ModArmor.windHelmet,
				'x', ModArmor.waterHelmet,
				'a', ModAmulets.heartAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.heartChest, 1),
				"eaf",
				"wsx",
				"sss",

				's', ModStones.heartStoneItem,
				'e', ModArmor.earthChest,
				'f', ModArmor.fireChest,
				'w', ModArmor.windChest,
				'x', ModArmor.waterChest,
				'a', ModAmulets.heartAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.heartLeggings, 1),
				"esf",
				"wax",
				"s s",

				's', ModStones.heartStoneItem,
				'e', ModArmor.earthLeggings,
				'f', ModArmor.fireLeggings,
				'w', ModArmor.windLeggings,
				'x', ModArmor.waterLeggings,
				'a', ModAmulets.heartAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.heartBoots, 1),
				"e f",
				"wsx",
				" a ",

				's', ModStones.heartStoneItem,
				'e', ModArmor.earthBoots,
				'f', ModArmor.fireBoots,
				'w', ModArmor.windBoots,
				'x', ModArmor.waterBoots,
				'a', ModAmulets.heartAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.stormHelmet, 1),
				"esf",
				"w x",
				" a ",

				's', ModStones.stormStoneItem,
				'e', ModArmor.earthHelmet,
				'f', ModArmor.fireHelmet,
				'w', ModArmor.windHelmet,
				'x', ModArmor.waterHelmet,
				'a', ModAmulets.stormAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.stormChest, 1),
				"eaf",
				"wsx",
				"sss",

				's', ModStones.heartStoneItem,
				'e', ModArmor.earthChest,
				'f', ModArmor.fireChest,
				'w', ModArmor.windChest,
				'x', ModArmor.waterChest,
				'a', ModAmulets.heartAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.stormLeggings, 1),
				"esf",
				"wax",
				"s s",

				's', ModStones.stormStoneItem,
				'e', ModArmor.earthLeggings,
				'f', ModArmor.fireLeggings,
				'w', ModArmor.windLeggings,
				'x', ModArmor.waterLeggings,
				'a', ModAmulets.stormAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.stormBoots, 1),
				"e f",
				"wsx",
				" a ",

				's', ModStones.stormStoneItem,
				'e', ModArmor.earthBoots,
				'f', ModArmor.fireBoots,
				'w', ModArmor.windBoots,
				'x', ModArmor.waterBoots,
				'a', ModAmulets.stormAmuletItem);
  	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.chaosHelmet, 1),
				"esf",
				"w x",
				" a ",

				's', ModStones.chaosStoneItem,
				'e', ModArmor.earthHelmet,
				'f', ModArmor.fireHelmet,
				'w', ModArmor.windHelmet,
				'x', ModArmor.stormHelmet,
				'a', ModAmulets.chaosAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.chaosChest, 1),
				"eaf",
				"wsx",
				"sss",

				's', ModStones.chaosStoneItem,
				'e', ModArmor.earthChest,
				'f', ModArmor.fireChest,
				'w', ModArmor.windChest,
				'x', ModArmor.stormChest,
				'a', ModAmulets.chaosAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.chaosLeggings, 1),
				"esf",
				"wax",
				"s s",

				's', ModStones.chaosStoneItem,
				'e', ModArmor.earthLeggings,
				'f', ModArmor.fireLeggings,
				'w', ModArmor.windLeggings,
				'x', ModArmor.stormLeggings,
				'a', ModAmulets.chaosAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.chaosBoots, 1),
				"e f",
				"wsx",
				" a ",

				's', ModStones.chaosStoneItem,
				'e', ModArmor.earthBoots,
				'f', ModArmor.fireBoots,
				'w', ModArmor.windBoots,
				'x', ModArmor.stormBoots,
				'a', ModAmulets.chaosAmuletItem);
    	
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.orderHelmet, 1),
				"ecf",
				"wsx",
				" a ",

				's', ModArmor.stormHelmet,
				'e', ModArmor.earthHelmet,
				'f', ModArmor.heartHelmet,
				'w', ModArmor.windHelmet,
				'c', ModArmor.chaosHelmet,
				'x', ModArmor.waterHelmet,
				'a', ModAmulets.orderAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.orderChest, 1),
				"eaf",
				"wsx",
				"csq",

				's', ModStones.orderStoneItem,
				'e', ModArmor.earthChest,
				'f', ModArmor.heartChest,
				'w', ModArmor.windChest,
				'c', ModArmor.chaosChest,
				'q', ModArmor.stormChest,
				'x', ModArmor.waterChest,
				'a', ModAmulets.orderAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.orderLeggings, 1),
				"esf",
				"wax",
				"c q",

				's', ModStones.orderStoneItem,
				'e', ModArmor.earthLeggings,
				'f', ModArmor.heartLeggings,
				'w', ModArmor.windLeggings,
				'c', ModArmor.chaosChest,
				'q', ModArmor.stormChest,
				'x', ModArmor.waterLeggings,
				'a', ModAmulets.orderAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModArmor.orderBoots, 1),
				"e f",
				"wsx",
				"caq",

				's', ModStones.orderStoneItem,
				'e', ModArmor.earthBoots,
				'f', ModArmor.heartBoots,
				'w', ModArmor.windBoots,
				'c', ModArmor.chaosChest,
				'q', ModArmor.stormChest,
				'x', ModArmor.waterBoots,
				'a', ModAmulets.orderAmuletItem);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModWeapons.stormSword, 1),
				"ese",
				" s ",
				"eie",

				's', ModStones.stormStoneItem,
				'e', ModEssence.stormEssenceItem,
				'i', Items.iron_ingot);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModWeapons.chaosSword, 1),
				"ese",
				" s ",
				"eie",

				's', ModStones.chaosStoneItem,
				'e', ModEssence.chaosEssenceItem,
				'i', Items.iron_ingot);
    	
    	CraftingManager.getInstance().addRecipe(new ItemStack(ModWeapons.orderSword, 1),
				"ese",
				" s ",
				"eie",

				's', ModStones.orderStoneItem,
				'e', ModEssence.orderEssenceItem,
				'i', Items.iron_ingot);

    }

}
