package gaiamod.stones;

import gaiamod.GaiaMod;
import gaiamod.lib.References;
import gaiamod.lib.Strings;
import net.minecraft.item.Item;

public class OmegaStoneItem extends Item{
	
	public OmegaStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.OmegaStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));

    }

}
