package gaiamod.essence;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class EmptyOrderEssenceItem extends Item {
	
	public EmptyOrderEssenceItem()
	{
		super();
        this.setUnlocalizedName(Strings.EmptyOrderEssenceItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

}
