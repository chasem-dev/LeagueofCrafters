package leagueofcrafters.entity;

import leagueofcrafters.LeagueofCrafters;
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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class EntityTeemo extends EntityMob implements IRangedAttackMob {

	private int timer;

	public EntityTeemo(World par1World) {
		super(par1World);
		this.setSize(1, 1);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
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

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2) {
		if (par1EntityLivingBase instanceof EntityPlayer) {
			if (!((EntityPlayer) par1EntityLivingBase).capabilities.isCreativeMode) {
				if (timer <= 0) {
					EntityDart entityarrow = new EntityDart(this.worldObj, this, par1EntityLivingBase, 1.6F, (float) (14 - this.worldObj.difficultySetting * 4));
					entityarrow.setDamage((double) (par2 * 2.0F) + this.rand.nextGaussian() * 0.25D
							+ (double) ((float) this.worldObj.difficultySetting * 0.11F));
					this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
					this.worldObj.spawnEntityInWorld(entityarrow);
					timer = 300;
				}
			}
		} else
			return;
	}

	@Override
	protected int getDropItemId() {
		return LeagueofCrafters.dart.itemID;
	}

	public void onLivingUpdate() {
		if (!this.worldObj.isRemote) {
			timer--;
		}
		super.onLivingUpdate();

	}

	@Override
	protected String getLivingSound() {
		return "league:teemo";
	}

	@Override
	protected String getHurtSound() {
		return "league:teemohurt";
	}

	@Override
	protected String getDeathSound() {
		return "league:teemodeath";
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}
}
