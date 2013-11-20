package leagueofcrafters.items;

import leagueofcrafters.LeagueofCrafters;
import leagueofcrafters.entity.EntityBomb;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemCannon extends Item {
	public static final String[] cannonPullIconNameArray = new String[] { "0", "1", "2", "3" };
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	private Entity player;
	private int iconNum;

	public ItemCannon(int par1) {
		super(par1);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}

	/**
	 * called when the player releases the use item button. Args: itemstack,
	 * world, entityplayer, itemInUseCount
	 */
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return;
		}
		j = event.charge;

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

		if (flag || par3EntityPlayer.inventory.hasItem(LeagueofCrafters.bomb.itemID)) {
			float f = (float) j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double) f < 0.1D) {
				return;
			}

			if (f > 1.0F) {
				f = 1.0F;
			}

			EntityBomb entityBomb = new EntityBomb(par2World, par3EntityPlayer, f * 1.0F);

			if (f == 1.0F) {
				entityBomb.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

			if (k > 0) {
				entityBomb.setDamage(entityBomb.getDamage() + (double) k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

			if (l > 0) {
				entityBomb.setKnockbackStrength(l);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) {
				entityBomb.setFire(100);
			}

			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "fireworks.blast1", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag) {
				entityBomb.canBePickedUp = 2;
			} else {
				par3EntityPlayer.inventory.consumeInventoryItem(LeagueofCrafters.bomb.itemID);
			}

			if (!par2World.isRemote) {
				entityBomb.setPosition(par3EntityPlayer.posX, par3EntityPlayer.posY + 3, par3EntityPlayer.posZ);
				par2World.spawnEntityInWorld(entityBomb);
			}
		}
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		return par1ItemStack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return event.result;
		}

		if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(LeagueofCrafters.bomb.itemID)) {
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
			// itemInUseCount = this.getMaxItemUseDuration(par1ItemStack);
		}

		return par1ItemStack;
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	public int getItemEnchantability() {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("league:" + "cannon_0");
		this.iconArray = new Icon[cannonPullIconNameArray.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("league:" + "cannon_" + cannonPullIconNameArray[i]);
		}
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if (par3Entity instanceof EntityPlayer) {
			player = par3Entity;
			int max = this.getMaxItemUseDuration(par1ItemStack);
			int itemUseCount = ((EntityPlayer) par3Entity).getItemInUseCount();
			this.getItemIcon(par1ItemStack, par4);
			if (((EntityPlayer) par3Entity).getHeldItem().itemID == this.itemID) {
				if (((EntityPlayer) par3Entity).getItemInUseCount() != 0)
					this.itemIcon = this.iconArray[iconNum];
				else {
					this.itemIcon = this.iconArray[0];
				}
			} else {
				this.itemIcon = this.iconArray[0];
			}
		}
	}

	public Icon getItemIcon(ItemStack par1ItemStack, int par2) {
		Icon icon = super.getIcon(par1ItemStack, par2);
		int j = this.getMaxItemUseDuration(par1ItemStack) - ((EntityPlayer) player).getItemInUseCount();

		if (player instanceof EntityPlayer)

			if (((EntityPlayer) player).getHeldItem().itemID == this.itemID) {

				if (j >= 18) {
					return this.getItemIconForUseDuration(3);
				}

				if (j > 13) {
					return this.getItemIconForUseDuration(2);
				}

				if (j > 0) {
					return this.getItemIconForUseDuration(1);
				} else {
					return this.getItemIconForUseDuration(0);
				}
			} else {
				return par1ItemStack.getItem().getIconFromDamage(0);
			}
		icon = par1ItemStack.getItem().getIcon(par1ItemStack, par2, (EntityPlayer) player, ((EntityPlayer) player).getItemInUse(),
				((EntityPlayer) player).getItemInUseCount());

		return icon;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * used to cycle through icons based on their used duration, i.e. for the cannon
	 */
	public Icon getItemIconForUseDuration(int par1) {
		iconNum = par1;
		return this.iconArray[par1];
	}
}
