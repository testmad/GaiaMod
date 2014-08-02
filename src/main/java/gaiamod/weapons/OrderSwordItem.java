package gaiamod.weapons;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.ItemSword;

public class OrderSwordItem extends ItemSword{

	public OrderSwordItem(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(Strings.OrderSwordItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
        this.setNoRepair();
	}
	
	

}
