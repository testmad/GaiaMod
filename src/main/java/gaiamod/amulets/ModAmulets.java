package gaiamod.amulets;

import net.minecraft.item.Item;
import gaiamod.stones.WaterStoneItem;
import gaiamod.util.Registrar;

public class ModAmulets {
	
	public static Item amuletItem;
	public static Item earthAmuletItem;
	public static Item fireAmuletItem;
	public static Item windAmuletItem;
	public static Item waterAmuletItem;
	public static Item heartAmuletItem;
	public static Item stormAmuletItem;
	public static Item chaosAmuletItem;
	public static Item orderAmuletItem;
	
	public static void init()
    {
		amuletItem = new AmuletItem();
        Registrar.registerItem(amuletItem);
        
        earthAmuletItem = new EarthAmuletItem();
        Registrar.registerItem(earthAmuletItem);
        
        fireAmuletItem = new FireAmuletItem();
        Registrar.registerItem(fireAmuletItem);
        
        windAmuletItem = new WindAmuletItem();
        Registrar.registerItem(windAmuletItem);
        
        waterAmuletItem = new WaterAmuletItem();
        Registrar.registerItem(waterAmuletItem);
        
        heartAmuletItem = new HeartAmuletItem();
        Registrar.registerItem(heartAmuletItem);
        
        stormAmuletItem = new StormAmuletItem();
        Registrar.registerItem(stormAmuletItem);
        
        chaosAmuletItem = new ChaosAmuletItem();
        Registrar.registerItem(chaosAmuletItem);
        
        orderAmuletItem = new OrderAmuletItem();
        Registrar.registerItem(orderAmuletItem);
    }

}
