package com.testmad.gaiamod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;

public class WindArmorItem  extends ItemArmor{

	public WindArmorItem(ArmorMaterial material, int armorType,String name) {
			
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setNoRepair();
        this.setFull3D();

		this.setTextureName(References.MODIDLOCAL + ":" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.windHelmet)
		{
			return References.MODIDLOCAL + ":models/armor/windarmor1.png";
		}
		else if(stack.getItem() == ModArmor.windChest)
		{
			return References.MODIDLOCAL + ":models/armor/windarmor1.png";
		}
		else if(stack.getItem() == ModArmor.windLeggings)
		{
			return References.MODIDLOCAL + ":models/armor/windarmor2.png";
		}
		else if(stack.getItem() == ModArmor.windBoots)
		{
			return References.MODIDLOCAL + ":models/armor/windarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

}
