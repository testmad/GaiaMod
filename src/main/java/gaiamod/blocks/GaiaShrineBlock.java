package gaiamod.blocks;

import gaiamod.GaiaMod;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GaiaShrineBlock extends Block {

	protected GaiaShrineBlock() {
		super(Material.iron);
		setBlockTextureName(References.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(GaiaMod.getcreativeTab());
		setBlockName(Strings.GaiaShrineBlockName);
	}

}
