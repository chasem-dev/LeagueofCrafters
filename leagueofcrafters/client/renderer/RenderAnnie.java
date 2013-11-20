package leagueofcrafters.client.renderer;

import leagueofcrafters.client.models.ModelAnnie;
import leagueofcrafters.entity.EntityAnnie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderAnnie extends RenderLiving {

	private final ResourceLocation texture = new ResourceLocation("league", "textures/models/annie.png"); // refers
	protected ModelAnnie model;
	private float scale;

	public RenderAnnie(ModelAnnie par1ModelBase, float par2, float par3) {
		super(par1ModelBase, par2 * par3);
		model = par1ModelBase;
		this.scale = par3;
	}

	public void renderAnnie(EntityAnnie par1EntityAnnie, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityAnnie, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderAnnie((EntityAnnie) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected void preRenderScale(EntityAnnie par1EntityAnnie, float par2) {
		GL11.glScalef(0.875F, 0.875F, 0.875F);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityAnnie) par1EntityLivingBase, par2);
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
		this.renderAnnie((EntityAnnie) par1Entity, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
