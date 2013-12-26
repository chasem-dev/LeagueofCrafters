package leagueofcrafters.handlers;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StringUtils;

import com.google.common.collect.Maps;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomPotion extends Potion {
	/** The array of potion types. */
	public static final CustomPotion[] potionTypes = new CustomPotion[32];
	public static final CustomPotion field_76423_b = null;

	public static final CustomPotion something = (CustomPotion) (new CustomPotion(8, false, 7889559)).setPotionName("potion.something").setIconIndex(2, 1);

	/** The Id of a Potion object. */
	public final int id;
	private final Map field_111188_I = Maps.newHashMap();

	/**
	 * This field indicated if the effect is 'bad' - negative - for the entity.
	 */
	private final boolean isBadEffect;

	/** Is the color of the liquid for this potion. */
	private final int liquidColor;

	/** The name of the Potion. */
	private String name = "";

	/** The index for the icon displayed when the potion effect is active. */
	private int statusIconIndex = -1;
	private double effectiveness;
	private boolean usable;

	public CustomPotion(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
		this.id = par1;
		potionTypes[par1] = this;
		this.isBadEffect = par2;

		if (par2) {
			this.effectiveness = 0.5D;
		} else {
			this.effectiveness = 1.0D;
		}

		this.liquidColor = par3;
	}

	/**
	 * Sets the index for the icon displayed in the player's inventory when the
	 * status is active.
	 */
	public Potion setIconIndex(int par1, int par2) {
		this.statusIconIndex = par1 + par2 * 8;
		return this;
	}

	/**
	 * returns the ID of the potion
	 */
	public int getId() {
		return this.id;
	}

	public void performEffect(EntityLivingBase par1EntityLivingBase, int par2) {
		if (this.id == regeneration.id) {
			if (par1EntityLivingBase.getHealth() < par1EntityLivingBase.getMaxHealth()) {
				par1EntityLivingBase.heal(1.0F);
			}
		} else if (this.id == poison.id) {
			if (par1EntityLivingBase.getHealth() > 1.0F) {
				par1EntityLivingBase.attackEntityFrom(DamageSource.magic, 1.0F);
			}
		} else if (this.id == wither.id) {
			par1EntityLivingBase.attackEntityFrom(DamageSource.wither, 1.0F);
		} else if (this.id == hunger.id && par1EntityLivingBase instanceof EntityPlayer) {
			((EntityPlayer) par1EntityLivingBase).addExhaustion(0.025F * (float) (par2 + 1));
		} else if (this.id == field_76443_y.id && par1EntityLivingBase instanceof EntityPlayer) {
			if (!par1EntityLivingBase.worldObj.isRemote) {
				((EntityPlayer) par1EntityLivingBase).getFoodStats().addStats(par2 + 1, 1.0F);
			}
		} else if ((this.id != heal.id || par1EntityLivingBase.isEntityUndead()) && (this.id != harm.id || !par1EntityLivingBase.isEntityUndead())) {
			if (this.id == harm.id && !par1EntityLivingBase.isEntityUndead() || this.id == heal.id && par1EntityLivingBase.isEntityUndead()) {
				par1EntityLivingBase.attackEntityFrom(DamageSource.magic, (float) (6 << par2));
			}
		} else {
			par1EntityLivingBase.heal((float) Math.max(4 << par2, 0));
		}
		
	}

	/**
	 * Hits the provided entity with this potion's instant effect.
	 */
	public void affectEntity(EntityLivingBase par1EntityLivingBase, EntityLivingBase par2EntityLivingBase, int par3, double par4) {
		int j;

		if ((this.id != heal.id || par2EntityLivingBase.isEntityUndead()) && (this.id != harm.id || !par2EntityLivingBase.isEntityUndead())) {
			if (this.id == harm.id && !par2EntityLivingBase.isEntityUndead() || this.id == heal.id && par2EntityLivingBase.isEntityUndead()) {
				j = (int) (par4 * (double) (6 << par3) + 0.5D);

				if (par1EntityLivingBase == null) {
					par2EntityLivingBase.attackEntityFrom(DamageSource.magic, (float) j);
				} else {
					par2EntityLivingBase.attackEntityFrom(DamageSource.causeIndirectMagicDamage(par2EntityLivingBase, par1EntityLivingBase), (float) j);
				}
			}
		} else {
			j = (int) (par4 * (double) (4 << par3) + 0.5D);
			par2EntityLivingBase.heal((float) j);
		}
	}

	/**
	 * Returns true if the potion has an instant effect instead of a continuous
	 * one (eg Harming)
	 */
	public boolean isInstant() {
		return false;
	}

	/**
	 * checks if Potion effect is ready to be applied this tick.
	 */
	public boolean isReady(int par1, int par2) {
		int k;

		if (this.id == regeneration.id) {
			k = 50 >> par2;
			return k > 0 ? par1 % k == 0 : true;
		} else if (this.id == poison.id) {
			k = 25 >> par2;
			return k > 0 ? par1 % k == 0 : true;
		} else if (this.id == wither.id) {
			k = 40 >> par2;
			return k > 0 ? par1 % k == 0 : true;
		} else {
			return this.id == hunger.id;
		}
	}

	/**
	 * Set the potion name.
	 */
	public Potion setPotionName(String par1Str) {
		this.name = par1Str;
		return this;
	}

	/**
	 * returns the name of the potion
	 */
	public String getName() {
		return this.name;
	}

	protected Potion setEffectiveness(double par1) {
		this.effectiveness = par1;
		return this;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns true if the potion has a associated status icon to display in then inventory when active.
	 */
	public boolean hasStatusIcon() {
		return this.statusIconIndex >= 0;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns the index for the icon to display when the potion is active.
	 */
	public int getStatusIconIndex() {
		return this.statusIconIndex;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * This method returns true if the potion effect is bad - negative - for the entity.
	 */
	public boolean isBadEffect() {
		return this.isBadEffect;
	}

	@SideOnly(Side.CLIENT)
	public static String getDurationString(PotionEffect par0PotionEffect) {
		if (par0PotionEffect.getIsPotionDurationMax()) {
			return "**:**";
		} else {
			int i = par0PotionEffect.getDuration();
			return StringUtils.ticksToElapsedTime(i);
		}
	}

	public double getEffectiveness() {
		return this.effectiveness;
	}

	public boolean isUsable() {
		return this.usable;
	}

	/**
	 * Returns the color of the potion liquid.
	 */
	public int getLiquidColor() {
		return this.liquidColor;
	}

	public Potion func_111184_a(Attribute par1Attribute, String par2Str, double par3, int par5) {
		AttributeModifier attributemodifier = new AttributeModifier(UUID.fromString(par2Str), this.getName(), par3, par5);
		this.field_111188_I.put(par1Attribute, attributemodifier);
		return this;
	}

	public void removeAttributesModifiersFromEntity(EntityLivingBase par1EntityLivingBase, BaseAttributeMap par2BaseAttributeMap, int par3) {
		Iterator iterator = this.field_111188_I.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			AttributeInstance attributeinstance = par2BaseAttributeMap.getAttributeInstance((Attribute) entry.getKey());

			if (attributeinstance != null) {
				attributeinstance.removeModifier((AttributeModifier) entry.getValue());
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public Map func_111186_k() {
		return this.field_111188_I;
	}

	public void applyAttributesModifiersToEntity(EntityLivingBase par1EntityLivingBase, BaseAttributeMap par2BaseAttributeMap, int par3) {
		Iterator iterator = this.field_111188_I.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			AttributeInstance attributeinstance = par2BaseAttributeMap.getAttributeInstance((Attribute) entry.getKey());

			if (attributeinstance != null) {
				AttributeModifier attributemodifier = (AttributeModifier) entry.getValue();
				attributeinstance.removeModifier(attributemodifier);
				attributeinstance.applyModifier(new AttributeModifier(attributemodifier.getID(), this.getName() + " " + par3, this.func_111183_a(par3,
						attributemodifier), attributemodifier.getOperation()));
			}
		}
	}

	public double func_111183_a(int par1, AttributeModifier par2AttributeModifier) {
		return par2AttributeModifier.getAmount() * (double) (par1 + 1);
	}
}