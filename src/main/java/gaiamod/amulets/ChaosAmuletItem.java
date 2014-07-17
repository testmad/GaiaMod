package gaiamod.amulets;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class ChaosAmuletItem extends Item {
	
	public ChaosAmuletItem()
	{
		super();
        this.setUnlocalizedName(Strings.ChaosAmuletItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

}
