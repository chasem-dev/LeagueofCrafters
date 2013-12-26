package leagueofcrafters.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFreljordBerry extends ItemFood {

	public ItemFreljordBerry(int par1, int par2, boolean par3) {
		super(par1, par2, par3);
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		--par1ItemStack.stackSize;
		par3EntityPlayer.getFoodStats().addStats(this);
		par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 0));
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 0));

		return par1ItemStack;
	}
}
