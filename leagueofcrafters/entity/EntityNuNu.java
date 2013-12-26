package leagueofcrafters.entity;

import leagueofcrafters.entity.projectiles.EntityPukeball;
import leagueofcrafters.entity.projectiles.EntitySnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityNuNu extends EntityMob implements IRangedAttackMob {

	public static int timer;

	public EntityNuNu(World par1World) {
		super(par1World);
		this.setSize(2, 4);
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 5, 10.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	protected Entity findPlayerToAttack() {
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
	}

	@Override
	public void onLivingUpdate() {
		if (!this.worldObj.isRemote && this.timer > 0) {
			timer--;
		}
		if (this.timer == 0) {
			this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 5, 10.0F));
			EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
			if (entityplayer != null)
				this.attackEntityWithRangedAttack(entityplayer, 1);

		}
		super.onLivingUpdate();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.23D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2D);

	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float f) {
		if (timer == 0) {
			EntitySnowball entityPukeball = new EntitySnowball(this.worldObj, this);
			double d0 = entitylivingbase.posX - this.posX;
			double d1 = entitylivingbase.posY + (double) entitylivingbase.getEyeHeight() - entityPukeball.posY - 2;
			double d2 = entitylivingbase.posZ - this.posZ;
			float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
			entityPukeball.setThrowableHeading(d0, d1 + (double) f1, d2, 1.6F, 12.0F);
			this.worldObj.spawnEntityInWorld(entityPukeball);

			timer = 250;

		} else {
			// PathPoint[] point = new PathPoint[(int) entitylivingbase.posX];
			// this.setPathToEntity(new PathEntity(point));
			// this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.attackEntityAsMob(entitylivingbase);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		if (timer > 0) {
			boolean flag = super.attackEntityAsMob(par1Entity);

			if (flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float) this.worldObj.difficultySetting * 0.3F) {
				par1Entity.setFire(2 * this.worldObj.difficultySetting);
			}

			return flag;
		} else {
			this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 5, 10.0F));
			this.attackEntityWithRangedAttack((EntityLivingBase) par1Entity, 1);
		}
		return false;
	}
}
