package gaiamod.blocks;

import gaiamod.GaiaMod;
import gaiamod.gui.ModGui;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GaiaAltarBlock extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon gaiaAltarTop;

	protected GaiaAltarBlock() {
		super(Material.rock);
		this.setBlockName(Strings.GaiaAltarBlockName);
		this.setBlockTextureName(References.MODID + ":"	+ getUnlocalizedName().substring(5));
		this.setCreativeTab(GaiaMod.getcreativeTab());

		this.setHardness(3.5f);
		this.setResistance(5f);
		//this.setHarvestLevel("pickaxe", 2);

		this.setStepSound(Block.soundTypeStone);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		
		return side == 1 ? this.gaiaAltarTop : this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		
		this.blockIcon = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5) + "Side");
		this.gaiaAltarTop = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5) + "Top");
	}
	
	public boolean onBlockActivated ( World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c){
		
		if(!player.isSneaking()) {
			player.openGui(GaiaMod.instance, ModGui.guiGaiaAltarBlock, world, x, y, z);
			return true;
		}else{
			return false;
		}
	}
}
