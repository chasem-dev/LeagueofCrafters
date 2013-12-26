package leagueofcrafters.inventory;

import leagueofcrafters.entity.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class LeagueInventory implements IInventory

{
	/** The name for your custom inventory, possibly just "Inventory" */
	private final String name = "League Inventory";

	/**
	 * In case your inventory name is too generic, define a name to store the
	 * NBT tag in as well
	 */
	private final String tagName = "LeagueSlot";

	/** Define the inventory size here for easy reference */
	// This is also the place to define which slot is which if you have
	// different types,
	// for example SLOT_SHIELD = 0, SLOT_AMULET = 1;
	public static final int INV_SIZE = 15;
	/**
	 * Inventory's size must be same as number of slots you add to the Container
	 * class
	 */
	ItemStack[] inventory = new ItemStack[INV_SIZE];

	public LeagueInventory() {
		// don't need anything here!
	}

	@Override
	public int getSizeInventory() {
		return this.INV_SIZE;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		if (slot > 14)
			slot = 14;
		ItemStack item = inventory[slot];
		//ExtendedPlayer.inventory = this;
		// if(item != null)
		// System.out.println(item.getDisplayName());
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize > amount) {
				stack = stack.splitStack(amount);
				this.onInventoryChanged();
			} else {
				setInventorySlotContents(slot, null);
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		if (slot < 15) {
			inventory[slot] = itemstack;

			if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
				itemstack.stackSize = this.getInventoryStackLimit();

			this.onInventoryChanged();
		}
	}

	@Override
	public String getInvName() {
		return name;
	}

	@Override
	public boolean isInvNameLocalized() {
		return name.length() > 0;
	}

	/**
	 * Our custom slots are similar to armor - only one item per slot
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void onInventoryChanged() {
		for (int i = 9; i < 15; ++i) {
			if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0)
				this.setInventorySlotContents(i, null);
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	/**
	 * This method doesn't seem to do what it claims to do, as items can still
	 * be left-clicked and placed in the inventory even when this returns false
	 */
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return true;
	}

	public void writeToNBT(NBTTagCompound tagcompound) {
		NBTTagList items = new NBTTagList();
		if (this.inventory != null)
			//ExtendedPlayer.inventory = this;
		for (int i = 9; i < 15; ++i) {
			if (getStackInSlot(i) != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("LeagueSlots", (byte) i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}

		// We're storing our items in a custom tag list using our 'tagName' from
		// above
		// to prevent potential conflict
		tagcompound.setTag(tagName, items);
		this.readFromNBT(tagcompound);
	}

	public void readFromNBT(NBTTagCompound tagcompound) {

		if (tagcompound != null) {
			NBTTagList items = tagcompound.getTagList(tagName);
			for (int i = 0; i < items.tagCount(); ++i) {
				NBTTagCompound item = (NBTTagCompound) items.tagAt(i);
				byte slot = item.getByte("LeagueSlots");

				if (slot < 15) {
					setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
				}
			}
		}
	}
}