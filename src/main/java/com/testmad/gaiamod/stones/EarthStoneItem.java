package com.testmad.gaiamod.stones;

import net.minecraft.item.Item;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;
import com.testmad.gaiamod.util.Strings;

public class EarthStoneItem  extends Item{
	
	public EarthStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.EarthStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        
        this.setNoRepair();
        this.setMaxStackSize(64);
        this.setFull3D();
        
        this.setTextureName(References.MODIDLOCAL + ":" + getUnlocalizedName().substring(5));

    }

}
