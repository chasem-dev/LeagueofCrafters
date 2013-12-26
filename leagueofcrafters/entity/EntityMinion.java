package leagueofcrafters.entity;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMinion extends EntityTameable {
	private float field_70926_e;
	private float field_70924_f;

	/** true is the Minion is wet else false */
	private boolean isShaking;
	private boolean field_70928_h;

	/**
	 * Defines color
	 */
	public static boolean isBlue;

	/**
	 * This time increases while Minion is shaking and emitting water particles.
	 */
	private float timeMinionIsShaking;
	private float prevTimeMinionIsShaking;

	public EntityMinion(World par1World) {
		super(par1World);
		this.setSize(0.6F, 0.8F);
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 4.0F, 2.0F));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		//this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityMinion.class, 500, false));
		//this.targetTasks.addTask(5, new EntityAITargetNonTamed(this, EntityPlayer.class, 550, false));

		this.setTamed(false);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(8.0D);

	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	public void setAttackTarget(EntityLivingBase par1EntityLivingBase) {
		super.setAttackTarget(par1EntityLivingBase);

		if (par1EntityLivingBase == null) {
			this.setAngry(false);
		} else if (!this.isTamed()) {
			this.setAngry(true);
		}
	}

	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	protected void updateAITick() {
		this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(18, new Float(this.getHealth()));
		this.dataWatcher.addObject(19, new Byte((byte) 0));
		this.dataWatcher.addObject(20, new Byte((byte) BlockColored.getBlockFromDye(1)));
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.Minion.step", 0.15F, 1.0F);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Angry", this.isAngry());
		par1NBTTagCompound.setByte("CollarColor", (byte) this.getCollarColor());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setAngry(par1NBTTagCompound.getBoolean("Angry"));

		if (par1NBTTagCompound.hasKey("CollarColor")) {
			this.setCollarColor(par1NBTTagCompound.getByte("CollarColor"));
		}
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return this.isAngry() ? "mob.Minion.growl"
				: (this.rand.nextInt(3) == 0 ? (this.isTamed() && this.dataWatcher.getWatchableObjectFloat(18) < 10.0F ? "mob.Minion.whine"
						: "mob.Minion.panting") : "mob.Minion.bark");
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.Minion.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.Minion.death";
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId() {
		return -1;
	}

	@SideOnly(Side.CLIENT)
	public float getInterestedAngle(float par1) {
		return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * par1) * 0.15F * (float) Math.PI;
	}

	public float getEyeHeight() {
		return this.height * 0.8F;
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the
	 * faceEntity method. This is only currently use in wolves.
	 */
	public int getVerticalFaceSpeed() {
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity entity = par1DamageSource.getEntity();

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
				par2 = (par2 + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		int i = this.isTamed() ? 1 : 1;
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) i);
	}

	public void setTamed(boolean par1) {
		super.setTamed(par1);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(8.0D);
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer) {
		float health = this.getMaxHealth();
		float current = this.getHealth();
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (this.isTamed()) {
			if (itemstack != null) {
				if (itemstack.itemID == Item.dyePowder.itemID) {
					int i = BlockColored.getBlockFromDye(itemstack.getItemDamage());

					if (i != this.getCollarColor()) {
						this.setCollarColor(i);

						if (!par1EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0) {
							par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
						}

						return true;
					}
				}
			}

			if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote) {
				this.isJumping = false;
				this.setPathToEntity((PathEntity) null);
				this.setTarget((Entity) null);
				this.setAttackTarget((EntityLivingBase) null);
			}
		} else if (itemstack != null && (itemstack.getItem() instanceof ItemSword) && !this.isAngry()) {
			if (itemstack.stackSize <= 0) {
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
			}

			if (!this.worldObj.isRemote) {
				this.setTamed(true);
				this.setPathToEntity((PathEntity) null);
				this.setAttackTarget((EntityLivingBase) null);
				this.setHealth(8.0F);
				this.setOwner(par1EntityPlayer.getCommandSenderName());
				this.playTameEffect(true);
				this.worldObj.setEntityState(this, (byte) 7);
			}

			return true;
		}

		return super.interact(par1EntityPlayer);
	}

	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1) {
		if (par1 == 8) {
			this.field_70928_h = true;
			this.timeMinionIsShaking = 0.0F;
			this.prevTimeMinionIsShaking = 0.0F;
		} else {
			super.handleHealthUpdate(par1);
		}
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	public int getMaxSpawnedInChunk() {
		return 8;
	}

	/**
	 * Determines whether this Minion is angry or not.
	 */
	public boolean isAngry() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	}

	/**
	 * Sets whether this Minion is angry or not.
	 */
	public void setAngry(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 2)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -3)));
		}
	}

	/**
	 * Return this Minion's collar color.
	 */
	public int getCollarColor() {
		return this.dataWatcher.getWatchableObjectByte(20) & 15;
	}

	/**
	 * Set this Minion's collar color.
	 */
	public void setCollarColor(int par1) {
		this.dataWatcher.updateObject(20, Byte.valueOf((byte) (par1 & 15)));
	}

	public void func_70918_i(boolean par1) {
		if (par1) {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 1));
		} else {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 0));
		}
	}

	public boolean func_70922_bv() {
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	protected boolean canDespawn() {
		return !this.isTamed() && this.ticksExisted > 2400;
	}

	public boolean func_142018_a(EntityLivingBase par1EntityLivingBase, EntityLivingBase par2EntityLivingBase) {
		if (!(par1EntityLivingBase instanceof EntityCreeper) && !(par1EntityLivingBase instanceof EntityGhast)) {
			if (par1EntityLivingBase instanceof EntityMinion) {
				EntityMinion entityMinion = (EntityMinion) par1EntityLivingBase;

				if (entityMinion.isTamed() && entityMinion.func_130012_q() == par2EntityLivingBase) {
					return false;
				}
			}

			return par1EntityLivingBase instanceof EntityPlayer && par2EntityLivingBase instanceof EntityPlayer
					&& !((EntityPlayer) par2EntityLivingBase).canAttackPlayer((EntityPlayer) par1EntityLivingBase) ? false
					: !(par1EntityLivingBase instanceof EntityHorse) || !((EntityHorse) par1EntityLivingBase).isTame();
		} else {
			return false;
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
		return null;
	}
}
