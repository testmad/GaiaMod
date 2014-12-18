package com.testmad.gaiamod.weapons;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import com.testmad.gaiamod.util.Registrar;

public class ModWeapons {
	
	public static Item stormSword;
	public static Item chaosSword;
	public static Item orderSword;
	
	static Item.ToolMaterial stormToolMaterial = EnumHelper.addToolMaterial("stormToolMaterial", 3, 2061, 14.0F, 10.0F, 0);
	
	static Item.ToolMaterial chaosToolMaterial = EnumHelper.addToolMaterial("chaosToolMaterial", 3, 2561, 16.0F, 12.0F, 0);
	
	static Item.ToolMaterial orderToolMaterial = EnumHelper.addToolMaterial("orderToolMaterial", 3, 3061, 18.0F, 14.0F, 0);
	
	public static void init()
    {
		
		stormSword = new StormSwordItem(stormToolMaterial);
        Registrar.registerItem(stormSword);
        
        chaosSword = new ChaosSwordItem(chaosToolMaterial);
        Registrar.registerItem(chaosSword);
        
        orderSword = new OrderSwordItem(orderToolMaterial);
        Registrar.registerItem(orderSword);
		
    }

}
