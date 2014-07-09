package gaiamod.tileentities;

import gaiamod.blocks.GaiaAltarBlock;
import gaiamod.handlers.AltarRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGaiaAltar extends TileEntity implements ISidedInventory{
	
	private ItemStack[] slots = new ItemStack[7];
	
	public int cookTime;
	public int waterPower;
	public int lavaPower;
	public static final int maxWaterPower = 1001;
	public static final int maxLavaPower = 1001;
	
	public static final int cookSpeed = 100;
	
	private static final int[] slots_top = new int[]{0, 1, 2, 3};
	private static final int[] slots_bottom = new int[]{4};
	private static final int[] slots_side = new int[]{5, 6};
	
	private String customName;
	
	public TileEntityGaiaAltar(){
		//slots = new ItemStack[7];
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (slots[i] != null){
			ItemStack itemstack;
			
			if (slots[i].stackSize <= j){
				itemstack = slots[i];
				slots[i] = null;
				return itemstack;
			}else{
		
			itemstack = slots[i].splitStack(j);
			if(slots[i].stackSize == 0){
				slots[i] = null;
			}
			return itemstack;
		}
		}else{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(slots[i]!= null){
			ItemStack itemstack = slots[i];
			slots[i] = null;
			return itemstack;
		}else{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		slots[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return "container.gaiaAltar";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		}else{
			return player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64;
		}
	}

	public void openInventory() {}
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		//return i == 4 ? false : (i == 5 ? hasWater(itemstack) : (i == 6 ? hasLava(itemstack) : true));
		return i == 4 ? false : (i == 5 ? hasWater(itemstack) : (i == 6 ? hasLava(itemstack) : true));
		
	}
	
	public boolean hasWater(ItemStack itemstack){
		return isItemWater(itemstack) > 0;
	}
	
	public boolean hasLava(ItemStack itemstack){
		return isItemLava(itemstack) > 0;
	}
	
	public static int isItemWater (ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item != Items.water_bucket) return 0;
			return 100;
		}
	}
	
	public static int isItemLava (ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item != Items.lava_bucket) return 0;
			return 100;
		}
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
	
		NBTTagList list = nbt.getTagList("Items", 10);
		slots = new ItemStack[getSizeInventory()];
	
		for(int i = 0; i < list.tagCount(); i++){
			NBTTagCompound nbt1 = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");
		
			if(b0 >= 0 && b0 < slots.length){
				slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
		waterPower = nbt.getShort("WaterPower");
		lavaPower = nbt.getShort("LavaPower");
		cookTime = nbt.getShort("CookTime");
	}

	public void  writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setShort("WaterPower", (short)waterPower);
		nbt.setShort("LavaPower", (short)lavaPower);
		nbt.setShort("CookTime", (short)cookTime);
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < slots.length; i++){
			if(slots[i] != null){
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte)i);
				slots[i].writeToNBT(nbt1);
				list.appendTag(nbt1);
			}
		}
		nbt.setTag("Items", list);
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return i == 0 ? slots_bottom : (i == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack itemstack, int var3) {
		return this.isItemValidForSlot(var1, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 4 || i != 1;
	}
	
	public int getAltarProgressScaled(int i){
		return(cookTime *i / this.cookSpeed);
	}
	
	public int getWaterRemainingScaled(int i){
		return(waterPower *i / maxWaterPower);
	}
	
	public int getLavaRemainingScaled(int i){
		return(lavaPower *i / maxLavaPower);
	}
	
	private boolean canAltar(){
		if (slots[0] == null || slots[1] == null || slots[2] == null || slots[3] == null){
			return false;
		}
		
		ItemStack itemstack = AltarRecipes.getAltarResult(slots[0].getItem(), slots[1].getItem(), slots[2].getItem(), slots[3].getItem());
		
		if (itemstack == null){
			return false;
		}
		
		if (slots[4] == null){
			return true;
		}
		
		if (!slots[4].isItemEqual(itemstack)){
			return false;
		}
		
		if (slots[4].stackSize < getInventoryStackLimit() && slots[4].stackSize < slots[4].getMaxStackSize()){
			return true;
		}else{
			return slots[4].stackSize < itemstack.getMaxStackSize();
		}
	}
	
	private void altarItem(){
		if (canAltar()){
			ItemStack itemstack = AltarRecipes.getAltarResult(slots[0].getItem(), slots[1].getItem(), slots[2].getItem(), slots[3].getItem());
			
			if(slots[4] == null){
				slots[4] = itemstack.copy();
			}else if (slots[4].isItemEqual(itemstack)){
				slots[4].stackSize += itemstack.stackSize;
			}
			
			for (int i = 0; i < 4; i++){
				if(slots[i].stackSize <= 0){
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				}else{
					slots[i].stackSize--;
				}
				
				if(slots[i].stackSize <= 0){
					slots[i] = null;
				}
			}
		}
	}
	
	public boolean hasWaterPower(){
		return waterPower > 0;
	}
	
	public boolean hasLavaPower(){
		return lavaPower > 0;
	}
	
	public boolean isAltaring(){
		return this.cookTime > 0;
	}
	
	public void updateEntity(){
		
		boolean flag = this.hasWaterPower();
		boolean flag1 = this.hasLavaPower();
		boolean flag2 = false;
		boolean flag3 = false;
		
		if(hasWaterPower() && hasLavaPower() && this.isAltaring()){
			this.waterPower--;
			this.lavaPower--;
			
		}
		
		if(!worldObj.isRemote){
			if(this.hasWater(this.slots[5]) && this.waterPower < (this.maxWaterPower - this.isItemWater(this.slots[5]))){
				this.waterPower += isItemWater(this.slots[5]);
				
				if(this.slots[5] != null){
					flag2 = true;
					this.slots[5].stackSize --;
					
					if(this.slots[5].stackSize ==0){
						this.slots[5] = this.slots[5].getItem().getContainerItem(this.slots[5]);
					}
				}
			}
			
			if(this.hasLava(this.slots[6]) && this.lavaPower < (this.maxLavaPower - this.isItemLava(this.slots[6]))){
				this.lavaPower += isItemLava(this.slots[6]);
				
				if(this.slots[6] != null){
					flag3 = true;
					this.slots[6].stackSize --;
					
					if(this.slots[6].stackSize ==0){
						this.slots[6] = this.slots[6].getItem().getContainerItem(this.slots[6]);
					}
				}
			}
			
			if (hasWaterPower() && hasLavaPower() && canAltar()){
				cookTime++;
				
				if (this.cookTime == this.cookSpeed){
					this.cookTime = 0;
					this.altarItem();
					flag2=true;
					flag3=true;
				}
			}else{
				cookTime = 0;
			}
			
			if(flag != this.isAltaring() && flag1 != this.isAltaring()){
				flag2=true;
				flag3=true;
				GaiaAltarBlock.updateBlockState(this.isAltaring(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		
		if(flag2 && flag3){
			this.markDirty();
		}
		
		
	}

}
