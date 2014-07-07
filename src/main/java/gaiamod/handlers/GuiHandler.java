package gaiamod.handlers;

import gaiamod.containers.ContainerGaiaAltarBlock;
import gaiamod.gui.GuiGaiaAltarBlock;
import gaiamod.gui.ModGui;
import gaiamod.tileentities.TileEntityGaiaAltarBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case ModGui.guiIDGaiaAltarBlock:
				if (entity instanceof TileEntityGaiaAltarBlock){
					return new ContainerGaiaAltarBlock(player.inventory, (TileEntityGaiaAltarBlock) entity);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case ModGui.guiIDGaiaAltarBlock:
				if (entity instanceof TileEntityGaiaAltarBlock){
					return new GuiGaiaAltarBlock(player.inventory, (TileEntityGaiaAltarBlock) entity);
				}
				return null;
			}
		}
		return null;
	}

}
