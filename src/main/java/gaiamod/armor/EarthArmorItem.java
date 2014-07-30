package gaiamod.armor;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class EarthArmorItem  extends ItemArmor{

	public EarthArmorItem(ArmorMaterial material, int armorType,String name) {
			
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.setNoRepair();
        this.setFull3D();

		this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.earthHelmet)
		{
			return References.MODID + ":models/armor/eartharmor1.png";
		}
		else if(stack.getItem() == ModArmor.earthChest)
		{
			return References.MODID + ":models/armor/eartharmor1.png";
		}
		else if(stack.getItem() == ModArmor.earthLeggings)
		{
			return References.MODID + ":models/armor/eartharmor2.png";
		}
		else if(stack.getItem() == ModArmor.earthBoots)
		{
			return References.MODID + ":models/armor/eartharmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}

}
