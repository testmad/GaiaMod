package gaiamod.stones;

import gaiamod.GaiaMod;
import gaiamod.lib.References;
import gaiamod.lib.Strings;
import net.minecraft.item.Item;

public class WaterStoneItem  extends Item{
	
	public WaterStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.WaterStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.maxStackSize = 1;
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));


    }

}
