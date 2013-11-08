package leagueofcrafters.items;

import leagueofcrafters.entity.EntityBomb;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCannon extends Item {

	public ItemCannon(int par1) {
		super(par1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		EntityBomb bomb = new EntityBomb(par2World, par3EntityPlayer.posX + 1, par3EntityPlayer.posY = 2, par3EntityPlayer.posZ + 1);
		par2World.spawnEntityInWorld(bomb);
		return par1ItemStack;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("league:bomb");
	}

}
