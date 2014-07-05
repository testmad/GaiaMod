package gaiamod.stones;

import gaiamod.GaiaMod;
import gaiamod.lib.References;
import gaiamod.lib.Strings;
import net.minecraft.item.Item;

public class FireStoneItem  extends Item{
	
	public FireStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.FireStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));

    }

}
