package com.testmad.gaiamod.essence;

import net.minecraft.item.Item;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;
import com.testmad.gaiamod.util.Strings;

public class HeartEssenceItem extends Item {

	public HeartEssenceItem() {
		super();
		this.setUnlocalizedName(Strings.HeartEssenceItemName);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setTextureName(References.MODIDLOCAL + ":"
				+ getUnlocalizedName().substring(5));

		this.setNoRepair();
		this.setMaxStackSize(64);
		this.setFull3D();
	}

}
