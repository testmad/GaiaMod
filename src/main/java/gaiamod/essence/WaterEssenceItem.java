package gaiamod.essence;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class WaterEssenceItem extends Item {
	
	public WaterEssenceItem()
	{
		super();
        this.setUnlocalizedName(Strings.WaterEssenceItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

}
