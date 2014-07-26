package gaiamod.armor;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ChaosArmorItem extends ItemArmor{
	
	public ChaosArmorItem(ArmorMaterial material, int armorType,String name) {
		
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.canRepair = true;	

		this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.chaosHelmet)
		{
			return References.MODID + ":models/armor/chaosarmor1.png";
		}
		else if(stack.getItem() == ModArmor.chaosChest)
		{
			return References.MODID + ":models/armor/chaosarmor1.png";
		}
		else if(stack.getItem() == ModArmor.chaosLeggings)
		{
			return References.MODID + ":models/armor/chaosarmor2.png";
		}
		else if(stack.getItem() == ModArmor.chaosBoots)
		{
			return References.MODID + ":models/armor/chaosarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}
}
