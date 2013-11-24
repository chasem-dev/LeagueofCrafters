package leagueofcrafters.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryItem extends InventoryPlayer {

	public InventoryItem(EntityPlayer par1EntityPlayer) {
		super(par1EntityPlayer);
		this.mainInventory = new ItemStack[43];
	}

	@Override
	public void readFromNBT(NBTTagList items) {
		// Gets the custom taglist we wrote to this compound, if any

		for (int i = 0; i < items.tagCount(); ++i) {
			NBTTagCompound item = (NBTTagCompound) items.tagAt(i);
			int slot = item.getInteger("Slot");

			// Just double-checking that the saved slot index is within our
			// inventory array bounds
			if (slot >= 0 && slot < InventoryItem.getInvSize()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	/**
	 * A custom method to write our inventory to an ItemStack's NBT compound
	 * 
	 * @return
	 */
	@Override
	public NBTTagList writeToNBT(NBTTagList items) {
		// Create a new NBT Tag List to store itemstacks as NBT Tags

		for (int i = 0; i < InventoryItem.getInvSize(); ++i) {
			// Only write stacks that contain items
			if (getStackInSlot(i) != null) {
				// Make a new NBT Tag Compound to write the itemstack and slot
				// index to
				NBTTagCompound item = new NBTTagCompound();
				item.setInteger("Slot", i);
				// Writes the itemstack in slot(i) to the Tag Compound we just
				// made
				getStackInSlot(i).writeToNBT(item);

				// add the tag compound to our tag list
				items.appendTag(item);
			}
		}
		// if (heldItem != null && heldItem.itemID == Item.arrow.itemID) {
		// player.capabilities.allowFlying = true;
		// } else {
		// player.capabilities.allowFlying = player.capabilities.isCreativeMode
		// ? true : false;
		// }
		return items;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		ItemStack[] aitemstack = this.mainInventory;

		if (par1 >= aitemstack.length) {
			par1 -= aitemstack.length;
			aitemstack = this.armorInventory;
		}

		return aitemstack[par1];
	}

	@Override
	public int getSizeInventory() {
		return this.getInvSize();
	}

	public static int getInvSize() {
		return 42;
	}

	@Override
	public String getInvName() {
		return "League Items";
	}
}