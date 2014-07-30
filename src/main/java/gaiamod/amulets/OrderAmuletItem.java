package gaiamod.amulets;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class OrderAmuletItem extends Item {
	
	public OrderAmuletItem()
	{
		super();
        this.setUnlocalizedName(Strings.OrderAmuletItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
        
        this.setNoRepair();
        this.setMaxStackSize(64);
        this.setFull3D();
	}

}
