package com.testmad.gaiamod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;

public class ChaosArmorItem extends ItemArmor{
	
	public ChaosArmorItem(ArmorMaterial material, int armorType,String name) {
		
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setNoRepair();
        this.setFull3D();

		this.setTextureName(References.MODIDLOCAL + ":" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.chaosHelmet)
		{
			return References.MODIDLOCAL + ":models/armor/chaosarmor1.png";
		}
		else if(stack.getItem() == ModArmor.chaosChest)
		{
			return References.MODIDLOCAL + ":models/armor/chaosarmor1.png";
		}
		else if(stack.getItem() == ModArmor.chaosLeggings)
		{
			return References.MODIDLOCAL + ":models/armor/chaosarmor2.png";
		}
		else if(stack.getItem() == ModArmor.chaosBoots)
		{
			return References.MODIDLOCAL + ":models/armor/chaosarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}
}
