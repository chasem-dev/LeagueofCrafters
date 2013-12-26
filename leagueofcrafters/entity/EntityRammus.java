package leagueofcrafters.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityRammus extends EntityMob {
	public static int timer;
	public static boolean shellBoost = false;
	public static boolean checked;

	public EntityRammus(World par1World) {
		super(par1World);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.8D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.0D);
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

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate() {
		if (this.worldObj.isRemote) {
			if (timer == 0) {
				shellBoost = true;
				this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 1));
				timer = 250;
			}

			if (timer != 0)
				timer--;
		}
	}

}
