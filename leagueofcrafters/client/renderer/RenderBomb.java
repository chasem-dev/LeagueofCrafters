package leagueofcrafters.client.renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import leagueofcrafters.entity.EntityBomb;
import leagueofcrafters.client.models.ModelBomb;
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

public class RenderBomb extends RenderLiving {

	private final ResourceLocation texture = new ResourceLocation("league", "textures/models/bomb.png"); // refers
	protected ModelBomb model;

	public RenderBomb(ModelBomb par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = par1ModelBase;
	}

	public RenderBomb(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderBomb(EntityBomb par1EntityBomb, double x, double y, double z, float par8, float par9) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180, 1, 0, 1);
		bindEntityTexture(par1EntityBomb);
		RenderHelper.enableStandardItemLighting();
		GL11.glPushMatrix();
		float factor = (float) (1.0 / 16.0);
		//model.setRotationAngles(par1EntityBomb.rotationPitch, par1EntityBomb.rotationYaw);
		model.render(par1EntityBomb, factor, factor, factor, factor, factor, factor);
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
		this.renderBomb((EntityBomb) par1Entity, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
