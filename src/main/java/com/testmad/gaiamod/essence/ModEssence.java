
package com.testmad.gaiamod.essence;

import net.minecraft.item.Item;

import com.testmad.gaiamod.util.Registrar;

public class ModEssence {
	
	public static Item essenceItem;
	
	public static Item emptyEarthEssenceItem;
	public static Item emptyFireEssenceItem;
	public static Item emptyWindEssenceItem;
	public static Item emptyWaterEssenceItem;
	public static Item emptyHeartEssenceItem;
	public static Item emptyStormEssenceItem;
	public static Item emptyChaosEssenceItem;
	public static Item emptyOrderEssenceItem;
	
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




        emptyEarthEssenceItem = new EmptyEarthEssenceItem();
        Registrar.registerItem(emptyEarthEssenceItem);
        
        emptyFireEssenceItem = new EmptyFireEssenceItem();
        Registrar.registerItem(emptyFireEssenceItem);
        
        emptyWindEssenceItem = new EmptyWindEssenceItem();
        Registrar.registerItem(emptyWindEssenceItem);
        
        emptyWaterEssenceItem = new EmptyWaterEssenceItem();
        Registrar.registerItem(emptyWaterEssenceItem);
        
        emptyHeartEssenceItem = new EmptyHeartEssenceItem();
        Registrar.registerItem(emptyHeartEssenceItem);
        
        emptyStormEssenceItem = new EmptyStormEssenceItem();
        Registrar.registerItem(emptyStormEssenceItem);
        
        emptyChaosEssenceItem = new EmptyChaosEssenceItem();
        Registrar.registerItem(emptyChaosEssenceItem);
        
        emptyOrderEssenceItem = new EmptyOrderEssenceItem();
        Registrar.registerItem(emptyOrderEssenceItem);
        
        
        
        
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
