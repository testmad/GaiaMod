package gaiamod.stones;

import gaiamod.GaiaMod;
import gaiamod.lib.References;
import gaiamod.lib.Strings;
import net.minecraft.item.Item;

public class WindStoneItem  extends Item{
	
	public WindStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.WindStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));

    }

}