package leagueofcrafters.entity;

import java.util.Iterator;
import java.util.List;

import leagueofcrafters.LeagueofCrafters;
import leagueofcrafters.entity.projectiles.EntityFire;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityAnnie extends EntityMob implements IRangedAttackMob {

	public static int timer;

	public EntityAnnie(World par1World) {
		super(par1World);
		this.setSize(1, 1);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMinion.class, 0, true));

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
			EntityFire entityarrow = new EntityFire(this.worldObj, this, par1EntityLivingBase, 1.6F, (float) (14 - this.worldObj.difficultySetting * 4));
			entityarrow.setPosition(this.posX, this.posY, this.posZ);
			this.worldObj.spawnEntityInWorld(entityarrow);
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

		super.onLivingUpdate();
	}

	@Override
	protected int getDropItemId() {
		return Item.gunpowder.itemID;
	}

	@Override
	protected String getLivingSound() {
		return "league:annie";
	}

	@Override
	protected String getHurtSound() {
		return "league:annie.hurt";
	}

	@Override
	protected String getDeathSound() {
		return "league:annie.death";
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}
}
