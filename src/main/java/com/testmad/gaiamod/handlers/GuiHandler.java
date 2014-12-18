package com.testmad.gaiamod.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.testmad.gaiamod.containers.ContainerEssenceAltar;
import com.testmad.gaiamod.containers.ContainerGaiaAltar;
import com.testmad.gaiamod.containers.ContainerOrderShrine;
import com.testmad.gaiamod.gui.GuiEssenceAltar;
import com.testmad.gaiamod.gui.GuiGaiaAltar;
import com.testmad.gaiamod.gui.GuiOrderShrine;
import com.testmad.gaiamod.gui.ModGui;
import com.testmad.gaiamod.tileentities.TileEntityEssenceAltar;
import com.testmad.gaiamod.tileentities.TileEntityGaiaAltar;
import com.testmad.gaiamod.tileentities.TileEntityOrderShrine;

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
