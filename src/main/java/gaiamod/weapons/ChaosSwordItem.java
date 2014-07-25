package gaiamod.weapons;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.item.ItemSword;

public class ChaosSwordItem extends ItemSword{

	public ChaosSwordItem(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(Strings.ChaosSwordItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	

}
