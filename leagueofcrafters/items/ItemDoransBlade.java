package leagueofcrafters.items;

import leagueofcrafters.DamageHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class ItemDoransBlade extends ItemSword {

	public ItemDoransBlade(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		/**if (par3Entity instanceof EntityPlayer) {
			if (((EntityPlayer) par3Entity).getHeldItem() == par1ItemStack) {
				((EntityLivingBase) par3Entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(21.0D);
			} else {
				((EntityLivingBase) par3Entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
			}
			if (DamageHandler.damageDealt != 0 && DamageHandler.damageDealt < 0) {
				if (((EntityPlayer) par3Entity).getHealth() != (((EntityPlayer) par3Entity).getMaxHealth())
						&& ((EntityPlayer) par3Entity).getHealth() < (((EntityPlayer) par3Entity).getMaxHealth()))
					((EntityPlayer) par3Entity).setHealth(((EntityPlayer) par3Entity).getHealth() + 1);
			} else {
				return;
			}
		}
**/
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("league:doransblade");
	}

}
