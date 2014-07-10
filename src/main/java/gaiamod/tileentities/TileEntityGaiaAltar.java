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
	public int waterPowerLevel;
	public int lavaPowerLevel;
	public int burn;
	public static final int maxWaterPower = 1000;
	public static final int maxLavaPower = 1000;
	
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
		}
		return null;
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
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}	

	public void openInventory() {}
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 4 ? false : (i == 5 ? isItemWater(itemstack) : (i == 6 ? isItemLava(itemstack) : true));
	}
	
	public boolean isItemWater(ItemStack itemstack){
		return getHasWater(itemstack) > 0;
	}
	
	public boolean isItemLava(ItemStack itemstack){
		return getHasLava(itemstack) > 0;
	}
	
	public static int getHasWater (ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
				Block block = Block.getBlockFromItem(item);
				
				if(block == Blocks.water) return 800;
				
			}
			
			if(item == Items.water_bucket) return 800;
		}
		return 0;
	}
	
	public static int getHasLava (ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
				Block block = Block.getBlockFromItem(item);
				
				if(block == Blocks.lava) return 800;
				
			}
			
			if(item == Items.lava_bucket) return 800;
		}
		return 0;
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
		waterPowerLevel = nbt.getShort("WaterPower");
		lavaPowerLevel = nbt.getShort("LavaPower");
		cookTime = nbt.getShort("CookTime");
	}

	public void  writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setShort("WaterPower", (short)waterPowerLevel);
		nbt.setShort("LavaPower", (short)lavaPowerLevel);
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
		return(waterPowerLevel *i / maxWaterPower);
	}
	
	public int getLavaRemainingScaled(int i){
		return(lavaPowerLevel *i / maxLavaPower);
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
		return waterPowerLevel > 0;
	}
	
	public boolean hasLavaPower(){
		return lavaPowerLevel > 0;
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
			this.waterPowerLevel--;
			this.lavaPowerLevel--;
		}
		
		if(!worldObj.isRemote){
			if(this.isItemWater(this.slots[5]) && this.waterPowerLevel < (this.maxWaterPower - this.getHasWater(this.slots[5]))){
				this.waterPowerLevel += getHasWater(this.slots[5]);
				
				if(this.slots[5] != null){
					flag2 = true;
					this.slots[5].stackSize --;
					
					if(this.slots[5].stackSize ==0){
						this.slots[5] = this.slots[5].getItem().getContainerItem(this.slots[5]);
					}
				}
			}
			
			if(this.isItemLava(this.slots[6]) && this.lavaPowerLevel < (this.maxLavaPower - this.getHasLava(this.slots[6]))){
				this.lavaPowerLevel += getHasLava(this.slots[6]);
				
				if(this.slots[6] != null){
					flag2 = true;
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
					flag2 = true;
				}
			}else{
				this.cookTime = 0;
				flag3 = true;
			}
			
			if(flag3 != this.isAltaring()){
				flag3=true;
				GaiaAltarBlock.updateBlockState(this.isAltaring(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if(flag2 || flag3){
			this.markDirty();
		}
	}
}
