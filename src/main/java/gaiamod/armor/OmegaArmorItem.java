package gaiamod.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gaiamod.GaiaMod;
import gaiamod.lib.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

public class OmegaArmorItem extends ItemArmor{
	
	public OmegaArmorItem(ArmorMaterial material, int armorType,String name) {
		
		super(material, 0 , armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GaiaMod.getcreativeTab());
		this.canRepair = true;	

		this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
		
	}
	
	
	
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModArmor.omegaHelmet)
		{
			return References.MODID + ":models/armor/omegaarmor1.png";
		}
		else if(stack.getItem() == ModArmor.omegaChest)
		{
			return References.MODID + ":models/armor/omegaarmor1.png";
		}
		else if(stack.getItem() == ModArmor.omegaLeggings)
		{
			return References.MODID + ":models/armor/omegaarmor2.png";
		}
		else if(stack.getItem() == ModArmor.omegaBoots)
		{
			return References.MODID + ":models/armor/omegaarmor1.png";
		}
		else
		{
			System.out.println("Invalid Item OmegaArmorItem");
			return null;
		}
	}
	
	/*@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack, int pass)
    {
		par1ItemStack.setTagInfo("ench", new NBTTagList());
        return true;
    }*/
	

}
