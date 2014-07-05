package gaiamod.stones;

import gaiamod.GaiaMod;
import gaiamod.lib.References;
import gaiamod.lib.Strings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class JoinedHeartStoneItem  extends Item{
	
	public JoinedHeartStoneItem()
    {
		super();
        this.setUnlocalizedName(Strings.JoinedHeartStoneItemName);
        this.setCreativeTab(GaiaMod.getcreativeTab());
        this.setTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));

    }

	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
}
