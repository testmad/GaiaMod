package gaiamod.blocks;

import gaiamod.GaiaMod;
import gaiamod.lib.References;
import gaiamod.lib.Strings;
import gaiamod.stones.ModStones;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class GaiaAltarBlock extends Block {

	public GaiaAltarBlock() {
		super(Material.rock);
		this.setBlockName(Strings.GaiaAltarBlockName);
		this.setBlockTextureName(References.MODID + ":"
				+ getUnlocalizedName().substring(5));
		this.setCreativeTab(GaiaMod.getcreativeTab());

		this.setHardness(1f);
		this.setResistance(3f);
		this.setHarvestLevel("pickaxe", 2);

		this.setStepSound(Block.soundTypeGravel);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
}
