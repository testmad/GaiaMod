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
        
        this.setNoRepair();
        this.setMaxStackSize(64);
        this.setFull3D();
        
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));

    }

}
