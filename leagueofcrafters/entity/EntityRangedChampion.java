package leagueofcrafters.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityRangedChampion extends EntityMob implements IRangedAttackMob {

	private int timer;
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);
	public static String name;

	public EntityRangedChampion(World par1World, String name) {
		super(par1World);
		this.setSize(1, 1);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityMinion.class, 0, true));
		if (par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
		this.name = name;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25D);
	}

	@Override
	protected boolean isValidLightLevel() {
		return true;
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	public void setCombatTask() {
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();

		if (itemstack != null && itemstack.itemID == Item.bow.itemID) {
			this.tasks.addTask(4, this.aiArrowAttack);
		} else {
			this.tasks.addTask(4, this.aiAttackOnCollide);
		}
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2) {
		if (par1EntityLivingBase instanceof EntityPlayer || par1EntityLivingBase instanceof EntityMinion) {
			if (timer <= 0) {
				EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 1.6F, (float) (14 - this.worldObj.difficultySetting * 4));
				entityarrow.setDamage((double) (par2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double) ((float) this.worldObj.difficultySetting * 0.11F));
				this.worldObj.spawnEntityInWorld(entityarrow);
				timer = 50;
			}

		} else
			return;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
	}

	public void onLivingUpdate() {
		if (!this.worldObj.isRemote) {
			timer--;
		}
		super.onLivingUpdate();

	}

	@Override
	protected String getLivingSound() {
		return "league:" + this.name;
	}

	@Override
	protected String getHurtSound() {
		return "league:" + this.name + ".hurt";
	}

	@Override
	protected String getDeathSound() {
		return "league:" + this.name + ".death";
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}
}
