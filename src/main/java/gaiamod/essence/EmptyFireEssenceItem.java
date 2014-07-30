package gaiamod.essence;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.Item;

public class EmptyFireEssenceItem extends Item {
	
	public EmptyFireEssenceItem()
	{
		super();
        this.setUnlocalizedName(Strings.EmptyFireEssenceItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
        
        this.setNoRepair();
        this.setMaxStackSize(64);
        this.setFull3D();
	}

}
