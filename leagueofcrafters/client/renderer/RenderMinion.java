package leagueofcrafters.client.renderer;

import leagueofcrafters.entity.EntityMinion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

import org.lwjgl.opengl.GL11;

public class RenderMinion extends RenderLiving {

	private final ResourceLocation tamedMinion = new ResourceLocation("league", "textures/models/minion_tamed.png");
	private final ResourceLocation redMinion = new ResourceLocation("league", "textures/models/minion_untamed.png"); // refers
	private final ResourceLocation blueMinion = new ResourceLocation("league", "textures/models/minion_untamed2.png"); // refers

	protected ModelBase model;
	private float scale;

	public RenderMinion(ModelBase par1ModelBase, float par2, float par3) {
		super(par1ModelBase, par2 * par3);
		model = par1ModelBase;
		this.scale = par3;
		this.renderPassModel = par1ModelBase;
	}

	public RenderMinion(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderMinion(EntityMinion par1EntityMinion, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityMinion, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderMinion((EntityMinion) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected void preRenderScale(EntityMinion par1EntityMinion, float par2) {
		GL11.glScalef(this.scale, this.scale, this.scale);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityMinion) par1EntityLivingBase, par2);
	}

	protected int func_82447_a(EntityMinion par1EntityMinion, int par2, float par3) {
		float f1;
		this.renderPassModel = this.model;
		BiomeGenBase biome = par1EntityMinion.worldObj.getBiomeGenForCoords((int) par1EntityMinion.posX, (int) par1EntityMinion.posZ);
		String name = biome.biomeName;
		if (par2 == 1 && par1EntityMinion.isTamed()) {
			this.bindTexture(tamedMinion);
			f1 = 1.0F;
			int j = par1EntityMinion.getCollarColor();
			GL11.glColor3f(f1 * EntitySheep.fleeceColorTable[j][0], f1 * EntitySheep.fleeceColorTable[j][1], f1 * EntitySheep.fleeceColorTable[j][2]);
			return 1;
		} else if (name.equalsIgnoreCase("iceplains") || name.equalsIgnoreCase("icemountains") || name.equalsIgnoreCase("frozenocean")
				|| name.equalsIgnoreCase("frozenriver") || name.equalsIgnoreCase("taiga") || name.equalsIgnoreCase("taigahills")) {
			this.bindTexture(blueMinion);
			EntityMinion.isBlue = true;
			return 1;
		} else {
			EntityMinion.isBlue = false;
			this.bindTexture(redMinion);
			return -1;
		}
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderMinion((EntityMinion) par1Entity, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.textures((EntityMinion) entity);
	}

	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
		return this.func_82447_a((EntityMinion) par1EntityLivingBase, par2, par3);
	}

	private ResourceLocation textures(EntityMinion par1EntityMinion) {
		return par1EntityMinion.isTamed() ? tamedMinion : redMinion;
	}

}
