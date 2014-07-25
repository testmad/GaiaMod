package gaiamod.weapons;

import gaiamod.util.Registrar;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ModWeapons {
	
	public static Item stormSword;
	public static Item chaosSword;
	public static Item orderSword;
	
	static Item.ToolMaterial gaiaToolMaterial = EnumHelper.addToolMaterial("gaiaToolMaterial", 2, 192, 5.0F, 1.5F, 12);
	
	public static void init()
    {
		
		stormSword = new StormSwordItem(gaiaToolMaterial);
        Registrar.registerItem(stormSword);
        
        chaosSword = new ChaosSwordItem(gaiaToolMaterial);
        Registrar.registerItem(chaosSword);
        
        orderSword = new OrderSwordItem(gaiaToolMaterial);
        Registrar.registerItem(orderSword);
		
    }

}
