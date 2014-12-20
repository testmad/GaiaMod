package com.testmad.gaiamod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;

public class EarthArmorItem extends ItemArmor {

	public EarthArmorItem(ArmorMaterial material, int armorType, String name) {

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

		if (stack.getItem() == ModArmor.earthHelmet) {
			return References.MODIDLOCAL + ":models/armor/eartharmor1.png";
		} else if (stack.getItem() == ModArmor.earthChest) {
			return References.MODIDLOCAL + ":models/armor/eartharmor1.png";
		} else if (stack.getItem() == ModArmor.earthLeggings) {
			return References.MODIDLOCAL + ":models/armor/eartharmor2.png";
		} else if (stack.getItem() == ModArmor.earthBoots) {
			return References.MODIDLOCAL + ":models/armor/eartharmor1.png";
		} else {
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

	// @Override
	// public void onArmorTick(World world, EntityPlayer player, ItemStack
	// itemStack) {
	//
	// ItemStack helm = player.getCurrentArmor(3);
	// ItemStack chest = player.getCurrentArmor(2);
	// ItemStack legs = player.getCurrentArmor(1);
	// ItemStack boots = player.getCurrentArmor(0);
	//
	// IAttributeInstance atinst =
	// player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
	// AttributeModifier mod;
	// mod = new AttributeModifier(wtvID,"MySpeedModifier",.4,2);
	//
	// if(helm !=null && chest !=null && legs !=null && boots !=null){
	// if(atinst.getModifier(wtvID) == null)
	// {
	// atinst.applyModifier(mod);
	// }
	// }
	//
	// if(helm !=null || chest !=null || legs !=null || boots !=null){
	// if(atinst.getModifier(wtvID) != null)
	// {
	// atinst.removeModifier(mod);
	// }
	// }
	// }

}
