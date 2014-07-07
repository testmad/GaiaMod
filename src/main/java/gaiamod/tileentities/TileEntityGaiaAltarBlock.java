package gaiamod.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGaiaAltarBlock extends TileEntity implements ISidedInventory{
	
	private String localizedName;
	
	private static final int[] slots_top = new int[]{3,4,5,6};
	private static final int[] slots_bottom = new int[]{0,1,2};
	private static final int[] slots_side = new int[]{7};
	
	private ItemStack[] slots = new ItemStack [8];
	
	public int waterLvl;
	public int lavaLvl;
	public int availableUses;
	

	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
		
	}
	
	public String getInventoryName(){
		return this.hasCustomInventoryName() ? this.localizedName : "container.gaiaAltarBlock";
	}

	public boolean hasCustomInventoryName() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	public int getSizeInventory(){
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if(this.slots[var1] != null){
			ItemStack itemstack;
			if(this.slots[var1].stackSize <= var2){
				itemstack = this.slots[var1];
				this.slots[var1] = null;
				return itemstack;
			}else{
				itemstack = this.slots[var1].splitStack(var2);
				
				if(this.slots[var1].stackSize == 0){
					this.slots[var1] = null;
				}
			}
		}
		
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(this.slots[i] != null){
			ItemStack itemstack = this.slots[i];
			this.slots[i] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.slots[i] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = this.getInventoryStackLimit();
		}
		
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false: entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
		
	}

	public void openInventory() {
	}

	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return (i == 7) || (i == 2) ? false : (i == 0 ? isItemWater(itemstack) : true ) || (i == 1 ? isItemLava(itemstack) : true);
	}
	
	public static boolean isItemWater (ItemStack itemstack){
		if(itemstack == null){
			return false;
		}else{
			Item item = itemstack.getItem();
			
			if(item != Items.water_bucket){
				return false;
			}else{
				return true;
			}
		}
	}
	
	public static boolean isItemLava (ItemStack itemstack){
		if(itemstack == null){
			return false;
		}else{
			Item item = itemstack.getItem();
			
			if(item != Items.lava_bucket){
				return false;
			}else{
				return true;
			}
		}
	}

	public void updateEntity() {
		
		
	}
	
	
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
	
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int var3) {

		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {

		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}
}
