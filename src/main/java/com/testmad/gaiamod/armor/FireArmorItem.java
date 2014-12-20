package com.testmad.gaiamod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;

public class FireArmorItem extends ItemArmor {

	public FireArmorItem(ArmorMaterial material, int armorType, String name) {

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

		if (stack.getItem() == ModArmor.fireHelmet) {
			return References.MODIDLOCAL + ":models/armor/firearmor1.png";
		} else if (stack.getItem() == ModArmor.fireChest) {
			return References.MODIDLOCAL + ":models/armor/firearmor1.png";
		} else if (stack.getItem() == ModArmor.fireLeggings) {
			return References.MODIDLOCAL + ":models/armor/firearmor2.png";
		} else if (stack.getItem() == ModArmor.fireBoots) {
			return References.MODIDLOCAL + ":models/armor/firearmor1.png";
		} else {
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

}
