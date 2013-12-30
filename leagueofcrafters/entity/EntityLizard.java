package leagueofcrafters.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityLizard extends EntityMeleeChampion {

	public static int timer;

	public EntityLizard(World par1World) {
		super(par1World, name);
		this.name = "lizard";
	}

	public void onLivingUpdate() {
		if (!this.worldObj.isRemote && this.timer > 0) {
			timer--;
		} else if (this.timer < 0) {
			this.timer = 0;
		}

		if (this.rand.nextFloat() < 7.5E-4F) {
			this.worldObj.setEntityState(this, (byte) 15);
		}
		if (this.isDead) {
			EntityPlayer player = (EntityPlayer) this.getLastAttacker();
			if (player != null)
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 3000, 1));
		}
		super.onLivingUpdate();
	}
}
