package gaiamod.containers;

import gaiamod.slots.SlotGaiaAltar;
import gaiamod.tileentities.TileEntityGaiaAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerGaiaAltar extends Container{
	
	private TileEntityGaiaAltar altar;
	
	private int cookTime;
	private int waterPower;
	private int lavaPower;
	private int lastItemBurnTime;

	public ContainerGaiaAltar(InventoryPlayer invPlayer, TileEntityGaiaAltar entity){
		
		cookTime = 0;
		waterPower = 0;
		lavaPower = 0;
		lastItemBurnTime = 0;
		
		altar = entity;
		
		//grid
		this.addSlotToContainer(new Slot(entity, 0, 36, 26));
		this.addSlotToContainer(new Slot(entity, 1, 54, 26));
		this.addSlotToContainer(new Slot(entity, 2, 36, 44));
		this.addSlotToContainer(new Slot(entity, 3, 54, 44));
		
		//result
		this.addSlotToContainer(new SlotGaiaAltar(invPlayer.player, entity, 4, 116, 35));
		
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
		crafting.sendProgressBarUpdate(this, 0, this.altar.cookTime);
		crafting.sendProgressBarUpdate(this, 1, this.altar.waterPower);
		//crafting.sendProgressBarUpdate(this, 1, this.altar.lavaPower);
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
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue){
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return altar.isUseableByPlayer(player);
	}

}
