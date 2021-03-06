package com.testmad.gaiamod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.testmad.gaiamod.GaiaMod;
import com.testmad.gaiamod.gui.ModGui;
import com.testmad.gaiamod.tileentities.TileEntityOrderShrine;
import com.testmad.gaiamod.util.References;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OrderShrineBlock extends BlockContainer {

	private Random rand;

	private static boolean keepInventory = false;

	private final boolean isPowered;

	@SideOnly(Side.CLIENT)
	private IIcon orderShrineFront;

	@SideOnly(Side.CLIENT)
	private IIcon orderShrineTop;

	@SideOnly(Side.CLIENT)
	private IIcon orderShrineBottom;

	protected OrderShrineBlock(boolean hasPower) {
		super(Material.rock);
		rand = new Random();

		isPowered = hasPower;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		// this.blockIcon = iconRegister.registerIcon(References.MODID + ":" +
		// getUnlocalizedName().substring(5) + "_side");
		this.blockIcon = iconRegister.registerIcon(References.MODIDLOCAL + ":"
				+ getUnlocalizedName().substring(5) + "_side");
		// this.gaiaAltarFront = iconRegister.registerIcon(References.MODID +
		// ":" + getUnlocalizedName().substring(5) + "_front");
		this.orderShrineTop = iconRegister.registerIcon(References.MODIDLOCAL
				+ ":" + getUnlocalizedName().substring(5) + "_top");
		// this.gaiaAltarTop = iconRegister.registerIcon(References.MODID + ":"
		// + getUnlocalizedName().substring(5) + "_top");
		this.orderShrineFront = iconRegister.registerIcon(References.MODIDLOCAL
				+ ":"
				+ (this.isPowered ? getUnlocalizedName().substring(5)
						+ "_front" : getUnlocalizedName().substring(5)
						+ "_front"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		// return side == 1 ? this.gaiaAltarTop : (side == 0 ? this.gaiaAltarTop
		// : (side != metadata ? this.blockIcon : this.gaiaAltarFront));
		// return metadata == 0 && side == 1 ? this.gaiaAltarTop : (side ==
		// metadata ? this.gaiaAltarTop : this.blockIcon);
		// return side == 1 ? this.gaiaAltarTop : this.blockIcon;
		return side == 1 || side == 0 ? this.orderShrineTop : (metadata == 0
				&& side == 3 ? this.orderShrineFront
				: (side != metadata ? this.blockIcon : this.orderShrineFront));
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			byte b0 = 3;

			if (block.func_149730_j() && !block1.func_149730_j()) {
				b0 = 3;
			}

			if (block1.func_149730_j() && !block.func_149730_j()) {
				b0 = 2;
			}

			if (block2.func_149730_j() && !block3.func_149730_j()) {
				b0 = 5;
			}

			if (block3.func_149730_j() && !block2.func_149730_j()) {
				b0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}

	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entity, ItemStack itemstack) {
		int l = MathHelper
				.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if (itemstack.hasDisplayName()) {
			// ((TileEntityGaiaAltar)world.getTileEntity(x, y,
			// z)).setCustomName(itemstack.getDisplayName());
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		} else if (!player.isSneaking()) {
			TileEntityOrderShrine entity = (TileEntityOrderShrine) world
					.getTileEntity(x, y, z);
			if (entity != null) {
				FMLNetworkHandler.openGui(player, GaiaMod.instance,
						ModGui.guiIDOrderShrine, world, x, y, z);
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityOrderShrine();
	}

	public static void updateBlockState(boolean powered, World world,
			int xCoord, int yCoord, int zCoord) {

		int i = world.getBlockMetadata(xCoord, yCoord, zCoord);
		TileEntity entity = world.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;

		if (powered) {
			world.setBlock(xCoord, yCoord, zCoord,
					ModBlocks.orderShrineBlockIdlePower);
		} else {
			world.setBlock(xCoord, yCoord, zCoord,
					ModBlocks.orderShrineBlockIdle);
		}
		keepInventory = false;
		world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if (entity != null) {
			entity.validate();
			world.setTileEntity(xCoord, yCoord, zCoord, entity);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {

	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldblock,
			int oldMetadata) {
		if (!keepInventory) {
			TileEntityOrderShrine tileentity = (TileEntityOrderShrine) world
					.getTileEntity(x, y, z);

			if (tileentity != null) {
				for (int i = 0; i < tileentity.getSizeInventory(); i++) {
					ItemStack itemstack = tileentity.getStackInSlot(i);

					if (itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;

							if (j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;

							EntityItem item = new EntityItem(world, x + f, y
									+ f1, z + f2, new ItemStack(
									itemstack.getItem(), j,
									itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								item.getEntityItem().setTagCompound(
										(NBTTagCompound) itemstack
												.getTagCompound().copy());
							}

							world.spawnEntityInWorld(item);
						}
					}
				}

				world.func_147453_f(x, y, z, oldblock);
			}
		}

		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}

	public Item getItemDropped(World world, int x, int y, int z) {

		return Item.getItemFromBlock(ModBlocks.orderShrineBlockIdle);
	}

}
