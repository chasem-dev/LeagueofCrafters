package leagueofcrafters;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class tabLeagueofCrafters extends CreativeTabs {

	public tabLeagueofCrafters(int id, String name) {
		super(id, name);

	}

	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return new ItemStack(LeagueItems.bomb.itemID, 1, 0);
	}

	public String getTranslatedTabLabel() {
		return "League of Crafters";
	}

}
