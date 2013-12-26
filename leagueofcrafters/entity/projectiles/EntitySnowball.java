package leagueofcrafters.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySnowball extends EntityThrowable {
	public EntitySnowball(World par1World) {
		super(par1World);
	}

	public EntitySnowball(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}

	public EntitySnowball(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null)
			if (par1MovingObjectPosition.entityHit instanceof EntityLivingBase) {
				EntityLivingBase player = (EntityLivingBase) par1MovingObjectPosition.entityHit;
				if (par1MovingObjectPosition.entityHit != this.getThrower()) {
					player.attackEntityFrom(DamageSource.causeMobDamage(this.getThrower()), 2);
					player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1));
					this.setDead();
				}
			}

		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}
