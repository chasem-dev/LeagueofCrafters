package leagueofcrafters.items;

import leagueofcrafters.LeagueofCrafters;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLeague extends Item {
	public Icon icon;
	private String texture;
	public static int abilityNum;
	private boolean checked;
	public static ItemStack itemStack;
	public static int currentHealth;

	public ItemLeague(int par1, String texturePath, int numToAdd) {
		super(par1);
		this.abilityNum = numToAdd;
		texture = texturePath;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("league:" + texture);
		icon = this.itemIcon;
	}

	//@Override
	//public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
	//	EntityPlayer player = null;
	//	itemStack = par1ItemStack;
	//	if (par3Entity != null)
	//		if (par3Entity instanceof EntityPlayer) {
	//			player = (EntityPlayer) par3Entity;
	//			int HEALTH = 20;
	//		if (player.inventory.hasItem(this.itemID)) {
	//				if (checked == false) {
	//					HEALTH += this.abilityNum;
	//					checked = true;
	//					currentHealth = HEALTH;
	////				}
	///			} else {
	//				currentHealth = 20;
	//			}
	//			// if (player.inventory.hasItem(LeagueofCrafters.warmogs)) {
				// HEALTH += 10;
				// } else {
				// HEALTH -= 10;
				// }
	///			((EntityLivingBase) player).getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(currentHealth);
	//		}
	//}
}
