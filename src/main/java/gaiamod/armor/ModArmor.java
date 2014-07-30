package gaiamod.armor;

import gaiamod.util.Registrar;
import gaiamod.util.Strings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmor {
	
	public static Item earthHelmet;
	public static Item earthChest;
	public static Item earthLeggings;
	public static Item earthBoots;
	
	public static Item fireHelmet;
	public static Item fireChest;
	public static Item fireLeggings;
	public static Item fireBoots;
	
	public static Item windHelmet;
	public static Item windChest;
	public static Item windLeggings;
	public static Item windBoots;
	
	public static Item waterHelmet;
	public static Item waterChest;
	public static Item waterLeggings;
	public static Item waterBoots;
	
	public static Item heartHelmet;
	public static Item heartChest;
	public static Item heartLeggings;
	public static Item heartBoots;
	
	public static Item stormHelmet;
	public static Item stormChest;
	public static Item stormLeggings;
	public static Item stormBoots;
	
	public static Item chaosHelmet;
	public static Item chaosChest;
	public static Item chaosLeggings;
	public static Item chaosBoots;
	
	public static Item orderHelmet;
	public static Item orderChest;
	public static Item orderLeggings;
	public static Item orderBoots;
	
	static ArmorMaterial earthArmorMaterial = EnumHelper.addArmorMaterial("earthArmorMaterial", 33, new int[]{2, 5, 4, 2}, 0);
	static ArmorMaterial fireArmorMaterial = EnumHelper.addArmorMaterial("fireArmorMaterial", 33, new int[]{2, 5, 4, 2}, 0);
	static ArmorMaterial windArmorMaterial = EnumHelper.addArmorMaterial("windArmorMaterial", 33, new int[]{2, 5, 4, 2}, 0);
	static ArmorMaterial waterArmorMaterial = EnumHelper.addArmorMaterial("waterArmorMaterial", 33, new int[]{2, 5, 4, 2}, 0);
	static ArmorMaterial heartArmorMaterial = EnumHelper.addArmorMaterial("heartArmorMaterial", 35, new int[]{2, 6, 4, 2}, 0);
	static ArmorMaterial stormArmorMaterial = EnumHelper.addArmorMaterial("stormArmorMaterial", 37, new int[]{2, 7, 5, 2}, 0);
	static ArmorMaterial chaosArmorMaterial = EnumHelper.addArmorMaterial("chaosArmorMaterial", 40, new int[]{3, 7, 5, 3}, 0);
	static ArmorMaterial orderArmorMaterial = EnumHelper.addArmorMaterial("orderArmorMaterial", 42, new int[]{3, 8, 6, 3}, 0);

	
	
	public static void init()
    {
        
        earthHelmet = new EarthArmorItem(earthArmorMaterial, 0, Strings.EarthHelmetName);
        Registrar.registerItem(earthHelmet);
        
        earthChest = new EarthArmorItem(earthArmorMaterial, 1, Strings.EarthChestName);
        Registrar.registerItem(earthChest);
        
        earthLeggings = new EarthArmorItem(earthArmorMaterial, 2, Strings.EarthLeggingsName);
        Registrar.registerItem(earthLeggings);
        
        earthBoots = new EarthArmorItem(earthArmorMaterial, 3, Strings.EarthBootsName);
        Registrar.registerItem(earthBoots);
        
        
        fireHelmet = new FireArmorItem(fireArmorMaterial, 0, Strings.FireHelmetName);
        Registrar.registerItem(fireHelmet);
        
        fireChest = new FireArmorItem(fireArmorMaterial, 1, Strings.FireChestName);
        Registrar.registerItem(fireChest);
        
        fireLeggings = new FireArmorItem(fireArmorMaterial, 2, Strings.FireLeggingsName);
        Registrar.registerItem(fireLeggings);
        
        fireBoots = new FireArmorItem(fireArmorMaterial, 3, Strings.FireBootsName);
        Registrar.registerItem(fireBoots);
        
        
        windHelmet = new WindArmorItem(windArmorMaterial, 0, Strings.WindHelmetName);
        Registrar.registerItem(windHelmet);
        
        windChest = new WindArmorItem(windArmorMaterial, 1, Strings.WindChestName);
        Registrar.registerItem(windChest);
        
        windLeggings = new WindArmorItem(windArmorMaterial, 2, Strings.WindLeggingsName);
        Registrar.registerItem(windLeggings);
        
        windBoots = new WindArmorItem(windArmorMaterial, 3, Strings.WindBootsName);
        Registrar.registerItem(windBoots);
        
        
        waterHelmet = new WaterArmorItem(waterArmorMaterial, 0, Strings.WaterHelmetName);
        Registrar.registerItem(waterHelmet);
        
        waterChest = new WaterArmorItem(waterArmorMaterial, 1, Strings.WaterChestName);
        Registrar.registerItem(waterChest);
        
        waterLeggings = new WaterArmorItem(waterArmorMaterial, 2, Strings.WaterLeggingsName);
        Registrar.registerItem(waterLeggings);
        
        waterBoots = new WaterArmorItem(waterArmorMaterial, 3, Strings.WaterBootsName);
        Registrar.registerItem(waterBoots);
        
        
        heartHelmet = new HeartArmorItem(heartArmorMaterial, 0, Strings.HeartHelmetName);
        Registrar.registerItem(heartHelmet);
        
        heartChest = new HeartArmorItem(heartArmorMaterial, 1, Strings.HeartChestName);
        Registrar.registerItem(heartChest);
        
        heartLeggings = new HeartArmorItem(heartArmorMaterial, 2, Strings.HeartLeggingsName);
        Registrar.registerItem(heartLeggings);
        
        heartBoots = new HeartArmorItem(heartArmorMaterial, 3, Strings.HeartBootsName);
        Registrar.registerItem(heartBoots);
        
        
        stormHelmet = new StormArmorItem(stormArmorMaterial, 0, Strings.StormHelmetName);
        Registrar.registerItem(stormHelmet);
        
        stormChest = new StormArmorItem(stormArmorMaterial, 1, Strings.StormChestName);
        Registrar.registerItem(stormChest);
        
        stormLeggings = new StormArmorItem(stormArmorMaterial, 2, Strings.StormLeggingsName);
        Registrar.registerItem(stormLeggings);
        
        stormBoots = new StormArmorItem(stormArmorMaterial, 3, Strings.StormBootsName);
        Registrar.registerItem(stormBoots);
        
        
        chaosHelmet = new ChaosArmorItem(chaosArmorMaterial, 0, Strings.ChaosHelmetName);
        Registrar.registerItem(chaosHelmet);
        
        chaosChest = new ChaosArmorItem(chaosArmorMaterial, 1, Strings.ChaosChestName);
        Registrar.registerItem(chaosChest);
        
        chaosLeggings = new ChaosArmorItem(chaosArmorMaterial, 2, Strings.ChaosLeggingsName);
        Registrar.registerItem(chaosLeggings);
        
        chaosBoots = new ChaosArmorItem(chaosArmorMaterial, 3, Strings.ChaosBootsName);
        Registrar.registerItem(chaosBoots);
        
        
        orderHelmet = new OrderArmorItem(orderArmorMaterial, 0, Strings.OrderHelmetName);
        Registrar.registerItem(orderHelmet);
        
        orderChest = new OrderArmorItem(orderArmorMaterial, 1, Strings.OrderChestName);
        Registrar.registerItem(orderChest);
        
        orderLeggings = new OrderArmorItem(orderArmorMaterial, 2, Strings.OrderLeggingsName);
        Registrar.registerItem(orderLeggings);
        
        orderBoots = new OrderArmorItem(orderArmorMaterial, 3, Strings.OrderBootsName);
        Registrar.registerItem(orderBoots);
        
    }
	
}
