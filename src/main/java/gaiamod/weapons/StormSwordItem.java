package gaiamod.weapons;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.ItemSword;

public class StormSwordItem extends ItemSword{

	public StormSwordItem(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(Strings.StormSwordItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
        this.setNoRepair();
	}
	
	

}
