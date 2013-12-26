package leagueofcrafters.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemRecord;

public class ItemLeagueDiscs extends ItemRecord {

	public ItemLeagueDiscs(int par1, String soundLocation) {
		super(par1, soundLocation);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.maxStackSize = 1;
	}

	@Override
	public String getRecordTitle() {
		return this.recordName;
	}

}
