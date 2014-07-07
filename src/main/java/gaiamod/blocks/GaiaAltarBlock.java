package gaiamod.blocks;

import gaiamod.GaiaMod;
import gaiamod.gui.ModGui;
import gaiamod.tileentities.TileEntityGaiaAltarBlock;
import gaiamod.util.References;
import gaiamod.util.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GaiaAltarBlock extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
	private IIcon gaiaAltarFront;
	
	@SideOnly(Side.CLIENT)
	private IIcon gaiaAltarTop;

	protected GaiaAltarBlock() {
		super(Material.rock);
		this.setBlockName(Strings.GaiaAltarBlockName);
		this.setCreativeTab(GaiaMod.getcreativeTab());

		this.setHardness(3.5f);
		this.setResistance(5f);
		//this.setHarvestLevel("pickaxe", 2);

		this.setStepSound(Block.soundTypeStone);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5) + "_side");
		this.gaiaAltarFront = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5) + "_front");
		this.gaiaAltarTop = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5) + "_top");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return side == 1 ? this.gaiaAltarTop : (side == 0 ? this.gaiaAltarTop : (side != metadata ? this.blockIcon : this.gaiaAltarFront));
    }

	public Item getItemDropped(World world, int x , int y, int z) {
		
		return Item.getItemFromBlock(this);
	}
	
	public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }
	
	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote)
        {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
		
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, GaiaMod.instance, ModGui.guiIDGaiaAltarBlock, world, x, y, z);
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityGaiaAltarBlock();
	}
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
    {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
        	world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
        	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
        	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
        	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemstack.hasDisplayName())
        {
            ((TileEntityGaiaAltarBlock)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
        }
    }	
	
	
	
	

	
	
	
	

	
}
