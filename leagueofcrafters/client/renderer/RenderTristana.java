package leagueofcrafters.client.renderer;

import org.lwjgl.opengl.GL11;

import leagueofcrafters.entity.EntityTristana;
import leagueofcrafters.entity.EntityTristana;
import leagueofcrafters.client.models.ModelTristana;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderTristana extends RenderLiving {

	private final ResourceLocation texture = new ResourceLocation("league", "textures/models/tristana.png"); // refers
	protected ModelTristana model;
	private float scale;

	public RenderTristana(ModelTristana par1ModelBase, float par2, float par3) {
		super(par1ModelBase, par2 * par3);
		model = par1ModelBase;
		this.scale = par3;
	}

	public RenderTristana(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderTristana(EntityTristana par1EntityTristana, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityTristana, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderTristana((EntityTristana) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected void preRenderScale(EntityTristana par1EntityTristana, float par2) {
		GL11.glScalef(this.scale, this.scale, this.scale);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityTristana) par1EntityLivingBase, par2);
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
		this.renderTristana((EntityTristana) par1Entity, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
