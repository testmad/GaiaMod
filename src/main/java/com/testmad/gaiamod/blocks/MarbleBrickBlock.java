package com.testmad.gaiamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.util.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MarbleBrickBlock extends Block {

	protected MarbleBrickBlock() {
		super(Material.rock);
		
		this.setStepSound(soundTypeStone);
		setCreativeTab(GaiaMod.getcreativeTab());

	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(References.MODIDLOCAL + ":" + getUnlocalizedName().substring(5));
	}

}
