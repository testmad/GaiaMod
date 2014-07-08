package gaiamod.handlers;

import gaiamod.containers.ContainerGaiaAltar;
import gaiamod.gui.GuiGaiaAltar;
import gaiamod.gui.ModGui;
import gaiamod.tileentities.TileEntityGaiaAltar;
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
			case ModGui.guiIDGaiaAltar:
				if (entity instanceof TileEntityGaiaAltar){
					return new ContainerGaiaAltar(player.inventory, (TileEntityGaiaAltar) entity);
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
			case ModGui.guiIDGaiaAltar:
				if (entity instanceof TileEntityGaiaAltar){
					return new GuiGaiaAltar(player.inventory, (TileEntityGaiaAltar) entity);
				}
				return null;
			}
		}
		return null;
	}

}
