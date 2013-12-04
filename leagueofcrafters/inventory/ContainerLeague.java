package leagueofcrafters.inventory;

import leagueofcrafters.items.ItemLeagueArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLeague extends Container {
	/** The Item Inventory for this Container */
	public final LeagueInventory inventory;

	/**
	 * Using these will make transferStackInSlot easier to understand and
	 * implement INV_START is the index of the first slot in the Player's
	 * Inventory, so our InventoryItem's number of slots (e.g. 5 slots is array
	 * indices 0-4, so start at 5) Notice how we don't have to remember how many
	 * slots we made? We can just use InventoryItem.INV_SIZE and if we ever
	 * change it, the Container updates automatically.
	 */

	// If you're planning to add armor slots, put those first like this:
	// ARMOR_START = InventoryItem.INV_SIZE, ARMOR_END = ARMOR_START+3,
	// INV_START = ARMOR_END+1, and then carry on like above.

	public ContainerLeague(EntityPlayer par1Player, InventoryPlayer inventoryPlayer, LeagueInventory inventoryItem) {
		this.inventory = inventoryItem;

		for (int j = 0; j < 6; j++) {
			addSlotToContainer(new SlotLeague(inventoryItem, j + 3 * 3, 35 + j * 18, (1 * 18) + 2));
		}
		bindPlayerInventory(inventoryPlayer);
	}

	private void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 51 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 109));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(par2);

		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			// merges the item into player inventory since its in the tileEntity
			if (par2 < 9) {
				if (!this.mergeItemStack(stackInSlot, 0, 35, true)) {
					return null;
				}
			}
			// places it into the tileEntity is possible since its in the player
			// inventory
			else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
				return null;
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(par1EntityPlayer, stackInSlot);
		}
		return stack;
	}
}