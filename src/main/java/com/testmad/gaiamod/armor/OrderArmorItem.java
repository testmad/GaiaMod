package com.testmad.gaiamod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;

public class OrderArmorItem extends ItemArmor{
	
	public OrderArmorItem(ArmorMaterial material, int armorType,String name) {
		
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setNoRepair();
        this.setFull3D();
		
		this.setTextureName(References.MODIDLOCAL + ":" + getUnlocalizedName().substring(5));
		
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.orderHelmet)
		{
			return References.MODIDLOCAL + ":models/armor/orderarmor1.png";
		}
		else if(stack.getItem() == ModArmor.orderChest)
		{
			return References.MODIDLOCAL + ":models/armor/orderarmor1.png";
		}
		else if(stack.getItem() == ModArmor.orderLeggings)
		{
			return References.MODIDLOCAL + ":models/armor/orderarmor2.png";
		}
		else if(stack.getItem() == ModArmor.orderBoots)
		{
			return References.MODIDLOCAL + ":models/armor/orderarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item GaiaArmorItem");
			return null;
		}
	}
}
