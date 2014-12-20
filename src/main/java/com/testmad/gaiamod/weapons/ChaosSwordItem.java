package com.testmad.gaiamod.weapons;

import net.minecraft.item.ItemSword;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;
import com.testmad.gaiamod.util.Strings;

public class ChaosSwordItem extends ItemSword {

	public ChaosSwordItem(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(Strings.ChaosSwordItemName);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setTextureName(References.MODIDLOCAL + ":"
				+ getUnlocalizedName().substring(5));
		this.setNoRepair();
	}

}
