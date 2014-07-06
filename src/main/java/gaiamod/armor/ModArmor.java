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
        
    }
	
}
