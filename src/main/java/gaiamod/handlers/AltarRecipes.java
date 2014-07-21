package gaiamod.handlers;

import gaiamod.amulets.ModAmulets;
import gaiamod.essence.ModEssence;
import gaiamod.stones.ModStones;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AltarRecipes {

	public AltarRecipes(){
		
		
	}

	public static ItemStack getAltarResult(Item item, Item item2, Item item3, Item item4) {
		return getOutput(item, item2, item3, item4);
	}

	private static ItemStack getOutput(Item item, Item item2, Item item3, Item item4) {
		if (item == ModEssence.earthEssenceItem && item2 ==  Item.getItemFromBlock(Blocks.dirt) && item3 ==  Item.getItemFromBlock(Blocks.dirt) && item4 ==  ModStones.stoneItem){
			return new ItemStack(ModStones.earthStoneItem, 1);
		}
		
		if (item == ModEssence.fireEssenceItem && item2 ==  Items.lava_bucket && item3 ==  Items.lava_bucket && item4 ==  ModStones.stoneItem){
			return new ItemStack(ModStones.fireStoneItem, 1);
		}
		
		if (item == ModEssence.windEssenceItem && item2 ==  Items.feather && item3 ==  Items.feather && item4 ==  ModStones.stoneItem){
			return new ItemStack(ModStones.windStoneItem, 1);
		}
		
		if (item == ModEssence.waterEssenceItem && item2 ==  Items.water_bucket && item3 ==  Items.water_bucket && item4 ==  ModStones.stoneItem){
			return new ItemStack(ModStones.waterStoneItem, 1);
		}
		
		if (item == ModEssence.heartEssenceItem && item2 ==  Items.porkchop && item3 ==  Items.porkchop && item4 ==  ModStones.stoneItem){
			return new ItemStack(ModStones.heartStoneItem, 1);
		}
		
		if (item == ModEssence.stormEssenceItem && item2 ==  Items.water_bucket && item3 ==  Items.redstone && item4 ==  ModStones.stoneItem){
			return new ItemStack(ModStones.stormStoneItem, 1);
		}
		
		if (item == ModEssence.chaosEssenceItem && item2 ==  Item.getItemFromBlock(Blocks.obsidian) && item3 ==  Items.diamond && item4 ==  ModStones.stoneItem){
			return new ItemStack(ModStones.chaosStoneItem, 1);
		}
		
		if (item == ModEssence.orderEssenceItem && item2 ==  Items.diamond && item3 ==  Items.emerald && item4 ==  ModStones.stoneItem){
			return new ItemStack(ModStones.orderStoneItem, 1);
		}
		
		
		if (item == ModStones.earthStoneItem && item2 ==  Item.getItemFromBlock(Blocks.dirt) && item3 ==  Item.getItemFromBlock(Blocks.dirt) && item4 ==  ModAmulets.amuletItem){
			return new ItemStack(ModAmulets.earthAmuletItem, 1);
		}
		
		if (item == ModStones.fireStoneItem && item2 ==  Items.lava_bucket && item3 ==  Items.lava_bucket && item4 ==  ModAmulets.amuletItem){
			return new ItemStack(ModAmulets.fireAmuletItem, 1);
		}
		
		if (item == ModStones.windStoneItem && item2 ==  Items.feather && item3 ==  Items.feather && item4 ==  ModAmulets.amuletItem){
			return new ItemStack(ModAmulets.windAmuletItem, 1);
		}
		
		if (item == ModStones.waterStoneItem && item2 ==  Items.water_bucket && item3 ==  Items.water_bucket && item4 ==  ModAmulets.amuletItem){
			return new ItemStack(ModAmulets.waterAmuletItem, 1);
		}
		
		if (item == ModStones.heartStoneItem && item2 ==  Items.porkchop && item3 ==  Items.porkchop && item4 ==  ModAmulets.amuletItem){
			return new ItemStack(ModAmulets.heartAmuletItem, 1);
		}
		
		if (item == ModStones.stormStoneItem && item2 ==  Items.water_bucket && item3 ==  Items.redstone && item4 ==  ModAmulets.amuletItem){
			return new ItemStack(ModAmulets.stormAmuletItem, 1);
		}
		
		if (item == ModStones.chaosStoneItem && item2 ==  Item.getItemFromBlock(Blocks.obsidian) && item3 ==  Items.diamond && item4 ==  ModAmulets.amuletItem){
			return new ItemStack(ModAmulets.chaosAmuletItem, 1);
		}
		
		if (item == ModStones.orderStoneItem && item2 ==  Items.diamond && item3 ==  Items.emerald && item4 ==  ModAmulets.amuletItem){
			return new ItemStack(ModAmulets.orderAmuletItem, 1);
		}
		
		return null;
	}

}
