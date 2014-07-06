package gaiamod.stones;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class EarthStoneItem  extends Item{
	
	public EarthStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.EarthStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        
        this.maxStackSize = 64;
        this.setMaxDamage(64);
        this.setNoRepair();
        
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));

    }

}
