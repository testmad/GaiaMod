package com.testmad.gaiamod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;

public class StormArmorItem extends ItemArmor {

	public StormArmorItem(ArmorMaterial material, int armorType, String name) {

		super(material, 0, armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setNoRepair();
		this.setFull3D();

		this.setTextureName(References.MODIDLOCAL + ":"
				+ getUnlocalizedName().substring(5));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {

		if (stack.getItem() == ModArmor.stormHelmet) {
			return References.MODIDLOCAL + ":models/armor/stormarmor1.png";
		} else if (stack.getItem() == ModArmor.stormChest) {
			return References.MODIDLOCAL + ":models/armor/stormarmor1.png";
		} else if (stack.getItem() == ModArmor.stormLeggings) {
			return References.MODIDLOCAL + ":models/armor/stormarmor2.png";
		} else if (stack.getItem() == ModArmor.stormBoots) {
			return References.MODIDLOCAL + ":models/armor/stormarmor1.png";
		} else {
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

}
