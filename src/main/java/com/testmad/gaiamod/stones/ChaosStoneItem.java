package com.testmad.gaiamod.stones;

import net.minecraft.item.Item;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;
import com.testmad.gaiamod.util.Strings;

public class ChaosStoneItem extends Item{
	
	public ChaosStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.ChaosStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODIDLOCAL + ":" + getUnlocalizedName().substring(5));
        
        this.setNoRepair();
        this.setMaxStackSize(64);
        this.setFull3D();

    }

}
