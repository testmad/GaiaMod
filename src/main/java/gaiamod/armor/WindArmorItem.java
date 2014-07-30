package gaiamod.armor;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class WindArmorItem  extends ItemArmor{

	public WindArmorItem(ArmorMaterial material, int armorType,String name) {
			
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setNoRepair();
        this.setFull3D();

		this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.windHelmet)
		{
			return References.MODID + ":models/armor/windarmor1.png";
		}
		else if(stack.getItem() == ModArmor.windChest)
		{
			return References.MODID + ":models/armor/windarmor1.png";
		}
		else if(stack.getItem() == ModArmor.windLeggings)
		{
			return References.MODID + ":models/armor/windarmor2.png";
		}
		else if(stack.getItem() == ModArmor.windBoots)
		{
			return References.MODID + ":models/armor/windarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

}
