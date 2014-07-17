package gaiamod.amulets;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class WindAmuletItem extends Item {
	
	public WindAmuletItem()
	{
		super();
        this.setUnlocalizedName(Strings.WindAmuletItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

}
