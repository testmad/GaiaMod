package gaiamod.armor;

import gaiamod.util.Registrar;
import gaiamod.util.Strings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmor {
	
	public static Item gaiaHelmet;
	public static Item gaiaChest;
	public static Item gaiaLeggings;
	public static Item gaiaBoots;
	
	public static Item omegaHelmet;
	public static Item omegaChest;
	public static Item omegaLeggings;
	public static Item omegaBoots;
	
	public static Item earthHelmet;
	public static Item earthChest;
	public static Item earthLeggings;
	public static Item earthBoots;
	
	public static Item fireHelmet;
	public static Item fireChest;
	public static Item fireLeggings;
	public static Item fireBoots;
	
	public static Item waterHelmet;
	public static Item waterChest;
	public static Item waterLeggings;
	public static Item waterBoots;
	
	static ArmorMaterial gaiaArmorMaterial = EnumHelper.addArmorMaterial("gaiaArmorMaterial", 20, new int[]{2,6,5,2}, 20);
	
	public static void init()
    {

        gaiaHelmet = new GaiaArmorItem(gaiaArmorMaterial, 0, Strings.GaiaHelmetName);
        Registrar.registerItem(gaiaHelmet);
        
        gaiaChest = new GaiaArmorItem(gaiaArmorMaterial, 1, Strings.GaiaChestName);
        Registrar.registerItem(gaiaChest);
        
        gaiaLeggings = new GaiaArmorItem(gaiaArmorMaterial, 2, Strings.GaiaLeggingsName);
        Registrar.registerItem(gaiaLeggings);
        
        gaiaBoots = new GaiaArmorItem(gaiaArmorMaterial, 3, Strings.GaiaBootsName);
        Registrar.registerItem(gaiaBoots);
        
        omegaHelmet = new OmegaArmorItem(gaiaArmorMaterial, 0, Strings.OmegaHelmetName);
        Registrar.registerItem(omegaHelmet);
        
        omegaChest = new OmegaArmorItem(gaiaArmorMaterial, 1, Strings.OmegaChestName);
        Registrar.registerItem(omegaChest);
        
        omegaLeggings = new OmegaArmorItem(gaiaArmorMaterial, 2, Strings.OmegaLeggingsName);
        Registrar.registerItem(omegaLeggings);
        
        omegaBoots = new OmegaArmorItem(gaiaArmorMaterial, 3, Strings.OmegaBootsName);
        Registrar.registerItem(omegaBoots);
        
        
        earthHelmet = new OmegaArmorItem(gaiaArmorMaterial, 0, Strings.EarthHelmetName);
        Registrar.registerItem(earthHelmet);
        
        earthChest = new OmegaArmorItem(gaiaArmorMaterial, 1, Strings.EarthChestName);
        Registrar.registerItem(earthChest);
        
        earthLeggings = new OmegaArmorItem(gaiaArmorMaterial, 2, Strings.EarthLeggingsName);
        Registrar.registerItem(earthLeggings);
        
        earthBoots = new OmegaArmorItem(gaiaArmorMaterial, 3, Strings.EarthBootsName);
        Registrar.registerItem(earthBoots);
        
        
        fireHelmet = new OmegaArmorItem(gaiaArmorMaterial, 0, Strings.FireHelmetName);
        Registrar.registerItem(fireHelmet);
        
        fireChest = new OmegaArmorItem(gaiaArmorMaterial, 1, Strings.FireChestName);
        Registrar.registerItem(fireChest);
        
        fireLeggings = new OmegaArmorItem(gaiaArmorMaterial, 2, Strings.FireLeggingsName);
        Registrar.registerItem(fireLeggings);
        
        fireBoots = new OmegaArmorItem(gaiaArmorMaterial, 3, Strings.FireBootsName);
        Registrar.registerItem(fireBoots);
        
        
        waterHelmet = new OmegaArmorItem(gaiaArmorMaterial, 0, Strings.WaterHelmetName);
        Registrar.registerItem(waterHelmet);
        
        waterChest = new OmegaArmorItem(gaiaArmorMaterial, 1, Strings.WaterChestName);
        Registrar.registerItem(waterChest);
        
        waterLeggings = new OmegaArmorItem(gaiaArmorMaterial, 2, Strings.WaterLeggingsName);
        Registrar.registerItem(waterLeggings);
        
        waterBoots = new OmegaArmorItem(gaiaArmorMaterial, 3, Strings.WaterBootsName);
        Registrar.registerItem(waterBoots);
        
    }
	
}
