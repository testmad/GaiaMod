package gaiamod.stones;

import gaiamod.GaiaMod;
import gaiamod.lib.References;
import gaiamod.lib.Strings;
import net.minecraft.item.Item;

public class GaiaStoneItem extends Item{
	
	public GaiaStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.GaiaStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));

    }

}
