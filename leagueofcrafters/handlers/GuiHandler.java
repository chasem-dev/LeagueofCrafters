package leagueofcrafters.handlers;

import leagueofcrafters.LeagueofCrafters;
import leagueofcrafters.client.gui.GuiLeague;
import leagueofcrafters.inventory.ContainerLeague;
import leagueofcrafters.inventory.LeagueInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(LeagueofCrafters.instance, this);
	}

	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
		// Hooray, no 'magic' numbers - we know exactly which Gui this refers to
		if (guiId == LeagueofCrafters.ItemInventoryGuiIndex) {
			// Use the player's held item to create the inventory
			return new ContainerLeague(player, player.inventory, new LeagueInventory());
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
		if (guiId == LeagueofCrafters.ItemInventoryGuiIndex) {
			// We have to cast the new container as our custom class
			// and pass in currently held item for the inventory
			return new GuiLeague((ContainerLeague) new ContainerLeague(player, player.inventory, new LeagueInventory()));
		}
		return null;
	}
}