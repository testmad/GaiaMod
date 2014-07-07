package gaiamod.containers;

import gaiamod.tileentities.TileEntityGaiaAltarBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerGaiaAltarBlock extends Container{
	
	private TileEntityGaiaAltarBlock gaiaAltarBlock;

	public ContainerGaiaAltarBlock(InventoryPlayer inventory, TileEntityGaiaAltarBlock tileentity){
		this.gaiaAltarBlock = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 10, 58));
		this.addSlotToContainer(new Slot(tileentity, 1, 150, 58));
		//this.addSlotToContainer(new SlotCrafting(inventory.player, tileentity, 7, 116, 34));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting icrafting){
		
	}
	
	public void detectAndSendChanges(){
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue){
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
