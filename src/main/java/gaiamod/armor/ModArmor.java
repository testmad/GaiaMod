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
	
	static ArmorMaterial gaiaArmorMaterial = EnumHelper.addArmorMaterial("gaiaArmorMaterial", 20, new int[]{2,6,5,2}, 20);
	
	public static void init()
    {
        
        earthHelmet = new ChaosArmorItem(gaiaArmorMaterial, 0, Strings.EarthHelmetName);
        Registrar.registerItem(earthHelmet);
        
        earthChest = new ChaosArmorItem(gaiaArmorMaterial, 1, Strings.EarthChestName);
        Registrar.registerItem(earthChest);
        
        earthLeggings = new ChaosArmorItem(gaiaArmorMaterial, 2, Strings.EarthLeggingsName);
        Registrar.registerItem(earthLeggings);
        
        earthBoots = new ChaosArmorItem(gaiaArmorMaterial, 3, Strings.EarthBootsName);
        Registrar.registerItem(earthBoots);
        
        
        fireHelmet = new ChaosArmorItem(gaiaArmorMaterial, 0, Strings.FireHelmetName);
        Registrar.registerItem(fireHelmet);
        
        fireChest = new ChaosArmorItem(gaiaArmorMaterial, 1, Strings.FireChestName);
        Registrar.registerItem(fireChest);
        
        fireLeggings = new ChaosArmorItem(gaiaArmorMaterial, 2, Strings.FireLeggingsName);
        Registrar.registerItem(fireLeggings);
        
        fireBoots = new ChaosArmorItem(gaiaArmorMaterial, 3, Strings.FireBootsName);
        Registrar.registerItem(fireBoots);
        
        
        windHelmet = new ChaosArmorItem(gaiaArmorMaterial, 0, Strings.WindHelmetName);
        Registrar.registerItem(windHelmet);
        
        windChest = new ChaosArmorItem(gaiaArmorMaterial, 1, Strings.WindChestName);
        Registrar.registerItem(windChest);
        
        windLeggings = new ChaosArmorItem(gaiaArmorMaterial, 2, Strings.WindLeggingsName);
        Registrar.registerItem(windLeggings);
        
        windBoots = new ChaosArmorItem(gaiaArmorMaterial, 3, Strings.WindBootsName);
        Registrar.registerItem(windBoots);
        
        
        waterHelmet = new ChaosArmorItem(gaiaArmorMaterial, 0, Strings.WaterHelmetName);
        Registrar.registerItem(waterHelmet);
        
        waterChest = new ChaosArmorItem(gaiaArmorMaterial, 1, Strings.WaterChestName);
        Registrar.registerItem(waterChest);
        
        waterLeggings = new ChaosArmorItem(gaiaArmorMaterial, 2, Strings.WaterLeggingsName);
        Registrar.registerItem(waterLeggings);
        
        waterBoots = new ChaosArmorItem(gaiaArmorMaterial, 3, Strings.WaterBootsName);
        Registrar.registerItem(waterBoots);
        
        
        heartHelmet = new ChaosArmorItem(gaiaArmorMaterial, 0, Strings.HeartHelmetName);
        Registrar.registerItem(heartHelmet);
        
        heartChest = new ChaosArmorItem(gaiaArmorMaterial, 1, Strings.HeartChestName);
        Registrar.registerItem(heartChest);
        
        heartLeggings = new ChaosArmorItem(gaiaArmorMaterial, 2, Strings.HeartLeggingsName);
        Registrar.registerItem(heartLeggings);
        
        heartBoots = new ChaosArmorItem(gaiaArmorMaterial, 3, Strings.HeartBootsName);
        Registrar.registerItem(heartBoots);
        
        
        chaosHelmet = new ChaosArmorItem(gaiaArmorMaterial, 0, Strings.ChaosHelmetName);
        Registrar.registerItem(chaosHelmet);
        
        chaosChest = new ChaosArmorItem(gaiaArmorMaterial, 1, Strings.ChaosChestName);
        Registrar.registerItem(chaosChest);
        
        chaosLeggings = new ChaosArmorItem(gaiaArmorMaterial, 2, Strings.ChaosLeggingsName);
        Registrar.registerItem(chaosLeggings);
        
        chaosBoots = new ChaosArmorItem(gaiaArmorMaterial, 3, Strings.ChaosBootsName);
        Registrar.registerItem(chaosBoots);
        
        
        orderHelmet = new OrderArmorItem(gaiaArmorMaterial, 0, Strings.OrderHelmetName);
        Registrar.registerItem(orderHelmet);
        
        orderChest = new OrderArmorItem(gaiaArmorMaterial, 1, Strings.OrderChestName);
        Registrar.registerItem(orderChest);
        
        orderLeggings = new OrderArmorItem(gaiaArmorMaterial, 2, Strings.OrderLeggingsName);
        Registrar.registerItem(orderLeggings);
        
        orderBoots = new OrderArmorItem(gaiaArmorMaterial, 3, Strings.OrderBootsName);
        Registrar.registerItem(orderBoots);
        
    }
	
}
