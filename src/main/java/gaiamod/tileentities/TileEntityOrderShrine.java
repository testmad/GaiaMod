package gaiamod.tileentities;

import gaiamod.blocks.OrderShrineBlock;
import gaiamod.essence.ModEssence;
import gaiamod.handlers.AltarRecipes;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
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

public class TileEntityOrderShrine extends TileEntity implements ISidedInventory{
	
	private ItemStack[] slots = new ItemStack[7];
	
	public int cookTime;
	public int essencePowerLevel;


	public static final int maxEssencePower = 1000;
	
	public int cookSpeed;
	
	private static final int[] slots_top = new int[]{0, 1, 2, 3};
	private static final int[] slots_bottom = new int[]{4};
	private static final int[] slots_side = new int[]{5, 6};
	
	private String customName;
	
	public TileEntityOrderShrine(){
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
		return "container.orderShrine";
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
		return i == 2 ? false : (i == 0 ? isItemEssence(itemstack) :  true);
	}
	
	public boolean isItemEssence(ItemStack itemstack){
		return getHasEssence(itemstack) > 0;
	}
	
	public static int getHasEssence (ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
						
			if(item == ModEssence.earthEssenceItem) return 100;
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
		essencePowerLevel = nbt.getShort("EssencePower");

	}

	public void  writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setShort("EssencePower", (short)essencePowerLevel);

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
		return j != 0 || i != 1;
	}
	
	
	public int getEssenceRemainingScaled(int i){
		return(essencePowerLevel *i / maxEssencePower);
	}
	
	private boolean canAltar(){
		
		
		
		ItemStack itemstack = null;
		
		if (slots[1] == null){
			return false;
		}
		
		if (slots[1] != null && !slots[1].isItemDamaged()){
			return false;
		}
		
		if (slots[1] != null && slots[1].isItemDamaged()){
			itemstack = slots[1];
		}
	
		//itemstack = AltarRecipes.getShrineResult(slots[0].getItem());
		
		if (itemstack == null){
			return false;
		}
		
		if (slots[2] == null){
			return true;
		}
		
		if (!slots[2].isItemEqual(itemstack)){
			return false;
		}
		
		if (slots[2].stackSize < getInventoryStackLimit() && slots[2].stackSize < slots[4].getMaxStackSize()){
			return true;
		}else{
			return slots[2].stackSize < itemstack.getMaxStackSize();
		}
	}
	
//	private void altarItem(){
//		if (canAltar()){
//			ItemStack  itemstack;
//
//			
//			
//				
//				itemstack = slots[1];
//				
//				
//				
//				
//								
//				
//				
//				if(slots[2] == null){
//					slots[2] = itemstack.copy();
//					slots[1] = null;
//				}else if (slots[2].isItemEqual(itemstack)){
//					slots[2].stackSize += itemstack.stackSize;
//					slots[1] = null;
//				}
//		
//		}
//	}
	
	public boolean hasEssencePower(){
		return essencePowerLevel > 0;
	}
	
	
	public boolean isAltaring(){
		return this.cookTime > 0;
	}
	
	public void updateEntity(){
		
		boolean flag = this.hasEssencePower();

		boolean flag2 = false;
		boolean flag3 = false;
		
		
		if(hasEssencePower() && this.isAltaring()){
			
			this.essencePowerLevel--;

		}
		
		if(!worldObj.isRemote){
			
			//System.out.println(canAltar());
			
			if(this.isItemEssence(this.slots[0]) && this.essencePowerLevel < (this.maxEssencePower - this.getHasEssence(this.slots[0]))){
				this.essencePowerLevel += getHasEssence(this.slots[0]);
				
				if(this.slots[0] != null){
					flag2 = true;
					this.slots[0].stackSize --;
					
					if(this.slots[0].stackSize ==0){
						this.slots[0] = this.slots[0].getItem().getContainerItem(this.slots[0]);
					}
				}
			}
			
			
			if (hasEssencePower() && canAltar()){
				//cookSpeed = 80;
				int currentDamage = slots[1].getItemDamage();
				
				currentDamage= currentDamage - 5;

				slots[1].getItem().setDamage(this.slots[1], currentDamage);
				cookTime++;
				
				if (currentDamage == 0){
					this.cookTime = 0;
					//this.altarItem();
					flag2 = true;
				}
			}else{
				this.cookTime = 0;
				flag3 = true;
			}
			
			if(flag3 != this.isAltaring()){
				flag3=true;
				if(flag){
					OrderShrineBlock.updateBlockState( true, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
				}else{OrderShrineBlock.updateBlockState( false, this.worldObj, this.xCoord, this.yCoord, this.zCoord);}

				}
		}

		if(flag2 || flag3){
			this.markDirty();
		}
	}
}
