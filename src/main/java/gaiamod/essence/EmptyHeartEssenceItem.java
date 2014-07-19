package gaiamod.essence;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class EmptyHeartEssenceItem extends Item {
	
	public EmptyHeartEssenceItem()
	{
		super();
        this.setUnlocalizedName(Strings.EmptyHeartEssenceItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

}
