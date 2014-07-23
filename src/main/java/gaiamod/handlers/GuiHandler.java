package gaiamod.handlers;

import gaiamod.containers.ContainerEssenceAltar;
import gaiamod.containers.ContainerGaiaAltar;
import gaiamod.containers.ContainerOrderShrine;
import gaiamod.gui.GuiEssenceAltar;
import gaiamod.gui.GuiGaiaAltar;
import gaiamod.gui.GuiOrderShrine;
import gaiamod.gui.ModGui;
import gaiamod.tileentities.TileEntityEssenceAltar;
import gaiamod.tileentities.TileEntityGaiaAltar;
import gaiamod.tileentities.TileEntityOrderShrine;
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
				
			case ModGui.guiIDEssenceAltar:
				if (entity instanceof TileEntityEssenceAltar){
					return new ContainerEssenceAltar(player.inventory, (TileEntityEssenceAltar) entity);
				}
				return null;
				
			case ModGui.guiIDOrderShrine:
				if (entity instanceof TileEntityOrderShrine){
					return new ContainerOrderShrine(player.inventory, (TileEntityOrderShrine) entity);
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
				
			case ModGui.guiIDEssenceAltar:
				if (entity instanceof TileEntityEssenceAltar){
					return new GuiEssenceAltar(player.inventory, (TileEntityEssenceAltar) entity);
				}
				return null;
				
			case ModGui.guiIDOrderShrine:
				if (entity instanceof TileEntityOrderShrine){
					return new GuiOrderShrine(player.inventory, (TileEntityOrderShrine) entity);
				}
				return null;
			}
		}
		return null;
	}

}
