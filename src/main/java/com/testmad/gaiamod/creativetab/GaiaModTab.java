package com.testmad.gaiamod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.testmad.gaiamod.stones.ModStones;

public class GaiaModTab extends CreativeTabs{

	public GaiaModTab(int id, String modid)
    {
        super(id, modid);
    }
 
    @Override
    public Item getTabIconItem()
    {
    	return ModStones.orderStoneItem;

    }
}
