package gaiamod.tileentities;

import gaiamod.handlers.AltarRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGaiaAltar extends TileEntity implements ISidedInventory{
	
	//private String localizedName;
	
	//private static final int[] slots_top = new int[]{3,4,5,6};
	//private static final int[] slots_bottom = new int[]{0,1,2};
	//private static final int[] slots_side = new int[]{7};
	
	//water 5
	//lava 6
	
	private ItemStack slots[];
	
	public int cookTime;
	public int waterPower;
	public int lavaPower;
	public static final int maxPower = 10000;
	public static final int cookSpeed = 100;
	
	private static final int[] slots_top = new int[]{0, 1, 2, 3};
	private static final int[] slots_bottom = new int[]{4};
	private static final int[] slots_side = new int[]{5, 6};
	
	private String customName;
	
	public TileEntityGaiaAltar(){
		slots = new ItemStack[7];
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
			if (slots[i].stackSize <= j){
				ItemStack itemstack = slots[i];
				slots[i] = null;
				return itemstack;
			}
			ItemStack itemstack1 = slots[i].splitStack(j);
			if(slots[i].stackSize == 0){
				slots[i] = null;
			}
			return itemstack1;
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
			
			if(item == Items.water_bucket) return 50;
			return 0;
		}
	}
	
	public static int isItemLava (ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item == Items.lava_bucket) return 50;
			return 0;
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
		return(waterPower *i / maxPower);
	}
	
	public int getLavaRemainingScaled(int i){
		return(lavaPower *i / maxPower);
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
			
			for (int i = 0; i < 2; i++){
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
	
	public void updateEntity(){
		
	}

//	public void setGuiDisplayName(String displayName) {
//		this.localizedName = displayName;
//		
//	}
//	
//	public String getInventoryName(){
//		return this.hasCustomInventoryName() ? this.localizedName : "container.gaiaAltarBlock";
//	}
//
//	public boolean hasCustomInventoryName() {
//		return this.localizedName != null && this.localizedName.length() > 0;
//	}
//
//	public int getSizeInventory(){
//		return this.slots.length;
//	}
//
//	@Override
//	public ItemStack getStackInSlot(int var1) {
//		return this.slots[var1];
//	}
//
//	@Override
//	public ItemStack decrStackSize(int var1, int var2) {
//		if(this.slots[var1] != null){
//			ItemStack itemstack;
//			if(this.slots[var1].stackSize <= var2){
//				itemstack = this.slots[var1];
//				this.slots[var1] = null;
//				return itemstack;
//			}else{
//				itemstack = this.slots[var1].splitStack(var2);
//				
//				if(this.slots[var1].stackSize == 0){
//					this.slots[var1] = null;
//				}
//			}
//		}
//		
//		return null;
//	}
//
//	@Override
//	public ItemStack getStackInSlotOnClosing(int i) {
//		if(this.slots[i] != null){
//			ItemStack itemstack = this.slots[i];
//			this.slots[i] = null;
//			return itemstack;
//		}
//		return null;
//	}
//
//	@Override
//	public void setInventorySlotContents(int i, ItemStack itemstack) {
//		this.slots[i] = itemstack;
//		
//		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
//			itemstack.stackSize = this.getInventoryStackLimit();
//		}
//		
//	}
//
//	@Override
//	public int getInventoryStackLimit() {
//		return 64;
//	}
//
//	@Override
//	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
//		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false: entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
//		
//	}
//
//	public void openInventory() {
//	}
//
//	public void closeInventory() {
//	}
//
//	@Override
//	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
//		return (i == 7) || (i == 2) ? false : (i == 0 ? isItemWater(itemstack) : true ) || (i == 1 ? isItemLava(itemstack) : true);
//	}
//	
//	public static boolean isItemWater (ItemStack itemstack){
//		if(itemstack == null){
//			return false;
//		}else{
//			Item item = itemstack.getItem();
//			
//			if(item != Items.water_bucket){
//				return false;
//			}else{
//				return true;
//			}
//		}
//	}
//	
//	public static boolean isItemLava (ItemStack itemstack){
//		if(itemstack == null){
//			return false;
//		}else{
//			Item item = itemstack.getItem();
//			
//			if(item != Items.lava_bucket){
//				return false;
//			}else{
//				return true;
//			}
//		}
//	}
//
//	public void updateEntity() {
//		
//		
//	}
//	
//	
//	@Override
//	public int[] getAccessibleSlotsFromSide(int var1) {
//	
//		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
//	}
//
//	@Override
//	public boolean canInsertItem(int i, ItemStack itemstack, int var3) {
//
//		return this.isItemValidForSlot(i, itemstack);
//	}
//
//	@Override
//	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
//
//		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
//	}
//	
//	public void readFromNBT(NBTTagCompound nbt){
//		super.readFromNBT(nbt);
//		
//		NBTTagList list = nbt.getTagList("Items", 10);
//		this.slots = new ItemStack[this.getSizeInventory()];
//		
//		for(int i = 0; i < list.tagCount(); i++){
//			NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
//			byte b = compound.getByte("Slot");
//			
//			if(b >= 0 && b < this.slots.length){
//				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
//			}
//		}
//		
//
//	}
//	
//	
//	public void  writeToNBT(NBTTagCompound nbt){
//		super.writeToNBT(nbt);
//		
//
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
