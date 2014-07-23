package gaiamod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class MarbleBrickBlock extends Block {

	protected MarbleBrickBlock() {
		super(Material.rock);
		
		this.setStepSound(soundTypeStone);
		setCreativeTab(GaiaMod.getcreativeTab());

	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5));
	}

}
