package gaiamod.armor;

import gaiamod.GaiaMod;
import gaiamod.util.References;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
	
//	@Override
//	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
//		
//		ItemStack helm = player.getCurrentArmor(3);
//		ItemStack chest = player.getCurrentArmor(2);
//		ItemStack legs = player.getCurrentArmor(1);
//		ItemStack boots = player.getCurrentArmor(0);
//		
//		IAttributeInstance atinst = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
//		AttributeModifier mod;
//		mod = new AttributeModifier(wtvID,"MySpeedModifier",.4,2);
//		
//		if(helm !=null && chest !=null && legs !=null && boots !=null){
//			if(atinst.getModifier(wtvID) == null)
//			{
//			atinst.applyModifier(mod);
//			}
//		}
//		
//		if(helm !=null || chest !=null || legs !=null || boots !=null){
//			if(atinst.getModifier(wtvID) != null)
//			{
//			atinst.removeModifier(mod);
//			}
//		}
//	}

}
