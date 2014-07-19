package gaiamod.containers;

import gaiamod.slots.SlotGaiaAltar;
import gaiamod.tileentities.TileEntityEssenceAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerEssenceAltar extends Container{
	
	private TileEntityEssenceAltar altar;
	
	private int cookTime;
	private int waterPower;
	private int lavaPower;
	private int lastItemBurnTime;
	
	private int chanceLevel;
	private int essenceLevel;

	public ContainerEssenceAltar(InventoryPlayer invPlayer, TileEntityEssenceAltar entity){
		
		cookTime = 0;
		waterPower = 0;
		lavaPower = 0;
		lastItemBurnTime = 0;
		
		chanceLevel = 0;
		essenceLevel = 0;
		
		altar = entity;
		
		//grid
		this.addSlotToContainer(new Slot(entity, 0, 42, 26));
		this.addSlotToContainer(new Slot(entity, 1, 60, 26));
		this.addSlotToContainer(new Slot(entity, 2, 42, 44));
		this.addSlotToContainer(new Slot(entity, 3, 60, 44));
		
		//result
		this.addSlotToContainer(new SlotGaiaAltar(invPlayer.player, entity, 4, 118, 35));
		
		//water slot
		this.addSlotToContainer(new Slot(entity, 5, 10, 58));
		
		//lava slot
		this.addSlotToContainer(new Slot(entity, 6, 150, 58));
		
		//player inv		
		for (int i = 0; i < 3; i++){
			for(int k = 0; k < 9; k++){
				this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}
		//player hotbar
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting crafting){
		super.addCraftingToCrafters(crafting);
		//crafting.sendProgressBarUpdate(this, 0, this.altar.cookTime);
		crafting.sendProgressBarUpdate(this, 1, this.altar.waterPowerLevel);
		crafting.sendProgressBarUpdate(this, 2, this.altar.lavaPowerLevel);
		
		crafting.sendProgressBarUpdate(this, 3, this.altar.chanceLevel);
		crafting.sendProgressBarUpdate(this, 4, this.altar.essenceLevel);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }	
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for (int i=0; i < this.crafters.size(); i++){
			ICrafting par1 = (ICrafting)this.crafters.get(i);
			
			//if(this.cookTime != this.altar.cookTime){
			//	par1.sendProgressBarUpdate(this, 0, this.altar.cookTime);
			//}
			
			if(this.waterPower != this.altar.waterPowerLevel){
				par1.sendProgressBarUpdate(this, 1, this.altar.waterPowerLevel);
			}
			
			if(this.lavaPower != this.altar.lavaPowerLevel){
				par1.sendProgressBarUpdate(this, 2, this.altar.lavaPowerLevel);
			}
			
			if(this.chanceLevel != this.altar.chanceLevel){
				par1.sendProgressBarUpdate(this, 3, this.altar.chanceLevel);
			}
			
			if(this.essenceLevel != this.altar.essenceLevel){
				par1.sendProgressBarUpdate(this, 4, this.altar.essenceLevel);
			}
		}
		
		//this.cookTime = this.altar.cookTime;
		this.waterPower = this.altar.waterPowerLevel;
		this.lavaPower = this.altar.lavaPowerLevel;
		
		this.chanceLevel = this.altar.chanceLevel;
		this.essenceLevel = this.altar.essenceLevel;
		
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int i, int j){
		if(i ==0){
			//altar.cookTime = j;
			
		}
		
		if(i ==1){
			altar.waterPowerLevel = j;
		}
		
		if(i ==2){
			altar.lavaPowerLevel = j;
		}
		
		if(i ==3){
			altar.chanceLevel = j;
		}
		
		if(i ==4){
			altar.essenceLevel = j;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return altar.isUseableByPlayer(player);
	}

}
