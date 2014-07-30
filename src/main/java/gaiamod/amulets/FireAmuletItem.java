package gaiamod.amulets;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class FireAmuletItem extends Item {
	
	public FireAmuletItem()
	{
		super();
        this.setUnlocalizedName(Strings.FireAmuletItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
        
        this.setNoRepair();
        this.setMaxStackSize(64);
        this.setFull3D();
	}

}
