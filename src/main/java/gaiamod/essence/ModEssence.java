package gaiamod.essence;

import gaiamod.stones.WaterStoneItem;
import gaiamod.util.Registrar;
import net.minecraft.item.Item;

public class ModEssence {
	
	public static Item essenceItem;
	public static Item earthEssenceItem;
	public static Item fireEssenceItem;
	public static Item windEssenceItem;
	public static Item waterEssenceItem;
	public static Item heartEssenceItem;
	public static Item stormEssenceItem;
	public static Item chaosEssenceItem;
	public static Item orderEssenceItem;

	public static void init() {

		essenceItem = new EssenceItem();
        Registrar.registerItem(essenceItem);
        
        earthEssenceItem = new EarthEssenceItem();
        Registrar.registerItem(earthEssenceItem);
        
        fireEssenceItem = new FireEssenceItem();
        Registrar.registerItem(fireEssenceItem);
        
        windEssenceItem = new WindEssenceItem();
        Registrar.registerItem(windEssenceItem);
        
        waterEssenceItem = new WaterEssenceItem();
        Registrar.registerItem(waterEssenceItem);
        
        heartEssenceItem = new HeartEssenceItem();
        Registrar.registerItem(heartEssenceItem);
        
        stormEssenceItem = new StormEssenceItem();
        Registrar.registerItem(stormEssenceItem);
        
        chaosEssenceItem = new ChaosEssenceItem();
        Registrar.registerItem(chaosEssenceItem);
        
        orderEssenceItem = new OrderEssenceItem();
        Registrar.registerItem(orderEssenceItem);
		
	}

}
