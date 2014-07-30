package gaiamod.armor;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class HeartArmorItem  extends ItemArmor{

	public HeartArmorItem(ArmorMaterial material, int armorType,String name) {
			
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setNoRepair();
        this.setFull3D();

		this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.heartHelmet)
		{
			return References.MODID + ":models/armor/heartarmor1.png";
		}
		else if(stack.getItem() == ModArmor.heartChest)
		{
			return References.MODID + ":models/armor/heartarmor1.png";
		}
		else if(stack.getItem() == ModArmor.heartLeggings)
		{
			return References.MODID + ":models/armor/heartarmor2.png";
		}
		else if(stack.getItem() == ModArmor.heartBoots)
		{
			return References.MODID + ":models/armor/heartarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

}
