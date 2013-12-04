package leagueofcrafters.client.renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import leagueofcrafters.entity.projectiles.EntityKnife;
import leagueofcrafters.client.models.ModelKnife;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderKnife extends RenderLiving {

	private final ResourceLocation texture = new ResourceLocation("league", "textures/models/mundo.png"); // refers
	protected ModelKnife model;

	public RenderKnife(ModelKnife par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = par1ModelBase;
	}

	public RenderKnife(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderKnife(EntityKnife par1EntityKnife, double x, double y, double z, float par8, float par9) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180, 1, 0, 1);
		bindEntityTexture(par1EntityKnife);
		RenderHelper.enableStandardItemLighting();
		GL11.glPushMatrix();
		float factor = (float) (1.0 / 16.0);
		model.render(par1EntityKnife, factor, factor, factor, factor, factor, factor);
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
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
		this.renderKnife((EntityKnife) par1Entity, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
