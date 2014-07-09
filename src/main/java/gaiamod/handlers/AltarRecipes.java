package gaiamod.handlers;

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
		if (item == Items.bone && item2 ==  Items.bone && item3 ==  Items.bone && item4 ==  Items.bone){
			return new ItemStack(ModStones.earthStoneItem, 1);
		}
		
		return null;
	}

}
