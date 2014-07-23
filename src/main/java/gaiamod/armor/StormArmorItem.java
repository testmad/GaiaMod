package gaiamod.armor;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class StormArmorItem  extends ItemArmor{

	public StormArmorItem(ArmorMaterial material, int armorType,String name) {
			
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.canRepair = true;	

		this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.stormHelmet)
		{
			return References.MODID + ":models/armor/omegaarmor1.png";
		}
		else if(stack.getItem() == ModArmor.stormChest)
		{
			return References.MODID + ":models/armor/omegaarmor1.png";
		}
		else if(stack.getItem() == ModArmor.stormLeggings)
		{
			return References.MODID + ":models/armor/omegaarmor2.png";
		}
		else if(stack.getItem() == ModArmor.stormBoots)
		{
			return References.MODID + ":models/armor/omegaarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

}
