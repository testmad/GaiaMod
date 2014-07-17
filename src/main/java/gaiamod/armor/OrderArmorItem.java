package gaiamod.armor;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OrderArmorItem extends ItemArmor{
	
	public OrderArmorItem(ArmorMaterial material, int armorType,String name) {
		
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.canRepair = true;	
		
		this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
		
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.orderHelmet)
		{
			return References.MODID + ":models/armor/gaiaarmor1.png";
		}
		else if(stack.getItem() == ModArmor.orderChest)
		{
			return References.MODID + ":models/armor/gaiaarmor1.png";
		}
		else if(stack.getItem() == ModArmor.orderLeggings)
		{
			return References.MODID + ":models/armor/gaiaarmor2.png";
		}
		else if(stack.getItem() == ModArmor.orderBoots)
		{
			return References.MODID + ":models/armor/gaiaarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item GaiaArmorItem");
			return null;
		}
	}
}
