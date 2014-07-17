package gaiamod.stones;

import gaiamod.util.Registrar;
import net.minecraft.item.Item;

public class ModStones {
	
	public static Item stoneItem;
	public static Item windStoneItem;
	public static Item fireStoneItem;
	public static Item waterStoneItem;
	public static Item earthStoneItem;
	public static Item heartStoneItem;
	public static Item stormStoneItem;
	public static Item chaosStoneItem;
	public static Item orderStoneItem;
	 
    public static void init()
    {
    	stoneItem = new StoneItem();
        Registrar.registerItem(stoneItem);
        
        windStoneItem = new WindStoneItem();
        Registrar.registerItem(windStoneItem);
        
        fireStoneItem = new FireStoneItem();
        Registrar.registerItem(fireStoneItem);
        
        waterStoneItem = new WaterStoneItem();
        Registrar.registerItem(waterStoneItem);
        
        earthStoneItem = new EarthStoneItem();
        Registrar.registerItem(earthStoneItem);
        
        heartStoneItem = new HeartStoneItem();
        Registrar.registerItem(heartStoneItem);

        stormStoneItem = new StormStoneItem();
        Registrar.registerItem(stormStoneItem);
        
        chaosStoneItem = new ChaosStoneItem();
        Registrar.registerItem(chaosStoneItem);
        
        orderStoneItem = new OrderStoneItem();
        Registrar.registerItem(orderStoneItem);
        
    }
}
