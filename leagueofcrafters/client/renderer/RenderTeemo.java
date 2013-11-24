package leagueofcrafters.client.renderer;

import java.util.Random;

import leagueofcrafters.client.models.ModelTeemo;
import leagueofcrafters.entity.EntityTeemo;
import leagueofcrafters.handlers.RandomHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderTeemo extends RenderLiving {

	private final ResourceLocation texture = new ResourceLocation("league", "textures/models/teemo.png"); // refers
	private final ResourceLocation texture2 = new ResourceLocation("league", "textures/models/teemo2.png"); // refers
	private int num = RandomHelper.getRandomNumberBetween(0, 100);

	protected ModelTeemo model;
	private float scale;

	public RenderTeemo(ModelTeemo par1ModelBase, float par2, float par3) {
		super(par1ModelBase, par2 * par3);
		model = par1ModelBase;
		this.scale = par3;
	}

	public void renderTeemo(EntityTeemo par1EntityTeemo, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityTeemo, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderTeemo((EntityTeemo) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected void preRenderScale(EntityTeemo par1EntityTeemo, float par2) {
		GL11.glScalef(this.scale, this.scale, this.scale);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityTeemo) par1EntityLivingBase, par2);
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
		this.renderTeemo((EntityTeemo) par1Entity, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		int num1 = RandomHelper.getRandomNumberBetween(0, 100);
		return texture;
	}

}
