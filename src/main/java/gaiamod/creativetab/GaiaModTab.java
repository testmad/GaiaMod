package gaiamod.creativetab;

import gaiamod.stones.ModStones;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GaiaModTab extends CreativeTabs{

	public GaiaModTab(int id, String modid)
    {
        super(id, modid);
    }
 
    @Override
    public Item getTabIconItem()
    {
        return ModStones.orderStoneItem;

    }
}
