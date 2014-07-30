package gaiamod.armor;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class FireArmorItem  extends ItemArmor{

	public FireArmorItem(ArmorMaterial material, int armorType,String name) {
			
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setNoRepair();
        this.setFull3D();

		this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.fireHelmet)
		{
			return References.MODID + ":models/armor/firearmor1.png";
		}
		else if(stack.getItem() == ModArmor.fireChest)
		{
			return References.MODID + ":models/armor/firearmor1.png";
		}
		else if(stack.getItem() == ModArmor.fireLeggings)
		{
			return References.MODID + ":models/armor/firearmor2.png";
		}
		else if(stack.getItem() == ModArmor.fireBoots)
		{
			return References.MODID + ":models/armor/firearmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

}
