package leagueofcrafters.entity;

import leagueofcrafters.client.jungleBuffs;
import leagueofcrafters.entity.projectiles.EntityPukeball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityKogmaw extends EntityMob implements IRangedAttackMob {

	public static int timer;
	public static boolean hasBomb;

	public EntityKogmaw(World par1World) {
		super(par1World);
		this.setSize(1, 1);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	@Override
	protected boolean isValidLightLevel() {
		return true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25D);
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2) {
		if (timer <= 0) {
			EntityPukeball entityPukeball = new EntityPukeball(this.worldObj, this);
			double d0 = par1EntityLivingBase.posX - this.posX;
			double d1 = par1EntityLivingBase.posY + (double) par1EntityLivingBase.getEyeHeight() - entityPukeball.posY - 2;
			double d2 = par1EntityLivingBase.posZ - this.posZ;
			float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
			entityPukeball.setThrowableHeading(d0, d1 + (double) f1, d2, 1.6F, 12.0F);
			// this.playSound("random.bow", 1.0F, 1.0F /
			// (this.getRNG().nextFloat() * 0.4F + 0.8F));
			this.worldObj.spawnEntityInWorld(entityPukeball);
			timer = 50;
		}
	}

	public void setAggressive(boolean par1) {
		this.getDataWatcher().updateObject(21, Byte.valueOf((byte) (par1 ? 1 : 0)));
	}

	/**
	 * Return whether this witch is aggressive at an entity.
	 */
	public boolean getAggressive() {
		return this.getDataWatcher().getWatchableObjectByte(21) == 1;
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
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2F, true);
		}
		super.onLivingUpdate();
	}

	@Override
	protected int getDropItemId() {
		return Item.slimeBall.itemID;
	}

	@Override
	protected String getLivingSound() {
		return "league:kogmaw";
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		boolean flag = true;

		if ((float) this.hurtResistantTime > (float) this.maxHurtResistantTime / 2.0F) {
			if (par2 <= this.lastDamage) {
				return false;
			}

			this.damageEntity(par1DamageSource, par2 - this.lastDamage);
			this.lastDamage = par2;
			flag = false;
		} else {
			this.lastDamage = par2;
			this.prevHealth = this.getHealth();
			this.hurtResistantTime = this.maxHurtResistantTime;
			this.damageEntity(par1DamageSource, par2);
			this.hurtTime = this.maxHurtTime = 10;
		}
		if (this.getHealth() <= 0.0F) {
			if (flag) {
				if (par1DamageSource.getSourceOfDamage() instanceof EntityPlayer) {
					//EntityPlayer player = (EntityPlayer) par1DamageSource.getSourceOfDamage();
					// player.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2);
					//jungleBuffs.addLizardBuff(player);
				}
				// this.playSound(this.getDeathSound(), this.getSoundVolume(),
				// this.getSoundPitch());
			}

			this.onDeath(par1DamageSource);
		} else if (flag) {

		}
		return true;
	}

	@Override
	protected String getHurtSound() {
		return "league:kogmaw.hurt";
	}

	@Override
	protected String getDeathSound() {
		return "league:kogmaw.death";
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}
}
