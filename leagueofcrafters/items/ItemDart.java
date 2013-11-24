package leagueofcrafters.items;

import leagueofcrafters.LeagueofCrafters;
import leagueofcrafters.client.gui.GuiLeague;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDart extends Item {

	public ItemDart(int par1) {
		super(par1);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("league:dart");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		// par3EntityPlayer.openGui(LeagueofCrafters.instance, 0, par2World, 0,
		// 0, 0);
		return par1ItemStack;

	}

}
