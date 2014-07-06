package gaiamod.stones;

import gaiamod.util.Registrar;
import net.minecraft.item.Item;

public class ModStones {
	
	public static Item windStoneItem;
	public static Item fireStoneItem;
	public static Item waterStoneItem;
	public static Item earthStoneItem;
	
	public static Item gaiaStoneItem;
	public static Item omegaStoneItem;
	
	public static Item memoryStoneItem;
	public static Item stormStoneItem;
	
	public static Item heartStoneItem;
	public static Item joinedHeartStoneItem;
	 
    public static void init()
    {
        windStoneItem = new WindStoneItem();
        Registrar.registerItem(windStoneItem);
        
        fireStoneItem = new FireStoneItem();
        Registrar.registerItem(fireStoneItem);
        
        waterStoneItem = new WaterStoneItem();
        Registrar.registerItem(waterStoneItem);
        
        earthStoneItem = new EarthStoneItem();
        Registrar.registerItem(earthStoneItem);
        
        
        
        gaiaStoneItem = new GaiaStoneItem();
        Registrar.registerItem(gaiaStoneItem);
        
        omegaStoneItem = new OmegaStoneItem();
        Registrar.registerItem(omegaStoneItem);
        
        
        
        memoryStoneItem = new MemoryStoneItem();
        Registrar.registerItem(memoryStoneItem);
        
        stormStoneItem = new StormStoneItem();
        Registrar.registerItem(stormStoneItem);
        
        
        
        heartStoneItem = new HeartStoneItem();
        Registrar.registerItem(heartStoneItem);
        
        joinedHeartStoneItem = new JoinedHeartStoneItem();
        Registrar.registerItem(joinedHeartStoneItem);
    }
}
